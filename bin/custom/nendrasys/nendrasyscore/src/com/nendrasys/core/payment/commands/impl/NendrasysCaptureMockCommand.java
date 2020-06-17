package com.nendrasys.core.payment.commands.impl;

import de.hybris.platform.payment.commands.impl.CaptureMockCommand;
import de.hybris.platform.payment.commands.request.CaptureRequest;
import de.hybris.platform.payment.commands.result.CaptureResult;
import de.hybris.platform.payment.dto.TransactionStatus;

public class NendrasysCaptureMockCommand extends CaptureMockCommand {
    @Override
    public CaptureResult perform(final CaptureRequest request) {
        final CaptureResult result = super.perform(request);
        if(request.getTotalAmount().longValue() >= 4000L)
            result.setTransactionStatus(TransactionStatus.MANUAL_INTERVENTION_NEEDED);
        return result;
    }
}
