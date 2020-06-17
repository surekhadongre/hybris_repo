package com.nendrasys.fulfilmentprocess.actions.order;

import com.nendrasys.fulfilmentprocess.actions.orderReceived.OrderReceivedEmailNotificationAction;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.orderprocessing.model.OrderProcessModel;
import de.hybris.platform.processengine.action.AbstractProceduralAction;
import de.hybris.platform.task.RetryLaterException;
import org.apache.log4j.Logger;

public class ManualInterventionNeededAction extends AbstractProceduralAction<OrderProcessModel> {
    private static final Logger LOG = Logger.getLogger(ManualInterventionNeededAction.class);

    @Override
    public void executeAction(final OrderProcessModel process) throws RetryLaterException, Exception {
        LOG.info("ManualInterventionNeededAction triggered");
        final OrderModel order = process.getOrder();
        setOrderStatus(order,OrderStatus.MANUAL_INTERVENTION_NEEDED);

    }
}
