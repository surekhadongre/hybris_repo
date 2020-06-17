package com.nendrasys.facades.payment.impl;

import de.hybris.platform.acceleratorfacades.flow.impl.DefaultCheckoutFlowFacade;
import de.hybris.platform.acceleratorfacades.flow.impl.SessionOverrideCheckoutFlowFacade;
import de.hybris.platform.acceleratorfacades.order.impl.DefaultAcceleratorCheckoutFacade;
import de.hybris.platform.commercefacades.order.impl.DefaultCheckoutFacade;
import de.hybris.platform.commerceservices.service.data.CommerceCheckoutParameter;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.order.payment.CreditCardPaymentInfoModel;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import org.apache.commons.lang.StringUtils;

public class NendrasysDefaultCheckoutFacade extends DefaultAcceleratorCheckoutFacade {
    @Override
    public boolean authorizePayment(final String securityCode) {
        final CartModel cartModel = getCart();
        final CreditCardPaymentInfoModel creditCardPaymentInfoModel = cartModel == null ? null
                : (CreditCardPaymentInfoModel) cartModel.getPaymentInfo();
        if (checkIfCurrentUserIsTheCartUser() && creditCardPaymentInfoModel != null
                && StringUtils.isNotBlank(creditCardPaymentInfoModel.getSubscriptionId()))
        {
            final CommerceCheckoutParameter parameter = createCommerceCheckoutParameter(cartModel, true);
            parameter.setSecurityCode(securityCode);
            parameter.setPaymentProvider(getPaymentProvider());
            final PaymentTransactionEntryModel paymentTransactionEntryModel = getCommerceCheckoutService()
                    .authorizePayment(parameter);

            return paymentTransactionEntryModel != null
                    && (TransactionStatus.ACCEPTED.name().equals(paymentTransactionEntryModel.getTransactionStatus())
                    || TransactionStatus.REVIEW.name().equals(paymentTransactionEntryModel.getTransactionStatus())
                    || TransactionStatus.MANUAL_INTERVENTION_NEEDED.name().equals(paymentTransactionEntryModel.getTransactionStatus()));
        }
        return false;
    }
}
