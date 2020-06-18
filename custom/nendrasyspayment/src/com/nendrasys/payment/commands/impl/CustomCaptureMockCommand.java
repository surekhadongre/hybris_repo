package com.nendrasys.payment.commands.impl;

import de.hybris.platform.payment.commands.impl.CaptureMockCommand;
import de.hybris.platform.payment.commands.request.CaptureRequest;
import de.hybris.platform.payment.commands.result.CaptureResult;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.dto.TransactionStatusDetails;

import java.util.Date;

public class CustomCaptureMockCommand extends CaptureMockCommand {

    @Override
    public CaptureResult perform(final CaptureRequest request) {
        final CaptureResult result = new CaptureResult();
        result.setCurrency(request.getCurrency());
        result.setTotalAmount(request.getTotalAmount());
        result.setRequestTime(new Date());
        if(request.getTotalAmount().longValue() >= 4000L)
            result.setTransactionStatus(TransactionStatus.MANUAL_INTERVENTION_NEEDED);
        else
            result.setTransactionStatus(TransactionStatus.ACCEPTED);
        result.setTransactionStatusDetails(TransactionStatusDetails.SUCCESFULL);
        this.genericPerform(request, result);
        return result;
    }
}
