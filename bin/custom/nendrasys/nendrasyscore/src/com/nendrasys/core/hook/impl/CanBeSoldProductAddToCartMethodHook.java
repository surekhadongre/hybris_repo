package com.nendrasys.core.hook.impl;

import com.nendrasys.core.model.ManufacturingDetailsModel;
import de.hybris.platform.commerceservices.order.CommerceCartModificationException;
import de.hybris.platform.commerceservices.order.hook.impl.ConfigurableProductAddToCartMethodHook;
import de.hybris.platform.commerceservices.service.data.CommerceCartParameter;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CanBeSoldProductAddToCartMethodHook extends ConfigurableProductAddToCartMethodHook {
    Logger logger = Logger.getLogger(CanBeSoldProductAddToCartMethodHook.class);
    @Override
    public void beforeAddToCart(final CommerceCartParameter parameters) throws CommerceCartModificationException {
       // super.beforeAddToCart(parameters);
        this.logger.info("Method Hook has been called");
         final List<Boolean> canBeSoldList = new ArrayList<>();
         final List<ManufacturingDetailsModel> manDetailsList =  parameters.getProduct().getManufacturingDetails();
         if (manDetailsList != null) {
             manDetailsList.forEach(manDetails -> {
                 if(manDetails!=null) {
                     if(manDetails.getCanBeSold()!=null) {
                         final Boolean canBeSold = manDetails.getCanBeSold();
                         canBeSoldList.add(canBeSold);
                     }
                     else {
                         final Boolean canBeSold = false;
                         canBeSoldList.add(canBeSold);
                     }
                 }
             });
         }
            if(canBeSoldList != null && (!canBeSoldList.isEmpty())){
            final Boolean canBeSold = canBeSoldList.get(0);
            if(canBeSold.booleanValue() != true)
                throw new CommerceCartModificationException("Product Can't be sold");
        }
    }
}
