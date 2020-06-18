/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 18, 2020, 1:44:34 PM                    ---
 * ----------------------------------------------------------------
 */
package com.nendrasys.core.jalo;

import com.nendrasys.core.constants.NendrasysCoreConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.Country;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.TypeManager;
import de.hybris.platform.util.Utilities;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem ManufacturingDetails}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedManufacturingDetails extends GenericItem
{
	/** Qualifier of the <code>ManufacturingDetails.company</code> attribute **/
	public static final String COMPANY = "company";
	/** Qualifier of the <code>ManufacturingDetails.country</code> attribute **/
	public static final String COUNTRY = "country";
	/** Qualifier of the <code>ManufacturingDetails.yearsInMarket</code> attribute **/
	public static final String YEARSINMARKET = "yearsInMarket";
	/** Qualifier of the <code>ManufacturingDetails.rating</code> attribute **/
	public static final String RATING = "rating";
	/** Qualifier of the <code>ManufacturingDetails.canBeSold</code> attribute **/
	public static final String CANBESOLD = "canBeSold";
	/** Qualifier of the <code>ManufacturingDetails.products</code> attribute **/
	public static final String PRODUCTS = "products";
	/** Relation ordering override parameter constants for ManufacturToProductRel from ((nendrasyscore))*/
	protected static String MANUFACTURTOPRODUCTREL_SRC_ORDERED = "relation.ManufacturToProductRel.source.ordered";
	protected static String MANUFACTURTOPRODUCTREL_TGT_ORDERED = "relation.ManufacturToProductRel.target.ordered";
	/** Relation disable markmodifed parameter constants for ManufacturToProductRel from ((nendrasyscore))*/
	protected static String MANUFACTURTOPRODUCTREL_MARKMODIFIED = "relation.ManufacturToProductRel.markmodified";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(COMPANY, AttributeMode.INITIAL);
		tmp.put(COUNTRY, AttributeMode.INITIAL);
		tmp.put(YEARSINMARKET, AttributeMode.INITIAL);
		tmp.put(RATING, AttributeMode.INITIAL);
		tmp.put(CANBESOLD, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturingDetails.canBeSold</code> attribute.
	 * @return the canBeSold
	 */
	public Boolean isCanBeSold(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, CANBESOLD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturingDetails.canBeSold</code> attribute.
	 * @return the canBeSold
	 */
	public Boolean isCanBeSold()
	{
		return isCanBeSold( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturingDetails.canBeSold</code> attribute. 
	 * @return the canBeSold
	 */
	public boolean isCanBeSoldAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isCanBeSold( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturingDetails.canBeSold</code> attribute. 
	 * @return the canBeSold
	 */
	public boolean isCanBeSoldAsPrimitive()
	{
		return isCanBeSoldAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturingDetails.canBeSold</code> attribute. 
	 * @param value the canBeSold
	 */
	public void setCanBeSold(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, CANBESOLD,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturingDetails.canBeSold</code> attribute. 
	 * @param value the canBeSold
	 */
	public void setCanBeSold(final Boolean value)
	{
		setCanBeSold( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturingDetails.canBeSold</code> attribute. 
	 * @param value the canBeSold
	 */
	public void setCanBeSold(final SessionContext ctx, final boolean value)
	{
		setCanBeSold( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturingDetails.canBeSold</code> attribute. 
	 * @param value the canBeSold
	 */
	public void setCanBeSold(final boolean value)
	{
		setCanBeSold( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturingDetails.company</code> attribute.
	 * @return the company
	 */
	public String getCompany(final SessionContext ctx)
	{
		return (String)getProperty( ctx, COMPANY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturingDetails.company</code> attribute.
	 * @return the company
	 */
	public String getCompany()
	{
		return getCompany( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturingDetails.company</code> attribute. 
	 * @param value the company
	 */
	public void setCompany(final SessionContext ctx, final String value)
	{
		setProperty(ctx, COMPANY,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturingDetails.company</code> attribute. 
	 * @param value the company
	 */
	public void setCompany(final String value)
	{
		setCompany( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturingDetails.country</code> attribute.
	 * @return the country
	 */
	public Country getCountry(final SessionContext ctx)
	{
		return (Country)getProperty( ctx, COUNTRY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturingDetails.country</code> attribute.
	 * @return the country
	 */
	public Country getCountry()
	{
		return getCountry( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturingDetails.country</code> attribute. 
	 * @param value the country
	 */
	public void setCountry(final SessionContext ctx, final Country value)
	{
		setProperty(ctx, COUNTRY,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturingDetails.country</code> attribute. 
	 * @param value the country
	 */
	public void setCountry(final Country value)
	{
		setCountry( getSession().getSessionContext(), value );
	}
	
	@Override
	public boolean isMarkModifiedDisabled(final Item referencedItem)
	{
		ComposedType relationSecondEnd0 = TypeManager.getInstance().getComposedType("Product");
		if(relationSecondEnd0.isAssignableFrom(referencedItem.getComposedType()))
		{
			return Utilities.getMarkModifiedOverride(MANUFACTURTOPRODUCTREL_MARKMODIFIED);
		}
		return true;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturingDetails.products</code> attribute.
	 * @return the products - Products
	 */
	public List<Product> getProducts(final SessionContext ctx)
	{
		final List<Product> items = getLinkedItems( 
			ctx,
			true,
			NendrasysCoreConstants.Relations.MANUFACTURTOPRODUCTREL,
			"Product",
			null,
			Utilities.getRelationOrderingOverride(MANUFACTURTOPRODUCTREL_SRC_ORDERED, true),
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturingDetails.products</code> attribute.
	 * @return the products - Products
	 */
	public List<Product> getProducts()
	{
		return getProducts( getSession().getSessionContext() );
	}
	
	public long getProductsCount(final SessionContext ctx)
	{
		return getLinkedItemsCount(
			ctx,
			true,
			NendrasysCoreConstants.Relations.MANUFACTURTOPRODUCTREL,
			"Product",
			null
		);
	}
	
	public long getProductsCount()
	{
		return getProductsCount( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturingDetails.products</code> attribute. 
	 * @param value the products - Products
	 */
	public void setProducts(final SessionContext ctx, final List<Product> value)
	{
		setLinkedItems( 
			ctx,
			true,
			NendrasysCoreConstants.Relations.MANUFACTURTOPRODUCTREL,
			null,
			value,
			Utilities.getRelationOrderingOverride(MANUFACTURTOPRODUCTREL_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(MANUFACTURTOPRODUCTREL_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturingDetails.products</code> attribute. 
	 * @param value the products - Products
	 */
	public void setProducts(final List<Product> value)
	{
		setProducts( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to products. 
	 * @param value the item to add to products - Products
	 */
	public void addToProducts(final SessionContext ctx, final Product value)
	{
		addLinkedItems( 
			ctx,
			true,
			NendrasysCoreConstants.Relations.MANUFACTURTOPRODUCTREL,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(MANUFACTURTOPRODUCTREL_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(MANUFACTURTOPRODUCTREL_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to products. 
	 * @param value the item to add to products - Products
	 */
	public void addToProducts(final Product value)
	{
		addToProducts( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from products. 
	 * @param value the item to remove from products - Products
	 */
	public void removeFromProducts(final SessionContext ctx, final Product value)
	{
		removeLinkedItems( 
			ctx,
			true,
			NendrasysCoreConstants.Relations.MANUFACTURTOPRODUCTREL,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(MANUFACTURTOPRODUCTREL_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(MANUFACTURTOPRODUCTREL_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from products. 
	 * @param value the item to remove from products - Products
	 */
	public void removeFromProducts(final Product value)
	{
		removeFromProducts( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturingDetails.rating</code> attribute.
	 * @return the rating
	 */
	public Integer getRating(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, RATING);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturingDetails.rating</code> attribute.
	 * @return the rating
	 */
	public Integer getRating()
	{
		return getRating( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturingDetails.rating</code> attribute. 
	 * @return the rating
	 */
	public int getRatingAsPrimitive(final SessionContext ctx)
	{
		Integer value = getRating( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturingDetails.rating</code> attribute. 
	 * @return the rating
	 */
	public int getRatingAsPrimitive()
	{
		return getRatingAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturingDetails.rating</code> attribute. 
	 * @param value the rating
	 */
	public void setRating(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, RATING,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturingDetails.rating</code> attribute. 
	 * @param value the rating
	 */
	public void setRating(final Integer value)
	{
		setRating( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturingDetails.rating</code> attribute. 
	 * @param value the rating
	 */
	public void setRating(final SessionContext ctx, final int value)
	{
		setRating( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturingDetails.rating</code> attribute. 
	 * @param value the rating
	 */
	public void setRating(final int value)
	{
		setRating( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturingDetails.yearsInMarket</code> attribute.
	 * @return the yearsInMarket
	 */
	public Integer getYearsInMarket(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, YEARSINMARKET);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturingDetails.yearsInMarket</code> attribute.
	 * @return the yearsInMarket
	 */
	public Integer getYearsInMarket()
	{
		return getYearsInMarket( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturingDetails.yearsInMarket</code> attribute. 
	 * @return the yearsInMarket
	 */
	public int getYearsInMarketAsPrimitive(final SessionContext ctx)
	{
		Integer value = getYearsInMarket( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturingDetails.yearsInMarket</code> attribute. 
	 * @return the yearsInMarket
	 */
	public int getYearsInMarketAsPrimitive()
	{
		return getYearsInMarketAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturingDetails.yearsInMarket</code> attribute. 
	 * @param value the yearsInMarket
	 */
	public void setYearsInMarket(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, YEARSINMARKET,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturingDetails.yearsInMarket</code> attribute. 
	 * @param value the yearsInMarket
	 */
	public void setYearsInMarket(final Integer value)
	{
		setYearsInMarket( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturingDetails.yearsInMarket</code> attribute. 
	 * @param value the yearsInMarket
	 */
	public void setYearsInMarket(final SessionContext ctx, final int value)
	{
		setYearsInMarket( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturingDetails.yearsInMarket</code> attribute. 
	 * @param value the yearsInMarket
	 */
	public void setYearsInMarket(final int value)
	{
		setYearsInMarket( getSession().getSessionContext(), value );
	}
	
}
