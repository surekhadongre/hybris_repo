package com.nendrasys.facades.payment;

import de.hybris.platform.acceleratorservices.payment.cybersource.converters.populators.response.AbstractResultPopulator;
import de.hybris.platform.acceleratorservices.payment.data.CreateSubscriptionResult;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.util.Map;

public class ResponseCodePopulator extends AbstractResultPopulator<Map<String, String>, CreateSubscriptionResult> {
    @Override
    public void populate(final Map<String, String> source, final CreateSubscriptionResult target) throws ConversionException {
        target.setResponseCode(source.get("responseCode"));
    }
}
