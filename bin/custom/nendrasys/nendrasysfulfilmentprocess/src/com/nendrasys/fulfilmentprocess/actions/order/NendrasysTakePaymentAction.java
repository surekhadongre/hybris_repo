package com.nendrasys.fulfilmentprocess.actions.order;

import com.nendrasys.fulfilmentprocess.actions.consignment.ReceiveConsignmentStatusAction;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.order.payment.CreditCardPaymentInfoModel;
import de.hybris.platform.orderprocessing.model.OrderProcessModel;
import de.hybris.platform.payment.PaymentService;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.payment.model.PaymentTransactionModel;
import de.hybris.platform.processengine.action.AbstractAction;
import de.hybris.platform.processengine.action.AbstractSimpleDecisionAction;
import de.hybris.platform.task.RetryLaterException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NendrasysTakePaymentAction extends AbstractAction<OrderProcessModel> {
    private static final Logger LOG = Logger.getLogger(NendrasysTakePaymentAction.class);

    private PaymentService paymentService;

    public PaymentService getPaymentService() {
        return this.paymentService;
    }

    @Required
    public void setPaymentService(final PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public enum Transition
    {
        OK, NOK, MANUAL_INTERVENTION_NEEDED;

        public static Set<String> getStringValues()
        {
            final Set<String> res = new HashSet<String>();

            for (final Transition transition : Transition.values())
            {
                res.add(transition.toString());
            }
            return res;
        }
    }


    @Override
    public String execute(final OrderProcessModel process) throws RetryLaterException, Exception {
        LOG.info("Process: " + process.getCode() + " in step " + getClass());
        final OrderModel order = process.getOrder();

        for (final PaymentTransactionModel txn : order.getPaymentTransactions())
        {
            if (txn.getInfo() instanceof CreditCardPaymentInfoModel)
            {
                final PaymentTransactionEntryModel txnEntry = getPaymentService().capture(txn);

                if (TransactionStatus.ACCEPTED.name().equals(txnEntry.getTransactionStatus()))
                {
                    if (LOG.isDebugEnabled())
                    {
                        LOG.debug("The payment transaction has been captured. Order: " + order.getCode() + ". Txn: " + txn.getCode());
                    }
                    setOrderStatus(order, OrderStatus.PAYMENT_CAPTURED);
                }
                else if(TransactionStatus.MANUAL_INTERVENTION_NEEDED.name().equals(txnEntry.getTransactionStatus())){
                    if (LOG.isDebugEnabled())
                    {
                        LOG.debug("Manual Intervention needed for payment transaction. Order: " + order.getCode() + ". Txn: " + txn.getCode());
                    }
                    return Transition.MANUAL_INTERVENTION_NEEDED.toString();
                }
                else
                {
                    LOG.error("The payment transaction capture has failed. Order: " + order.getCode() + ". Txn: " + txn.getCode());
                    setOrderStatus(order, OrderStatus.PAYMENT_NOT_CAPTURED);
                    return Transition.NOK.toString();
                }
            }
        }
        return Transition.OK.toString();
    }

    @Override
    public Set<String> getTransitions() {
        return Transition.getStringValues();
    }
}
