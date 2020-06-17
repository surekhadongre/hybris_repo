package com.nendrasys.facades.latestProducts;

import de.hybris.platform.acceleratorservices.dataexport.googlelocal.model.Product;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.data.ProductData;

import java.util.List;

public interface LatestProductsFacade extends ProductFacade {

    /**
     * @return {@Link ProductData} converts ProductModel to ProductData
     */
    public List<ProductData> getLatestProducts();


}
