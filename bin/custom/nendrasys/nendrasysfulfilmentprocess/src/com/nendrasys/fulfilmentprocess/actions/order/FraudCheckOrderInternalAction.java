/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.nendrasys.fulfilmentprocess.actions.order;

import de.hybris.platform.basecommerce.enums.FraudStatus;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.fraud.FraudService;
import de.hybris.platform.fraud.impl.FraudServiceResponse;
import de.hybris.platform.fraud.model.FraudReportModel;
import de.hybris.platform.orderhistory.model.OrderHistoryEntryModel;
import de.hybris.platform.orderprocessing.model.OrderProcessModel;
import de.hybris.platform.servicelayer.util.ServicesUtil;
import de.hybris.platform.util.Config;
import com.nendrasys.fulfilmentprocess.constants.NendrasysFulfilmentProcessConstants;

import org.springframework.beans.factory.annotation.Required;


public class FraudCheckOrderInternalAction extends AbstractFraudCheckAction<OrderProcessModel>
{
	private FraudService fraudService;
	private String providerName;

	protected FraudService getFraudService()
	{
		return this.fraudService;
	}

	@Required
	public void setFraudService(final FraudService fraudService)
	{
		this.fraudService = fraudService;
	}

	protected String getProviderName()
	{
		return this.providerName;
	}

	public void setProviderName(final String providerName)
	{
		this.providerName = providerName;
	}

	@Override
	public Transition executeAction(final OrderProcessModel process)
	{
		ServicesUtil.validateParameterNotNull(process, "Process can not be null");
		ServicesUtil.validateParameterNotNull(process.getOrder(), "Order can not be null");

		//get the fraud-detection configuration
		final double scoreLimit = Double.parseDouble(Config.getParameter(NendrasysFulfilmentProcessConstants.EXTENSIONNAME + ".fraud.scoreLimit"));
		final double scoreTolerance = Double.parseDouble(Config.getParameter(NendrasysFulfilmentProcessConstants.EXTENSIONNAME + ".fraud.scoreTolerance"));

		final OrderModel order = process.getOrder();
		final FraudServiceResponse response = getFraudService().recognizeOrderSymptoms(getProviderName(), order);

		final double score = response.getScore();
		if (score < scoreLimit)
		{
			final FraudReportModel fraudReport = createFraudReport(this.providerName, response, order, FraudStatus.OK);
			final OrderHistoryEntryModel historyEntry = createHistoryLog(this.providerName, order, FraudStatus.OK, null);
			order.setFraudulent(Boolean.FALSE);
			order.setPotentiallyFraudulent(Boolean.FALSE);
			order.setStatus(OrderStatus.FRAUD_CHECKED);
			this.modelService.save(fraudReport);
			this.modelService.save(historyEntry);
			this.modelService.save(order);
			return Transition.OK;
		}
		else if (score < scoreLimit + scoreTolerance)
		{
			final FraudReportModel fraudReport = createFraudReport(this.providerName, response, order, FraudStatus.CHECK);
			final OrderHistoryEntryModel historyEntry = createHistoryLog(this.providerName, order, FraudStatus.CHECK,
					fraudReport.getCode());
			order.setFraudulent(Boolean.FALSE);
			order.setPotentiallyFraudulent(Boolean.TRUE);
			order.setStatus(OrderStatus.FRAUD_CHECKED);
			this.modelService.save(fraudReport);
			this.modelService.save(historyEntry);
			this.modelService.save(order);
			return Transition.POTENTIAL;
		}
		else
		{
			final FraudReportModel fraudReport = createFraudReport(this.providerName, response, order, FraudStatus.FRAUD);
			final OrderHistoryEntryModel historyEntry = createHistoryLog(this.providerName, order, FraudStatus.FRAUD,
					fraudReport.getCode());
			order.setFraudulent(Boolean.TRUE);
			order.setPotentiallyFraudulent(Boolean.FALSE);
			order.setStatus(OrderStatus.FRAUD_CHECKED);
			this.modelService.save(fraudReport);
			this.modelService.save(historyEntry);
			this.modelService.save(order);
			return Transition.FRAUD;
			//return Transition.OK;
		}
	}
}
