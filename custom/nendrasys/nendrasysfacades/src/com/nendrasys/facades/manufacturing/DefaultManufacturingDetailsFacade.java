package com.nendrasys.facades.manufacturing;

import com.nendrasys.core.model.ManufacturingDetailsModel;
import com.nendrasys.core.service.ManufacturingDetailsService;

import com.nendrasys.facades.product.data.ManufacturingDetailsData;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;


/**
 * Implementation for ManufacturingdetailsFacade
 */
public class DefaultManufacturingDetailsFacade implements ManufacturingdetailsFacade {
    private ManufacturingDetailsService manufacturingDetailsService;
    private Converter<ManufacturingDetailsModel,ManufacturingDetailsData> converter;

    protected Converter<ManufacturingDetailsModel, ManufacturingDetailsData> getConverter() {
        return this.converter;
    }

    @Required
    public void setConverter(final Converter<ManufacturingDetailsModel, ManufacturingDetailsData> converter) {
        this.converter = converter;
    }

    protected ManufacturingDetailsService getManufacturingDetailsService() {
        return this.manufacturingDetailsService;
    }

    @Required
    public void setManufacturingDetailsService(final ManufacturingDetailsService manufacturingDetailsService) {
        this.manufacturingDetailsService = manufacturingDetailsService;
    }

    @Override
    public ManufacturingDetailsData getManufacturingDetails(final String companyName) {
        final ManufacturingDetailsModel manufacturingDetailsModel = getManufacturingDetailsService().getManufacturingDetails(companyName);
        final ManufacturingDetailsData manufacturingDetailsData = getConverter().convert(manufacturingDetailsModel);
        return manufacturingDetailsData;
    }

    @Override
    public ManufacturingDetailsData getManufacturingDetailsByProduct(final String productCode) {
        final ManufacturingDetailsModel manufacturingDetailsModel = getManufacturingDetailsService().getManufacturingDetailsByProduct(productCode);
        final ManufacturingDetailsData manufacturingDetailsData = getConverter().convert(manufacturingDetailsModel);
        return manufacturingDetailsData;
    }

    @Override
    public List<ManufacturingDetailsData> getAllManufacturingDetails(final int start, final int range) {
        System.out.println("In Facade beging");
       final List<ManufacturingDetailsModel> manufacturingDetailsModelList= getManufacturingDetailsService().getAllManufacturingDetails(start,range);
       final List<ManufacturingDetailsData> manufacturingDetailsData = getConverter().convertAll(manufacturingDetailsModelList);
        System.out.println("In Facade :size:"+manufacturingDetailsData.size());
       return manufacturingDetailsData;
    }
}
