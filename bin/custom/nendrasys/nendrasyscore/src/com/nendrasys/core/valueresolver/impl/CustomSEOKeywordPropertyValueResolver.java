package com.nendrasys.core.valueresolver.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.indexer.IndexerBatchContext;
import de.hybris.platform.solrfacetsearch.indexer.spi.InputDocument;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractValueResolver;
import org.apache.commons.lang.StringUtils;

public class CustomSEOKeywordPropertyValueResolver extends AbstractValueResolver<ProductModel,Object,Object> {


    @Override
    protected void addFieldValues(final InputDocument document, final IndexerBatchContext indexerBatchContext, final IndexedProperty indexedProperty, final ProductModel model, final ValueResolverContext<Object, Object> resolverContext) throws FieldValueProviderException {

        boolean hasValue = false;
                final String customSEOKeyword = model.getCustomSEOKeyword();
                if (!StringUtils.isBlank(customSEOKeyword))
                {
                    hasValue = true;
                    document.addField(indexedProperty, customSEOKeyword, resolverContext.getFieldQualifier());
                }


    }
}
