package com.nendrasys.core.enventListener;

import de.hybris.platform.orderprocessing.events.OrderProcessingEvent;
import de.hybris.platform.orderprocessing.model.OrderProcessModel;

public class OrderReceivedEvent extends OrderProcessingEvent {
    public OrderReceivedEvent(final OrderProcessModel process) {

        super(process);
    }
}
