package com.nendrasys.core.daos.impl;

import com.nendrasys.core.daos.LatestProductsDao;
import com.nendrasys.core.model.ElectronicsColorVariantProductModel;
import com.nendrasys.core.model.ManufacturingDetailsModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultLatestProductsDao implements LatestProductsDao {
    private FlexibleSearchService flexibleSearchService;

    protected FlexibleSearchService getFlexibleSearchService() {
        return this.flexibleSearchService;
    }

    @Required
    public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }

    @Override
    public List<ProductModel> fetchLatestProducts() {
        final String query = "SELECT {"+ ProductModel.PK+"} FROM {"+ProductModel._TYPECODE+"}";
        final SearchResult<ProductModel> searchResult = getFlexibleSearchService().search(query);
        return searchResult.getResult();
    }
}
