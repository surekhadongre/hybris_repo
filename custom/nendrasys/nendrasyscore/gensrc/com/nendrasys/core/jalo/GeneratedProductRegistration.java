/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 11, 2020, 11:14:17 AM                   ---
 * ----------------------------------------------------------------
 */
package com.nendrasys.core.jalo;

import com.nendrasys.core.constants.NendrasysCoreConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem ProductRegistration}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedProductRegistration extends GenericItem
{
	/** Qualifier of the <code>ProductRegistration.productId</code> attribute **/
	public static final String PRODUCTID = "productId";
	/** Qualifier of the <code>ProductRegistration.quantityNeeded</code> attribute **/
	public static final String QUANTITYNEEDED = "quantityNeeded";
	/** Qualifier of the <code>ProductRegistration.companyName</code> attribute **/
	public static final String COMPANYNAME = "companyName";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(PRODUCTID, AttributeMode.INITIAL);
		tmp.put(QUANTITYNEEDED, AttributeMode.INITIAL);
		tmp.put(COMPANYNAME, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductRegistration.companyName</code> attribute.
	 * @return the companyName
	 */
	public String getCompanyName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, COMPANYNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductRegistration.companyName</code> attribute.
	 * @return the companyName
	 */
	public String getCompanyName()
	{
		return getCompanyName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductRegistration.companyName</code> attribute. 
	 * @param value the companyName
	 */
	public void setCompanyName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, COMPANYNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductRegistration.companyName</code> attribute. 
	 * @param value the companyName
	 */
	public void setCompanyName(final String value)
	{
		setCompanyName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductRegistration.productId</code> attribute.
	 * @return the productId
	 */
	public String getProductId(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PRODUCTID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductRegistration.productId</code> attribute.
	 * @return the productId
	 */
	public String getProductId()
	{
		return getProductId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductRegistration.productId</code> attribute. 
	 * @param value the productId
	 */
	public void setProductId(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PRODUCTID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductRegistration.productId</code> attribute. 
	 * @param value the productId
	 */
	public void setProductId(final String value)
	{
		setProductId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductRegistration.quantityNeeded</code> attribute.
	 * @return the quantityNeeded
	 */
	public Integer getQuantityNeeded(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, QUANTITYNEEDED);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductRegistration.quantityNeeded</code> attribute.
	 * @return the quantityNeeded
	 */
	public Integer getQuantityNeeded()
	{
		return getQuantityNeeded( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductRegistration.quantityNeeded</code> attribute. 
	 * @return the quantityNeeded
	 */
	public int getQuantityNeededAsPrimitive(final SessionContext ctx)
	{
		Integer value = getQuantityNeeded( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductRegistration.quantityNeeded</code> attribute. 
	 * @return the quantityNeeded
	 */
	public int getQuantityNeededAsPrimitive()
	{
		return getQuantityNeededAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductRegistration.quantityNeeded</code> attribute. 
	 * @param value the quantityNeeded
	 */
	public void setQuantityNeeded(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, QUANTITYNEEDED,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductRegistration.quantityNeeded</code> attribute. 
	 * @param value the quantityNeeded
	 */
	public void setQuantityNeeded(final Integer value)
	{
		setQuantityNeeded( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductRegistration.quantityNeeded</code> attribute. 
	 * @param value the quantityNeeded
	 */
	public void setQuantityNeeded(final SessionContext ctx, final int value)
	{
		setQuantityNeeded( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductRegistration.quantityNeeded</code> attribute. 
	 * @param value the quantityNeeded
	 */
	public void setQuantityNeeded(final int value)
	{
		setQuantityNeeded( getSession().getSessionContext(), value );
	}
	
}
