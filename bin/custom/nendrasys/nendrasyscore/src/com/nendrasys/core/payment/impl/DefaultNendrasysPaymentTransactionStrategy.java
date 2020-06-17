package com.nendrasys.core.payment.impl;

import com.nendrasys.core.payment.NendrasysPaymentTransactionStrategy;
import de.hybris.platform.acceleratorservices.payment.cybersource.strategies.impl.DefaultPaymentTransactionStrategy;
import de.hybris.platform.acceleratorservices.payment.data.OrderInfoData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.dto.TransactionStatusDetails;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.payment.model.PaymentTransactionModel;

import java.util.Date;
import java.util.UUID;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;

public class DefaultNendrasysPaymentTransactionStrategy extends DefaultPaymentTransactionStrategy implements NendrasysPaymentTransactionStrategy {
    @Override
    public PaymentTransactionEntryModel savePaymentTransactionEntry(final CustomerModel customerModel, final String requestId, final OrderInfoData orderInfoData, final String responseCode) {
        validateParameterNotNull(orderInfoData, "orderInfoData cannot be null");

        final PaymentTransactionModel transaction = getModelService().create(PaymentTransactionModel.class);
        final PaymentTransactionType paymentTransactionType = PaymentTransactionType.CREATE_SUBSCRIPTION;
        transaction.setCode(customerModel.getUid() + "_" + UUID.randomUUID());
        transaction.setRequestId(requestId);
        transaction.setRequestToken(orderInfoData.getOrderPageRequestToken());
        transaction.setPaymentProvider(getCommerceCheckoutService().getPaymentProvider());
        getModelService().save(transaction);

        final PaymentTransactionEntryModel entry =super.savePaymentTransactionEntry(customerModel,requestId,orderInfoData);

        /*entry.setType(paymentTransactionType);
        entry.setRequestId(requestId);
        entry.setRequestToken(orderInfoData.getOrderPageRequestToken());
        entry.setTime(new Date());
        entry.setPaymentTransaction(transaction);
        entry.setTransactionStatus(TransactionStatus.ACCEPTED.name());
        entry.setTransactionStatusDetails(TransactionStatusDetails.SUCCESFULL.name());
        entry.setCode(getPaymentService().getNewPaymentTransactionEntryCode(transaction, paymentTransactionType));

         */
        //responseCode
        entry.setResponseCode(responseCode);
        getModelService().save(entry);
        return entry;
    }
}
