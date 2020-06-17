/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.nendrasys.core.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import com.nendrasys.core.constants.NendrasysCoreConstants;
import com.nendrasys.core.setup.CoreSystemSetup;


/**
 * Do not use, please use {@link CoreSystemSetup} instead.
 * 
 */
public class NendrasysCoreManager extends GeneratedNendrasysCoreManager
{
	public static final NendrasysCoreManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (NendrasysCoreManager) em.getExtension(NendrasysCoreConstants.EXTENSIONNAME);
	}
}
