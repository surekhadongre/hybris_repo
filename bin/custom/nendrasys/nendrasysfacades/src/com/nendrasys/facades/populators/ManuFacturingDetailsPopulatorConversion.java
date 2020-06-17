package com.nendrasys.facades.populators;

import com.nendrasys.core.model.ManufacturingDetailsModel;
import com.nendrasys.facades.product.data.ManufacturingDetailsData;
import de.hybris.platform.commercefacades.user.data.CountryData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.jalo.c2l.Country;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.springframework.beans.factory.annotation.Required;


public class ManuFacturingDetailsPopulatorConversion implements Populator<ManufacturingDetailsModel, ManufacturingDetailsData> {

    private Converter<CountryModel, CountryData> converter;

    protected Converter<CountryModel, CountryData> getConverter() {
        return this.converter;
    }

    @Required
    public void setConverter(final Converter<CountryModel, CountryData> converter) {
        this.converter = converter;
    }

    @Override
    public void populate(final ManufacturingDetailsModel source, final ManufacturingDetailsData target) throws ConversionException {
        target.setCompany(source.getCompany());
        target.setCountry(getConverter().convert(source.getCountry()));
        target.setYearsInMarket(source.getYearsInMarket());
        target.setRating(source.getRating());
    }
}
