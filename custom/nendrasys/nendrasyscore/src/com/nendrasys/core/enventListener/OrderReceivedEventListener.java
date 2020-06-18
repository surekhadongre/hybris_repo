package com.nendrasys.core.enventListener;

import de.hybris.platform.acceleratorservices.site.AbstractAcceleratorSiteEventListener;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.enums.SiteChannel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.orderprocessing.model.OrderProcessModel;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.util.ServicesUtil;
import org.springframework.beans.factory.annotation.Required;

public class OrderReceivedEventListener extends AbstractAcceleratorSiteEventListener<OrderReceivedEvent> {

    private ModelService modelService;
    private BusinessProcessService businessProcessService;

    public ModelService getModelService() {
        return this.modelService;
    }

    @Required
    public void setModelService(final ModelService modelService) {
        this.modelService = modelService;
    }

    public BusinessProcessService getBusinessProcessService() {
        return this.businessProcessService;
    }

    @Required
    public void setBusinessProcessService(final BusinessProcessService businessProcessService) {
        this.businessProcessService = businessProcessService;
    }

    @Override
    protected void onSiteEvent(final OrderReceivedEvent event) {
        final OrderModel orderModel = event.getProcess().getOrder();
        final OrderProcessModel orderReceivedProcessModel = (OrderProcessModel)getBusinessProcessService().createProcess(
                "orderReceivedEmailProcess-" + orderModel.getCode() + "-" + System.currentTimeMillis(),
                "orderReceivedEmailProcess");
        orderReceivedProcessModel.setOrder(orderModel);
        getModelService().save(orderReceivedProcessModel);
        getBusinessProcessService().startProcess(orderReceivedProcessModel);

    }

    @Override
    protected SiteChannel getSiteChannelForEvent(final OrderReceivedEvent event) {
        final OrderModel order = event.getProcess().getOrder();
        ServicesUtil.validateParameterNotNullStandardMessage("event.order", order);
        final BaseSiteModel site = order.getSite();
        ServicesUtil.validateParameterNotNullStandardMessage("event.order.site", site);
        return site.getChannel();
    }

}
