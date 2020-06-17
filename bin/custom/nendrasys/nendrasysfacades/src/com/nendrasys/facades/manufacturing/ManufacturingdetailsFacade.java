package com.nendrasys.facades.manufacturing;


import com.nendrasys.core.model.ManufacturingDetailsModel;
import com.nendrasys.facades.product.data.ManufacturingDetailsData;

import java.util.List;


/**
 * Facade interface which deals with methods related to ManufacturingDetailsModel operations.
 */
public interface ManufacturingdetailsFacade {
  /**
   * Retrives ManufacturingDetails information
   * @param companyName the name of the company
   * @return a {@code ManufacturingDetailsData }
   */
  ManufacturingDetailsData getManufacturingDetails(String companyName);

    /**
     * Retrives ManufacturingDetails information of given product code
     * @param productCode the code of the product
     * @return a {@code ManufacturingDetailsData }
     */
  ManufacturingDetailsData getManufacturingDetailsByProduct(String productCode);

  /**
   * @return {@code ManufacturingDetailsData }'s List if found
   */
  List<ManufacturingDetailsData> getAllManufacturingDetails(int start,int range);
}
