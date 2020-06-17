package com.nendrasys.core.daos;

import com.nendrasys.core.model.ManufacturingDetailsModel;


import java.util.List;

/**
 * ManufacturingDetailsDao
 */
public interface ManufacturingDetailsDao {

    /**
     * Returns for the given companyName a List with the found
     * @param companyName the name of the company
     * @return a List of {@link ManufacturingDetailsModel}s with the found Manufacturingdetails or empty List if nothing was found
     */

    List<ManufacturingDetailsModel> findManufacturingDetails(String companyName);

    /**
     * Returns for the given productCode a List with the found
     * @param productCode the code of the product
     * @return a List of {@link ManufacturingDetailsModel}s with the found Manufacturingdetails or empty List if nothing was found
     */
    List<ManufacturingDetailsModel> findManufacturingDetailsByProduct(String productCode);

    /**
     * Returns List of ManufacturingDetails if found
     * @return a List of {@link ManufacturingDetailsModel}s
     */
    List<ManufacturingDetailsModel> findAllManufacturingDetails(final int start, final int range);

    /**
     * @return {@Link List<MaufacturingDetailsModel}
     */
    List<ManufacturingDetailsModel> findAllManufacturingDetails();

}
