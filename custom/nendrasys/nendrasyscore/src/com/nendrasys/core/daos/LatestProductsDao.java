package com.nendrasys.core.daos;

import com.nendrasys.core.model.ElectronicsColorVariantProductModel;
import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

/**
 * Gives latest Products which are created before 2 days
 */
public interface LatestProductsDao {
    /**
     * @return {@Link List<ElectronicsColorVariantProductModel>} which are created before 2 days
     */
  public List<ProductModel> fetchLatestProducts();

}
