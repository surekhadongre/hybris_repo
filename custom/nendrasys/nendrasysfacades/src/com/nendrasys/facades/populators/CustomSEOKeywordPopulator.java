package com.nendrasys.facades.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

public class CustomSEOKeywordPopulator implements Populator<ProductModel, ProductData> {
    @Override
    public void populate(final ProductModel source, final ProductData target) throws ConversionException {
        if(source.getCustomSEOKeyword()!=null)
        target.setCustomSEOKeyword(source.getCustomSEOKeyword());
    }
}
