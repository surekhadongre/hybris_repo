package com.nendrasys.core.valueresolver.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.europe1.enums.ProductPriceGroup;
import de.hybris.platform.europe1.enums.UserPriceGroup;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.jalo.order.price.PriceInformation;
import de.hybris.platform.product.PriceService;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.indexer.IndexerBatchContext;
import de.hybris.platform.solrfacetsearch.indexer.spi.InputDocument;
import de.hybris.platform.solrfacetsearch.provider.Qualifier;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractValueResolver;
import org.springframework.beans.factory.annotation.Required;


import java.util.Collection;
import java.util.List;

public class CustomPriceValueResolver extends AbstractValueResolver<ProductModel,Object, List<PriceInformation>> {

    private PriceService priceService;

    public PriceService getPriceService() {
        return this.priceService;
    }

    @Required
    public void setPriceService(final PriceService priceService) {
        this.priceService = priceService;
    }
    @Override
    protected List<PriceInformation> loadQualifierData(final IndexerBatchContext batchContext, final Collection<IndexedProperty> indexedProperties, final ProductModel model, final Qualifier qualifier) throws FieldValueProviderException {

        return loadPriceInformations(indexedProperties, model);
    }
    @Override
    protected void addFieldValues(final InputDocument document, final IndexerBatchContext indexerBatchContext,
                                  final IndexedProperty indexedProperty, final ProductModel productModel, final ValueResolverContext<Object, List<PriceInformation>> resolverContext)
            throws FieldValueProviderException {

        boolean hasPrice = false;

        final List<PriceInformation> priceInformations = resolverContext.getQualifierData();
        if (priceInformations != null)
        {
            final Double priceValue = getPriceValue(indexedProperty, priceInformations);
            if (priceValue != null)
            {
                hasPrice = true;
                document.addField(indexedProperty, priceValue, resolverContext.getFieldQualifier());
               /* final Collection<PriceRowModel> priceRowModels = productModel.getEurope1Prices();
                for(final PriceRowModel p:priceRowModels){
                    p.
                    document.addField(indexedProperty,p.getPrice(), resolverContext.getFieldQualifier());
                }*/
            }
        }

        if (!hasPrice)
        {
                throw new FieldValueProviderException("No value resolved for indexed property " + indexedProperty.getName());
        }
    }
    protected List<PriceInformation> loadPriceInformations(final Collection<IndexedProperty> indexedProperties,
                                                           final ProductModel product)
    {
        return this.priceService.getPriceInformationsForProduct(product);
    }

    protected Double getPriceValue(final IndexedProperty indexedProperty, final List<PriceInformation> priceInformations)
            throws FieldValueProviderException
    {
        Double value = null;
        if (priceInformations != null && !priceInformations.isEmpty())
        {
            value = Double.valueOf(priceInformations.get(0).getPriceValue().getValue());
        }

        return value;
    }

}
