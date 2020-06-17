package com.nendrasys.facades.populators;

import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.commercefacades.product.data.PriceDataType;

import de.hybris.platform.commercefacades.search.converters.populator.SearchResultProductPopulator;

import java.math.BigDecimal;
import java.util.List;

public class CustomPriceGroupSearchResultProductPopulator<SearchResultValueData, ProductData> extends SearchResultProductPopulator {


    protected void populatePrices(final de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData source, final de.hybris.platform.commercefacades.product.data.ProductData target)
    {
        // Pull the volume prices flag
        final Boolean volumePrices = this.<Boolean> getValue(source, "volumePrices");
        target.setVolumePricesFlag(volumePrices == null ? Boolean.FALSE : volumePrices);

        final List<Object> customPrice = getValue(source,"customPriceGroup");
        if(customPrice!=null) {
            // Pull the price value for the current currency
            final Double newPrice = (Double) customPrice.get(0);
            if (newPrice != null) {
                final PriceData priceData = getPriceDataFactory().create(PriceDataType.BUY, BigDecimal.valueOf(newPrice.doubleValue()),
                        getCommonI18NService().getCurrentCurrency());
                target.setPrice(priceData);
            }




        }
        
    }


}
