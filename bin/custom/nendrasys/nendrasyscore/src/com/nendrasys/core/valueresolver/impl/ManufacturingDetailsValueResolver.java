package com.nendrasys.core.valueresolver.impl;

import com.nendrasys.core.model.ManufacturingDetailsModel;
import com.nendrasys.core.service.LatestProductsService;
import com.nendrasys.core.service.ManufacturingDetailsService;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.indexer.IndexerBatchContext;
import de.hybris.platform.solrfacetsearch.indexer.spi.InputDocument;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractValueResolver;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class ManufacturingDetailsValueResolver extends AbstractValueResolver<ProductModel,Object,Object> {

    @Override
    protected void addFieldValues(final InputDocument document, final IndexerBatchContext indexerBatchContext, final IndexedProperty indexedProperty,
                                  final ProductModel productModel, final ValueResolverContext<Object, Object> resolverContext) throws FieldValueProviderException {
       boolean hasValue = false;
       final List<ManufacturingDetailsModel> manufacturingDetailsModel = productModel.getManufacturingDetails();
       if(manufacturingDetailsModel!=null){
           for (final ManufacturingDetailsModel model : manufacturingDetailsModel ){
               final String companyCode = model.getCompany();
               if (!StringUtils.isBlank(companyCode))
               {
                   hasValue = true;
                   document.addField(indexedProperty, companyCode, resolverContext.getFieldQualifier());
               }
               if (!hasValue)
                   System.out.println("No value resolved for indexed property " + indexedProperty.getName());
               //throw new FieldValueProviderException("No value resolved for indexed property " + indexedProperty.getName());
           }
       }
    }
}
