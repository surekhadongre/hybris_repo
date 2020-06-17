/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.nendrasys.fulfilmentprocess.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import com.nendrasys.fulfilmentprocess.constants.NendrasysFulfilmentProcessConstants;

public class NendrasysFulfilmentProcessManager extends GeneratedNendrasysFulfilmentProcessManager
{
	public static final NendrasysFulfilmentProcessManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (NendrasysFulfilmentProcessManager) em.getExtension(NendrasysFulfilmentProcessConstants.EXTENSIONNAME);
	}
	
}
