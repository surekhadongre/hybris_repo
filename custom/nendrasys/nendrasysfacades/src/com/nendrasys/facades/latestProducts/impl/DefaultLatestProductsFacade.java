package com.nendrasys.facades.latestProducts.impl;

import com.nendrasys.core.service.LatestProductsService;
import com.nendrasys.facades.latestProducts.LatestProductsFacade;
import de.hybris.platform.acceleratorservices.dataexport.googlelocal.model.Product;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.product.impl.DefaultProductFacade;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DefaultLatestProductsFacade extends DefaultProductFacade implements LatestProductsFacade {

    private LatestProductsService latestProductsService;

    protected LatestProductsService getLatestProductsService() {
        return this.latestProductsService;
    }

    @Required
    public void setLatestProductsService(final LatestProductsService latestProductsService) {
        this.latestProductsService = latestProductsService;
    }

    @Override
    public List<ProductData> getLatestProducts() {
        final List<ProductData> newProductData = new ArrayList<>();
        final List<ProductModel> productModelList = getLatestProductsService().getLatestProducts();
        productModelList.forEach(product->{
            newProductData.add( getProductForCodeAndOptions(product.getCode(),Arrays.asList(ProductOption.BASIC, ProductOption.PRICE,ProductOption.GALLERY,
                    ProductOption.IMAGES,ProductOption.DESCRIPTION,ProductOption.REVIEW)));
        });

       // final List<ProductData> productDataList = getConverter().convertAll(productModelList);
        return newProductData;
    }




}
