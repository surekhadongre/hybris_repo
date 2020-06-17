/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 11, 2020, 11:14:17 AM                   ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.acceleratorcms.jalo.components;

import com.nendrasys.core.constants.NendrasysCoreConstants;
import de.hybris.platform.cms2.jalo.contents.components.SimpleCMSComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.acceleratorcms.jalo.components.LatestProductsComponent LatestProductsComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedLatestProductsComponent extends SimpleCMSComponent
{
	/** Qualifier of the <code>LatestProductsComponent.noOfProductsToBeShown</code> attribute **/
	public static final String NOOFPRODUCTSTOBESHOWN = "noOfProductsToBeShown";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(NOOFPRODUCTSTOBESHOWN, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LatestProductsComponent.noOfProductsToBeShown</code> attribute.
	 * @return the noOfProductsToBeShown - Maximum number of the product references that are displayed in the component.
	 */
	public Integer getNoOfProductsToBeShown(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, NOOFPRODUCTSTOBESHOWN);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LatestProductsComponent.noOfProductsToBeShown</code> attribute.
	 * @return the noOfProductsToBeShown - Maximum number of the product references that are displayed in the component.
	 */
	public Integer getNoOfProductsToBeShown()
	{
		return getNoOfProductsToBeShown( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LatestProductsComponent.noOfProductsToBeShown</code> attribute. 
	 * @return the noOfProductsToBeShown - Maximum number of the product references that are displayed in the component.
	 */
	public int getNoOfProductsToBeShownAsPrimitive(final SessionContext ctx)
	{
		Integer value = getNoOfProductsToBeShown( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LatestProductsComponent.noOfProductsToBeShown</code> attribute. 
	 * @return the noOfProductsToBeShown - Maximum number of the product references that are displayed in the component.
	 */
	public int getNoOfProductsToBeShownAsPrimitive()
	{
		return getNoOfProductsToBeShownAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LatestProductsComponent.noOfProductsToBeShown</code> attribute. 
	 * @param value the noOfProductsToBeShown - Maximum number of the product references that are displayed in the component.
	 */
	public void setNoOfProductsToBeShown(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, NOOFPRODUCTSTOBESHOWN,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LatestProductsComponent.noOfProductsToBeShown</code> attribute. 
	 * @param value the noOfProductsToBeShown - Maximum number of the product references that are displayed in the component.
	 */
	public void setNoOfProductsToBeShown(final Integer value)
	{
		setNoOfProductsToBeShown( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LatestProductsComponent.noOfProductsToBeShown</code> attribute. 
	 * @param value the noOfProductsToBeShown - Maximum number of the product references that are displayed in the component.
	 */
	public void setNoOfProductsToBeShown(final SessionContext ctx, final int value)
	{
		setNoOfProductsToBeShown( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LatestProductsComponent.noOfProductsToBeShown</code> attribute. 
	 * @param value the noOfProductsToBeShown - Maximum number of the product references that are displayed in the component.
	 */
	public void setNoOfProductsToBeShown(final int value)
	{
		setNoOfProductsToBeShown( getSession().getSessionContext(), value );
	}
	
}
