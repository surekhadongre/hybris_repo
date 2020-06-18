/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.nendrasys.setup;

import static com.nendrasys.constants.NendrasyspaymentConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.nendrasys.constants.NendrasyspaymentConstants;
import com.nendrasys.service.NendrasyspaymentService;


@SystemSetup(extension = NendrasyspaymentConstants.EXTENSIONNAME)
public class NendrasyspaymentSystemSetup
{
	private final NendrasyspaymentService nendrasyspaymentService;

	public NendrasyspaymentSystemSetup(final NendrasyspaymentService nendrasyspaymentService)
	{
		this.nendrasyspaymentService = nendrasyspaymentService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		nendrasyspaymentService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return NendrasyspaymentSystemSetup.class.getResourceAsStream("/nendrasyspayment/sap-hybris-platform.png");
	}
}
