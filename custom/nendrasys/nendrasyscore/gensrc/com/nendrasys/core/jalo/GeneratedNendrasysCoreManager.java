/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 18, 2020, 1:44:34 PM                    ---
 * ----------------------------------------------------------------
 */
package com.nendrasys.core.jalo;

import com.nendrasys.core.constants.NendrasysCoreConstants;
import com.nendrasys.core.jalo.ApparelProduct;
import com.nendrasys.core.jalo.ApparelSizeVariantProduct;
import com.nendrasys.core.jalo.ApparelStyleVariantProduct;
import com.nendrasys.core.jalo.ElectronicsColorVariantProduct;
import com.nendrasys.core.jalo.ManufactDetAuditEntry;
import com.nendrasys.core.jalo.ManufacturingDetails;
import com.nendrasys.core.jalo.ProductRegistration;
import de.hybris.platform.acceleratorcms.jalo.components.LatestProductsComponent;
import de.hybris.platform.cms2.jalo.cronJobs.HelloWorldCronJob;
import de.hybris.platform.cms2.jalo.cronJobs.NewCustomerSetUpCronJob;
import de.hybris.platform.cms2.jalo.restrictions.ProductRegistrationRestriction;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.link.Link;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.security.PrincipalGroup;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.jalo.user.Address;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.jalo.user.UserGroup;
import de.hybris.platform.orderprocessing.jalo.OrderReceivedProcess;
import de.hybris.platform.payment.jalo.PaymentTransactionEntry;
import de.hybris.platform.solrfacetsearch.jalo.config.SolrFacetSearchConfig;
import de.hybris.platform.solrfacetsearch.jalo.config.SolrIndexConfig;
import de.hybris.platform.solrfacetsearch.jalo.config.SolrIndexedType;
import de.hybris.platform.util.Utilities;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type <code>NendrasysCoreManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedNendrasysCoreManager extends Extension
{
	/** Relation ordering override parameter constants for ManufacturToProductRel from ((nendrasyscore))*/
	protected static String MANUFACTURTOPRODUCTREL_SRC_ORDERED = "relation.ManufacturToProductRel.source.ordered";
	protected static String MANUFACTURTOPRODUCTREL_TGT_ORDERED = "relation.ManufacturToProductRel.target.ordered";
	/** Relation disable markmodifed parameter constants for ManufacturToProductRel from ((nendrasyscore))*/
	protected static String MANUFACTURTOPRODUCTREL_MARKMODIFIED = "relation.ManufacturToProductRel.markmodified";
	/** Relation ordering override parameter constants for SolrFacetSearchConfig2UPGRelation from ((nendrasyscore))*/
	protected static String SOLRFACETSEARCHCONFIG2UPGRELATION_SRC_ORDERED = "relation.SolrFacetSearchConfig2UPGRelation.source.ordered";
	protected static String SOLRFACETSEARCHCONFIG2UPGRELATION_TGT_ORDERED = "relation.SolrFacetSearchConfig2UPGRelation.target.ordered";
	/** Relation disable markmodifed parameter constants for SolrFacetSearchConfig2UPGRelation from ((nendrasyscore))*/
	protected static String SOLRFACETSEARCHCONFIG2UPGRELATION_MARKMODIFIED = "relation.SolrFacetSearchConfig2UPGRelation.markmodified";
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put("customSEOKeyword", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.product.Product", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("vat", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.user.Address", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("responseCode", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.payment.jalo.PaymentTransactionEntry", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("isBusinessUser", AttributeMode.INITIAL);
		tmp.put("isNewCustomer", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.user.Customer", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("userGroup", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.solrfacetsearch.jalo.config.SolrIndexedType", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("userPriceGroup", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.solrfacetsearch.jalo.config.SolrIndexConfig", Collections.unmodifiableMap(tmp));
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	public ApparelProduct createApparelProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.APPARELPRODUCT );
			return (ApparelProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelProduct createApparelProduct(final Map attributeValues)
	{
		return createApparelProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.APPARELSIZEVARIANTPRODUCT );
			return (ApparelSizeVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelSizeVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final Map attributeValues)
	{
		return createApparelSizeVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.APPARELSTYLEVARIANTPRODUCT );
			return (ApparelStyleVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelStyleVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final Map attributeValues)
	{
		return createApparelStyleVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.ELECTRONICSCOLORVARIANTPRODUCT );
			return (ElectronicsColorVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ElectronicsColorVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final Map attributeValues)
	{
		return createElectronicsColorVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public HelloWorldCronJob createHelloWorldCronJob(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.HELLOWORLDCRONJOB );
			return (HelloWorldCronJob)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating HelloWorldCronJob : "+e.getMessage(), 0 );
		}
	}
	
	public HelloWorldCronJob createHelloWorldCronJob(final Map attributeValues)
	{
		return createHelloWorldCronJob( getSession().getSessionContext(), attributeValues );
	}
	
	public LatestProductsComponent createLatestProductsComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.LATESTPRODUCTSCOMPONENT );
			return (LatestProductsComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating LatestProductsComponent : "+e.getMessage(), 0 );
		}
	}
	
	public LatestProductsComponent createLatestProductsComponent(final Map attributeValues)
	{
		return createLatestProductsComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public ManufactDetAuditEntry createManufactDetAuditEntry(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.MANUFACTDETAUDITENTRY );
			return (ManufactDetAuditEntry)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ManufactDetAuditEntry : "+e.getMessage(), 0 );
		}
	}
	
	public ManufactDetAuditEntry createManufactDetAuditEntry(final Map attributeValues)
	{
		return createManufactDetAuditEntry( getSession().getSessionContext(), attributeValues );
	}
	
	public ManufacturingDetails createManufacturingDetails(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.MANUFACTURINGDETAILS );
			return (ManufacturingDetails)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ManufacturingDetails : "+e.getMessage(), 0 );
		}
	}
	
	public ManufacturingDetails createManufacturingDetails(final Map attributeValues)
	{
		return createManufacturingDetails( getSession().getSessionContext(), attributeValues );
	}
	
	public NewCustomerSetUpCronJob createNewCustomerSetUpCronJob(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.NEWCUSTOMERSETUPCRONJOB );
			return (NewCustomerSetUpCronJob)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating NewCustomerSetUpCronJob : "+e.getMessage(), 0 );
		}
	}
	
	public NewCustomerSetUpCronJob createNewCustomerSetUpCronJob(final Map attributeValues)
	{
		return createNewCustomerSetUpCronJob( getSession().getSessionContext(), attributeValues );
	}
	
	public OrderReceivedProcess createOrderReceivedProcess(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.ORDERRECEIVEDPROCESS );
			return (OrderReceivedProcess)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating OrderReceivedProcess : "+e.getMessage(), 0 );
		}
	}
	
	public OrderReceivedProcess createOrderReceivedProcess(final Map attributeValues)
	{
		return createOrderReceivedProcess( getSession().getSessionContext(), attributeValues );
	}
	
	public ProductRegistration createProductRegistration(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.PRODUCTREGISTRATION );
			return (ProductRegistration)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ProductRegistration : "+e.getMessage(), 0 );
		}
	}
	
	public ProductRegistration createProductRegistration(final Map attributeValues)
	{
		return createProductRegistration( getSession().getSessionContext(), attributeValues );
	}
	
	public ProductRegistrationRestriction createProductRegistrationRestriction(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.PRODUCTREGISTRATIONRESTRICTION );
			return (ProductRegistrationRestriction)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ProductRegistrationRestriction : "+e.getMessage(), 0 );
		}
	}
	
	public ProductRegistrationRestriction createProductRegistrationRestriction(final Map attributeValues)
	{
		return createProductRegistrationRestriction( getSession().getSessionContext(), attributeValues );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.customSEOKeyword</code> attribute.
	 * @return the customSEOKeyword
	 */
	public String getCustomSEOKeyword(final SessionContext ctx, final Product item)
	{
		return (String)item.getProperty( ctx, NendrasysCoreConstants.Attributes.Product.CUSTOMSEOKEYWORD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.customSEOKeyword</code> attribute.
	 * @return the customSEOKeyword
	 */
	public String getCustomSEOKeyword(final Product item)
	{
		return getCustomSEOKeyword( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.customSEOKeyword</code> attribute. 
	 * @param value the customSEOKeyword
	 */
	public void setCustomSEOKeyword(final SessionContext ctx, final Product item, final String value)
	{
		item.setProperty(ctx, NendrasysCoreConstants.Attributes.Product.CUSTOMSEOKEYWORD,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.customSEOKeyword</code> attribute. 
	 * @param value the customSEOKeyword
	 */
	public void setCustomSEOKeyword(final Product item, final String value)
	{
		setCustomSEOKeyword( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>UserGroup.facetSearchConfigs</code> attribute.
	 * @return the facetSearchConfigs
	 */
	public List<SolrFacetSearchConfig> getFacetSearchConfigs(final SessionContext ctx, final UserGroup item)
	{
		final List<SolrFacetSearchConfig> items = item.getLinkedItems( 
			ctx,
			false,
			NendrasysCoreConstants.Relations.SOLRFACETSEARCHCONFIG2UPGRELATION,
			"SolrFacetSearchConfig",
			null,
			Utilities.getRelationOrderingOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_TGT_ORDERED, true)
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>UserGroup.facetSearchConfigs</code> attribute.
	 * @return the facetSearchConfigs
	 */
	public List<SolrFacetSearchConfig> getFacetSearchConfigs(final UserGroup item)
	{
		return getFacetSearchConfigs( getSession().getSessionContext(), item );
	}
	
	public long getFacetSearchConfigsCount(final SessionContext ctx, final UserGroup item)
	{
		return item.getLinkedItemsCount(
			ctx,
			false,
			NendrasysCoreConstants.Relations.SOLRFACETSEARCHCONFIG2UPGRELATION,
			"SolrFacetSearchConfig",
			null
		);
	}
	
	public long getFacetSearchConfigsCount(final UserGroup item)
	{
		return getFacetSearchConfigsCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>UserGroup.facetSearchConfigs</code> attribute. 
	 * @param value the facetSearchConfigs
	 */
	public void setFacetSearchConfigs(final SessionContext ctx, final UserGroup item, final List<SolrFacetSearchConfig> value)
	{
		item.setLinkedItems( 
			ctx,
			false,
			NendrasysCoreConstants.Relations.SOLRFACETSEARCHCONFIG2UPGRELATION,
			null,
			value,
			Utilities.getRelationOrderingOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>UserGroup.facetSearchConfigs</code> attribute. 
	 * @param value the facetSearchConfigs
	 */
	public void setFacetSearchConfigs(final UserGroup item, final List<SolrFacetSearchConfig> value)
	{
		setFacetSearchConfigs( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to facetSearchConfigs. 
	 * @param value the item to add to facetSearchConfigs
	 */
	public void addToFacetSearchConfigs(final SessionContext ctx, final UserGroup item, final SolrFacetSearchConfig value)
	{
		item.addLinkedItems( 
			ctx,
			false,
			NendrasysCoreConstants.Relations.SOLRFACETSEARCHCONFIG2UPGRELATION,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to facetSearchConfigs. 
	 * @param value the item to add to facetSearchConfigs
	 */
	public void addToFacetSearchConfigs(final UserGroup item, final SolrFacetSearchConfig value)
	{
		addToFacetSearchConfigs( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from facetSearchConfigs. 
	 * @param value the item to remove from facetSearchConfigs
	 */
	public void removeFromFacetSearchConfigs(final SessionContext ctx, final UserGroup item, final SolrFacetSearchConfig value)
	{
		item.removeLinkedItems( 
			ctx,
			false,
			NendrasysCoreConstants.Relations.SOLRFACETSEARCHCONFIG2UPGRELATION,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from facetSearchConfigs. 
	 * @param value the item to remove from facetSearchConfigs
	 */
	public void removeFromFacetSearchConfigs(final UserGroup item, final SolrFacetSearchConfig value)
	{
		removeFromFacetSearchConfigs( getSession().getSessionContext(), item, value );
	}
	
	@Override
	public String getName()
	{
		return NendrasysCoreConstants.EXTENSIONNAME;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.isBusinessUser</code> attribute.
	 * @return the isBusinessUser
	 */
	public Boolean isIsBusinessUser(final SessionContext ctx, final Customer item)
	{
		return (Boolean)item.getProperty( ctx, NendrasysCoreConstants.Attributes.Customer.ISBUSINESSUSER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.isBusinessUser</code> attribute.
	 * @return the isBusinessUser
	 */
	public Boolean isIsBusinessUser(final Customer item)
	{
		return isIsBusinessUser( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.isBusinessUser</code> attribute. 
	 * @return the isBusinessUser
	 */
	public boolean isIsBusinessUserAsPrimitive(final SessionContext ctx, final Customer item)
	{
		Boolean value = isIsBusinessUser( ctx,item );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.isBusinessUser</code> attribute. 
	 * @return the isBusinessUser
	 */
	public boolean isIsBusinessUserAsPrimitive(final Customer item)
	{
		return isIsBusinessUserAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.isBusinessUser</code> attribute. 
	 * @param value the isBusinessUser
	 */
	public void setIsBusinessUser(final SessionContext ctx, final Customer item, final Boolean value)
	{
		item.setProperty(ctx, NendrasysCoreConstants.Attributes.Customer.ISBUSINESSUSER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.isBusinessUser</code> attribute. 
	 * @param value the isBusinessUser
	 */
	public void setIsBusinessUser(final Customer item, final Boolean value)
	{
		setIsBusinessUser( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.isBusinessUser</code> attribute. 
	 * @param value the isBusinessUser
	 */
	public void setIsBusinessUser(final SessionContext ctx, final Customer item, final boolean value)
	{
		setIsBusinessUser( ctx, item, Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.isBusinessUser</code> attribute. 
	 * @param value the isBusinessUser
	 */
	public void setIsBusinessUser(final Customer item, final boolean value)
	{
		setIsBusinessUser( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.isNewCustomer</code> attribute.
	 * @return the isNewCustomer
	 */
	public Boolean isIsNewCustomer(final SessionContext ctx, final Customer item)
	{
		return (Boolean)item.getProperty( ctx, NendrasysCoreConstants.Attributes.Customer.ISNEWCUSTOMER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.isNewCustomer</code> attribute.
	 * @return the isNewCustomer
	 */
	public Boolean isIsNewCustomer(final Customer item)
	{
		return isIsNewCustomer( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.isNewCustomer</code> attribute. 
	 * @return the isNewCustomer
	 */
	public boolean isIsNewCustomerAsPrimitive(final SessionContext ctx, final Customer item)
	{
		Boolean value = isIsNewCustomer( ctx,item );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.isNewCustomer</code> attribute. 
	 * @return the isNewCustomer
	 */
	public boolean isIsNewCustomerAsPrimitive(final Customer item)
	{
		return isIsNewCustomerAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.isNewCustomer</code> attribute. 
	 * @param value the isNewCustomer
	 */
	public void setIsNewCustomer(final SessionContext ctx, final Customer item, final Boolean value)
	{
		item.setProperty(ctx, NendrasysCoreConstants.Attributes.Customer.ISNEWCUSTOMER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.isNewCustomer</code> attribute. 
	 * @param value the isNewCustomer
	 */
	public void setIsNewCustomer(final Customer item, final Boolean value)
	{
		setIsNewCustomer( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.isNewCustomer</code> attribute. 
	 * @param value the isNewCustomer
	 */
	public void setIsNewCustomer(final SessionContext ctx, final Customer item, final boolean value)
	{
		setIsNewCustomer( ctx, item, Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.isNewCustomer</code> attribute. 
	 * @param value the isNewCustomer
	 */
	public void setIsNewCustomer(final Customer item, final boolean value)
	{
		setIsNewCustomer( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.ManufacturingDetails</code> attribute.
	 * @return the ManufacturingDetails
	 */
	public List<ManufacturingDetails> getManufacturingDetails(final SessionContext ctx, final Product item)
	{
		final List<ManufacturingDetails> items = item.getLinkedItems( 
			ctx,
			false,
			NendrasysCoreConstants.Relations.MANUFACTURTOPRODUCTREL,
			"ManufacturingDetails",
			null,
			Utilities.getRelationOrderingOverride(MANUFACTURTOPRODUCTREL_SRC_ORDERED, true),
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.ManufacturingDetails</code> attribute.
	 * @return the ManufacturingDetails
	 */
	public List<ManufacturingDetails> getManufacturingDetails(final Product item)
	{
		return getManufacturingDetails( getSession().getSessionContext(), item );
	}
	
	public long getManufacturingDetailsCount(final SessionContext ctx, final Product item)
	{
		return item.getLinkedItemsCount(
			ctx,
			false,
			NendrasysCoreConstants.Relations.MANUFACTURTOPRODUCTREL,
			"ManufacturingDetails",
			null
		);
	}
	
	public long getManufacturingDetailsCount(final Product item)
	{
		return getManufacturingDetailsCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.ManufacturingDetails</code> attribute. 
	 * @param value the ManufacturingDetails
	 */
	public void setManufacturingDetails(final SessionContext ctx, final Product item, final List<ManufacturingDetails> value)
	{
		item.setLinkedItems( 
			ctx,
			false,
			NendrasysCoreConstants.Relations.MANUFACTURTOPRODUCTREL,
			null,
			value,
			Utilities.getRelationOrderingOverride(MANUFACTURTOPRODUCTREL_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(MANUFACTURTOPRODUCTREL_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.ManufacturingDetails</code> attribute. 
	 * @param value the ManufacturingDetails
	 */
	public void setManufacturingDetails(final Product item, final List<ManufacturingDetails> value)
	{
		setManufacturingDetails( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to ManufacturingDetails. 
	 * @param value the item to add to ManufacturingDetails
	 */
	public void addToManufacturingDetails(final SessionContext ctx, final Product item, final ManufacturingDetails value)
	{
		item.addLinkedItems( 
			ctx,
			false,
			NendrasysCoreConstants.Relations.MANUFACTURTOPRODUCTREL,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(MANUFACTURTOPRODUCTREL_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(MANUFACTURTOPRODUCTREL_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to ManufacturingDetails. 
	 * @param value the item to add to ManufacturingDetails
	 */
	public void addToManufacturingDetails(final Product item, final ManufacturingDetails value)
	{
		addToManufacturingDetails( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from ManufacturingDetails. 
	 * @param value the item to remove from ManufacturingDetails
	 */
	public void removeFromManufacturingDetails(final SessionContext ctx, final Product item, final ManufacturingDetails value)
	{
		item.removeLinkedItems( 
			ctx,
			false,
			NendrasysCoreConstants.Relations.MANUFACTURTOPRODUCTREL,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(MANUFACTURTOPRODUCTREL_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(MANUFACTURTOPRODUCTREL_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from ManufacturingDetails. 
	 * @param value the item to remove from ManufacturingDetails
	 */
	public void removeFromManufacturingDetails(final Product item, final ManufacturingDetails value)
	{
		removeFromManufacturingDetails( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaymentTransactionEntry.responseCode</code> attribute.
	 * @return the responseCode
	 */
	public String getResponseCode(final SessionContext ctx, final PaymentTransactionEntry item)
	{
		return (String)item.getProperty( ctx, NendrasysCoreConstants.Attributes.PaymentTransactionEntry.RESPONSECODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaymentTransactionEntry.responseCode</code> attribute.
	 * @return the responseCode
	 */
	public String getResponseCode(final PaymentTransactionEntry item)
	{
		return getResponseCode( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaymentTransactionEntry.responseCode</code> attribute. 
	 * @param value the responseCode
	 */
	public void setResponseCode(final SessionContext ctx, final PaymentTransactionEntry item, final String value)
	{
		item.setProperty(ctx, NendrasysCoreConstants.Attributes.PaymentTransactionEntry.RESPONSECODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaymentTransactionEntry.responseCode</code> attribute. 
	 * @param value the responseCode
	 */
	public void setResponseCode(final PaymentTransactionEntry item, final String value)
	{
		setResponseCode( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.userGroup</code> attribute.
	 * @return the userGroup
	 */
	public List<UserGroup> getUserGroup(final SessionContext ctx, final SolrIndexedType item)
	{
		List<UserGroup> coll = (List<UserGroup>)item.getProperty( ctx, NendrasysCoreConstants.Attributes.SolrIndexedType.USERGROUP);
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.userGroup</code> attribute.
	 * @return the userGroup
	 */
	public List<UserGroup> getUserGroup(final SolrIndexedType item)
	{
		return getUserGroup( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SolrIndexedType.userGroup</code> attribute. 
	 * @param value the userGroup
	 */
	public void setUserGroup(final SessionContext ctx, final SolrIndexedType item, final List<UserGroup> value)
	{
		item.setProperty(ctx, NendrasysCoreConstants.Attributes.SolrIndexedType.USERGROUP,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SolrIndexedType.userGroup</code> attribute. 
	 * @param value the userGroup
	 */
	public void setUserGroup(final SolrIndexedType item, final List<UserGroup> value)
	{
		setUserGroup( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.userGroup</code> attribute.
	 * @return the userGroup
	 */
	public List<UserGroup> getUserGroup(final SessionContext ctx, final SolrFacetSearchConfig item)
	{
		final List<UserGroup> items = item.getLinkedItems( 
			ctx,
			true,
			NendrasysCoreConstants.Relations.SOLRFACETSEARCHCONFIG2UPGRELATION,
			"UserGroup",
			null,
			Utilities.getRelationOrderingOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_TGT_ORDERED, true)
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.userGroup</code> attribute.
	 * @return the userGroup
	 */
	public List<UserGroup> getUserGroup(final SolrFacetSearchConfig item)
	{
		return getUserGroup( getSession().getSessionContext(), item );
	}
	
	public long getUserGroupCount(final SessionContext ctx, final SolrFacetSearchConfig item)
	{
		return item.getLinkedItemsCount(
			ctx,
			true,
			NendrasysCoreConstants.Relations.SOLRFACETSEARCHCONFIG2UPGRELATION,
			"UserGroup",
			null
		);
	}
	
	public long getUserGroupCount(final SolrFacetSearchConfig item)
	{
		return getUserGroupCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SolrFacetSearchConfig.userGroup</code> attribute. 
	 * @param value the userGroup
	 */
	public void setUserGroup(final SessionContext ctx, final SolrFacetSearchConfig item, final List<UserGroup> value)
	{
		item.setLinkedItems( 
			ctx,
			true,
			NendrasysCoreConstants.Relations.SOLRFACETSEARCHCONFIG2UPGRELATION,
			null,
			value,
			Utilities.getRelationOrderingOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SolrFacetSearchConfig.userGroup</code> attribute. 
	 * @param value the userGroup
	 */
	public void setUserGroup(final SolrFacetSearchConfig item, final List<UserGroup> value)
	{
		setUserGroup( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to userGroup. 
	 * @param value the item to add to userGroup
	 */
	public void addToUserGroup(final SessionContext ctx, final SolrFacetSearchConfig item, final UserGroup value)
	{
		item.addLinkedItems( 
			ctx,
			true,
			NendrasysCoreConstants.Relations.SOLRFACETSEARCHCONFIG2UPGRELATION,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to userGroup. 
	 * @param value the item to add to userGroup
	 */
	public void addToUserGroup(final SolrFacetSearchConfig item, final UserGroup value)
	{
		addToUserGroup( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from userGroup. 
	 * @param value the item to remove from userGroup
	 */
	public void removeFromUserGroup(final SessionContext ctx, final SolrFacetSearchConfig item, final UserGroup value)
	{
		item.removeLinkedItems( 
			ctx,
			true,
			NendrasysCoreConstants.Relations.SOLRFACETSEARCHCONFIG2UPGRELATION,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(SOLRFACETSEARCHCONFIG2UPGRELATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from userGroup. 
	 * @param value the item to remove from userGroup
	 */
	public void removeFromUserGroup(final SolrFacetSearchConfig item, final UserGroup value)
	{
		removeFromUserGroup( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexConfig.userPriceGroup</code> attribute.
	 * @return the userPriceGroup
	 */
	public List<EnumerationValue> getUserPriceGroup(final SessionContext ctx, final SolrIndexConfig item)
	{
		List<EnumerationValue> coll = (List<EnumerationValue>)item.getProperty( ctx, NendrasysCoreConstants.Attributes.SolrIndexConfig.USERPRICEGROUP);
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexConfig.userPriceGroup</code> attribute.
	 * @return the userPriceGroup
	 */
	public List<EnumerationValue> getUserPriceGroup(final SolrIndexConfig item)
	{
		return getUserPriceGroup( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SolrIndexConfig.userPriceGroup</code> attribute. 
	 * @param value the userPriceGroup
	 */
	public void setUserPriceGroup(final SessionContext ctx, final SolrIndexConfig item, final List<EnumerationValue> value)
	{
		item.setProperty(ctx, NendrasysCoreConstants.Attributes.SolrIndexConfig.USERPRICEGROUP,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SolrIndexConfig.userPriceGroup</code> attribute. 
	 * @param value the userPriceGroup
	 */
	public void setUserPriceGroup(final SolrIndexConfig item, final List<EnumerationValue> value)
	{
		setUserPriceGroup( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Address.vat</code> attribute.
	 * @return the vat
	 */
	public String getVat(final SessionContext ctx, final Address item)
	{
		return (String)item.getProperty( ctx, NendrasysCoreConstants.Attributes.Address.VAT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Address.vat</code> attribute.
	 * @return the vat
	 */
	public String getVat(final Address item)
	{
		return getVat( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Address.vat</code> attribute. 
	 * @param value the vat
	 */
	public void setVat(final SessionContext ctx, final Address item, final String value)
	{
		item.setProperty(ctx, NendrasysCoreConstants.Attributes.Address.VAT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Address.vat</code> attribute. 
	 * @param value the vat
	 */
	public void setVat(final Address item, final String value)
	{
		setVat( getSession().getSessionContext(), item, value );
	}
	
}
