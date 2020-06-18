package com.nendrasys.core.service.impl;

import com.nendrasys.core.daos.LatestProductsDao;
import com.nendrasys.core.service.LatestProductsService;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DefaultLatestProductsService implements LatestProductsService {
    private LatestProductsDao latestProductsDao;


    protected LatestProductsDao getLatestProductsDao() {
        return this.latestProductsDao;
    }

    @Required
    public void setLatestProductsDao(final LatestProductsDao latestProductsDao) {
        this.latestProductsDao = latestProductsDao;
    }

    @Override
    public List<ProductModel> getLatestProducts() {
        final List<ProductModel> latestProductsList = new ArrayList<>();
        final List<ProductModel> productModelList = getLatestProductsDao().fetchLatestProducts();
        final Calendar calander=Calendar.getInstance();
        final Date currentDate=calander.getTime();
        productModelList.forEach(model->{
            final Date productDate=model.getCreationtime();
            final int days= Days.daysBetween(
                    new LocalDate(currentDate.getTime()),
                    new LocalDate(productDate.getTime())).getDays();
            if(days<10)
                    latestProductsList.add(model);
        });
        return latestProductsList;
    }
}
