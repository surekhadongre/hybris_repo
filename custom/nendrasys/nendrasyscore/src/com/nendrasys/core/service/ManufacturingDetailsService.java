package com.nendrasys.core.service;

import com.nendrasys.core.model.ManufacturingDetailsModel;

import java.util.List;


/**
 * Provides ManufacturingDetails Information by calling ManufacturingDetailsDao
 */
public interface ManufacturingDetailsService {

    /**
     * @param companyName the name of the company
     * @return {@link ManufacturingDetailsModel} with the found Manufacturingdetails or null if nothing was found
     */
    ManufacturingDetailsModel getManufacturingDetails(String companyName);

    /**
     * @param productCode the code of the product
     * @return {@link ManufacturingDetailsModel} with the found Manufacturingdetails or null if nothing was found
     */
    ManufacturingDetailsModel getManufacturingDetailsByProduct(String productCode);


    /**
     * @return {@link ManufacturingDetailsModel}'s Lis if found
     */
    List<ManufacturingDetailsModel> getAllManufacturingDetails(final int start, final int range);

    /**
     * @return {@link ManufacturingDetailsModel}'s Lis if found
     */
    List<ManufacturingDetailsModel> getAllManufacturingDetails();

}
