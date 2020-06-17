package com.nendrasys.core.custom;

import com.nendrasys.core.model.ElectronicsColorVariantProductModel;
import de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler;
import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.util.Calendar;
import java.util.Date;

public class DynamicIsNewProductHandler extends AbstractDynamicAttributeHandler<Boolean, ElectronicsColorVariantProductModel> {

    @Override
    public Boolean get(final ElectronicsColorVariantProductModel model) {
        final Calendar calander=Calendar.getInstance();
        final Date currentDate=calander.getTime();
        final Date productDate=model.getCreationtime();
        final int days=Days.daysBetween(
                new LocalDate(currentDate.getTime()),
                new LocalDate(productDate.getTime())).getDays();
        if(days>10){
            return false;
        }
        else {
            return true;
        }
        //return super.get(model);
    }

    @Override
    public void set(final ElectronicsColorVariantProductModel model, final Boolean aBoolean) {
        //super.set(model, aBoolean);
    }

}
