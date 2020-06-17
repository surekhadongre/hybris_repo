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
package de.hybris.platform.cms2.jalo.cronJobs;

import com.nendrasys.core.constants.NendrasysCoreConstants;
import de.hybris.platform.cronjob.jalo.CronJob;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.cms2.jalo.cronJobs.NewCustomerSetUpCronJob NewCustomerSetUpCronJob}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedNewCustomerSetUpCronJob extends CronJob
{
	/** Qualifier of the <code>NewCustomerSetUpCronJob.daysToConsiderForNewCustomer</code> attribute **/
	public static final String DAYSTOCONSIDERFORNEWCUSTOMER = "daysToConsiderForNewCustomer";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(CronJob.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(DAYSTOCONSIDERFORNEWCUSTOMER, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewCustomerSetUpCronJob.daysToConsiderForNewCustomer</code> attribute.
	 * @return the daysToConsiderForNewCustomer
	 */
	public Integer getDaysToConsiderForNewCustomer(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, DAYSTOCONSIDERFORNEWCUSTOMER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewCustomerSetUpCronJob.daysToConsiderForNewCustomer</code> attribute.
	 * @return the daysToConsiderForNewCustomer
	 */
	public Integer getDaysToConsiderForNewCustomer()
	{
		return getDaysToConsiderForNewCustomer( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewCustomerSetUpCronJob.daysToConsiderForNewCustomer</code> attribute. 
	 * @return the daysToConsiderForNewCustomer
	 */
	public int getDaysToConsiderForNewCustomerAsPrimitive(final SessionContext ctx)
	{
		Integer value = getDaysToConsiderForNewCustomer( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewCustomerSetUpCronJob.daysToConsiderForNewCustomer</code> attribute. 
	 * @return the daysToConsiderForNewCustomer
	 */
	public int getDaysToConsiderForNewCustomerAsPrimitive()
	{
		return getDaysToConsiderForNewCustomerAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewCustomerSetUpCronJob.daysToConsiderForNewCustomer</code> attribute. 
	 * @param value the daysToConsiderForNewCustomer
	 */
	public void setDaysToConsiderForNewCustomer(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, DAYSTOCONSIDERFORNEWCUSTOMER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewCustomerSetUpCronJob.daysToConsiderForNewCustomer</code> attribute. 
	 * @param value the daysToConsiderForNewCustomer
	 */
	public void setDaysToConsiderForNewCustomer(final Integer value)
	{
		setDaysToConsiderForNewCustomer( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewCustomerSetUpCronJob.daysToConsiderForNewCustomer</code> attribute. 
	 * @param value the daysToConsiderForNewCustomer
	 */
	public void setDaysToConsiderForNewCustomer(final SessionContext ctx, final int value)
	{
		setDaysToConsiderForNewCustomer( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewCustomerSetUpCronJob.daysToConsiderForNewCustomer</code> attribute. 
	 * @param value the daysToConsiderForNewCustomer
	 */
	public void setDaysToConsiderForNewCustomer(final int value)
	{
		setDaysToConsiderForNewCustomer( getSession().getSessionContext(), value );
	}
	
}
