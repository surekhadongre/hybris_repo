package com.nendrasys.fulfilmentprocess.actions.orderReceived;

import com.nendrasys.core.enventListener.OrderReceivedEvent;
import de.hybris.platform.orderprocessing.model.OrderProcessModel;
import de.hybris.platform.orderprocessing.model.OrderReceivedProcessModel;
import de.hybris.platform.processengine.action.AbstractProceduralAction;
import de.hybris.platform.servicelayer.event.EventService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

public class OrderReceivedEmailNotificationAction extends AbstractProceduralAction<OrderProcessModel> {
    private static final Logger LOG = Logger.getLogger(OrderReceivedEmailNotificationAction.class);

    private EventService eventService;

    @Override
    public void executeAction(final OrderProcessModel process)
    {
       // final OrderProcessModel processModel = (OrderProcessModel)process;
        getEventService().publishEvent(new OrderReceivedEvent(process));
        LOG.info("Process: " + process.getCode() + " in step " + getClass());
    }

    protected EventService getEventService()
    {
        return this.eventService;
    }

    @Required
    public void setEventService(final EventService eventService)
    {
        this.eventService = eventService;
    }

}
