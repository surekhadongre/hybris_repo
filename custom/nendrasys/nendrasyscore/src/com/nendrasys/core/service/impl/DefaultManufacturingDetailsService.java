package com.nendrasys.core.service.impl;

import com.nendrasys.core.daos.ManufacturingDetailsDao;
import com.nendrasys.core.model.ManufacturingDetailsModel;
import com.nendrasys.core.service.ManufacturingDetailsService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateIfSingleResult;
import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;
import static java.lang.String.format;


/**
 * Implementation for ManufacturingDetailsService
 *
 */
public class DefaultManufacturingDetailsService implements ManufacturingDetailsService {

    private ManufacturingDetailsDao manufacturingDetailsDao;

    protected ManufacturingDetailsDao getManufacturingDetailsDao() {
        return this.manufacturingDetailsDao;
    }

    @Required
    public void setManufacturingDetailsDao(final ManufacturingDetailsDao manufacturingDetailsDao) {
        this.manufacturingDetailsDao = manufacturingDetailsDao;
    }

    @Override
    public ManufacturingDetailsModel getManufacturingDetails(final String companyName) {

        validateParameterNotNull(companyName, "Parameter companyName must not be null");
        final List<ManufacturingDetailsModel> manufacturingDetailsList = getManufacturingDetailsDao().findManufacturingDetails(companyName);

        validateIfSingleResult(manufacturingDetailsList, format("ManufacturingDetails with companyName '%s' not found!", companyName),
                format("ManufacturingDetails company '%s' is not unique, %d ManufacturingDetails found!", companyName,
                        Integer.valueOf(manufacturingDetailsList.size())));

            return manufacturingDetailsList.get(0);
    }

    @Override
    public ManufacturingDetailsModel getManufacturingDetailsByProduct(final String productCode) {
        validateParameterNotNull(productCode, "Parameter productCode must not be null");
        final List<ManufacturingDetailsModel> manufacturingDetailsList = getManufacturingDetailsDao().findManufacturingDetailsByProduct(productCode);
        validateIfSingleResult(manufacturingDetailsList, format("ManufacturingDetails of productCode '%s' not found!", productCode),
                format("ManufacturingDetails of  productCode '%s' is not unique, %d ManufacturingDetails found!", productCode,
                        Integer.valueOf(manufacturingDetailsList.size())));
        return manufacturingDetailsList.get(0);
    }

    @Override
    public List<ManufacturingDetailsModel> getAllManufacturingDetails(final int start, final int range) {
        final List<ManufacturingDetailsModel> manufacturingDetailsModelList = getManufacturingDetailsDao().findAllManufacturingDetails(start,range);
        return manufacturingDetailsModelList;
    }

    @Override
    public List<ManufacturingDetailsModel> getAllManufacturingDetails() {
        final List<ManufacturingDetailsModel> manufacturingDetailsModelList = getManufacturingDetailsDao().findAllManufacturingDetails();
        return manufacturingDetailsModelList;
    }

}
