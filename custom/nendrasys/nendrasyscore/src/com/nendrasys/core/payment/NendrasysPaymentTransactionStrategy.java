package com.nendrasys.core.payment;

import de.hybris.platform.acceleratorservices.payment.data.OrderInfoData;
import de.hybris.platform.acceleratorservices.payment.strategies.PaymentTransactionStrategy;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;

public interface NendrasysPaymentTransactionStrategy extends PaymentTransactionStrategy {
    PaymentTransactionEntryModel savePaymentTransactionEntry(CustomerModel customerModel, String requestId,
                                                             OrderInfoData orderInfoData, String responseCode);
}
