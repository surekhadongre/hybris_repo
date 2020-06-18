package com.nendrasys.core.service;

import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

public interface LatestProductsService {

    /**
     * @return {@Link List<ProductData>} which are created before 5 days
     */
    public List<ProductModel> getLatestProducts();

}
