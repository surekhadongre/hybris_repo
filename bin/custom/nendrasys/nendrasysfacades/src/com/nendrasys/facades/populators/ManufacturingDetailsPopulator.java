package com.nendrasys.facades.populators;

import com.nendrasys.core.model.ManufacturingDetailsModel;
import com.nendrasys.facades.product.data.ManufacturingDetailsData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.List;

public class ManufacturingDetailsPopulator implements Populator<ProductModel, ProductData> {

    private Converter<ManufacturingDetailsModel,ManufacturingDetailsData> converter;

    protected Converter<ManufacturingDetailsModel, ManufacturingDetailsData> getConverter() {
        return this.converter;
    }

    @Required
    public void setConverter(final Converter<ManufacturingDetailsModel, ManufacturingDetailsData> converter) {
        this.converter = converter;
    }


    @Override
    public void populate(final ProductModel source, final ProductData target) throws ConversionException {
        final List<ManufacturingDetailsData> manufacturingDetailsDataList=getConverter().convertAll(source.getManufacturingDetails());

        target.setMANUFACTURINGDETAILS(getConverter().convertAll(source.getManufacturingDetails()));
        manufacturingDetailsDataList.forEach(manu->{
        });
    }
}
