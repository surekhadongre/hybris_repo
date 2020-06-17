package com.nendrasys.core.service.impl;

import com.nendrasys.core.daos.NewCustomerDao;
import com.nendrasys.core.service.NewCustomerService;
import de.hybris.platform.commerceservices.customer.dao.CustomerDao;
import de.hybris.platform.commerceservices.customer.impl.DefaultCustomerService;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;
import org.springframework.beans.factory.annotation.Required;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DefaultNewCustomerService extends DefaultCustomerService implements NewCustomerService {
    private NewCustomerDao newCustomerDao;
    private ModelService modelService;

    protected ModelService getModelService() {
        return this.modelService;
    }

    @Required
    public void setModelService(final ModelService modelService) {
        this.modelService = modelService;
    }



    protected NewCustomerDao getNewCustomerDao() {
        return this.newCustomerDao;
    }

    @Required
    public void setNewCustomerDao(final NewCustomerDao newCustomerDao) {
        this.newCustomerDao = newCustomerDao;
    }

    /**
     * Service constructor
     *
     * @param customerDao DAO for retrieving customer
     * @param regexp
     */
    public DefaultNewCustomerService(final CustomerDao customerDao, final String regexp) {
        super(customerDao, regexp);
    }

    @Override
    public void getAllCustomers(final Date creationTime, final Date endTime, final int daysToConsider) {
        final List<CustomerModel> newCustomersList = new ArrayList<>();
        final String date1 = dateToString(creationTime);
        final String date2 = dateToString(endTime);
        final List<CustomerModel> customerModelList = getNewCustomerDao().fetchAllCustomers(date1,date2);
        if(customerModelList!=null) {
            customerModelList.forEach(customer -> {
                final long days = daysDifference(customer.getCreationtime(), endTime);
                if (days <= daysToConsider)
                    customer.setIsNewCustomer(true);
                else
                    customer.setIsNewCustomer(false);
                newCustomersList.add(customer);
            });
            getModelService().saveAll(newCustomersList);
        }
    }
    private long daysDifference(final Date creationTime, final Date endTime){
        final long miliSec = creationTime.getTime() - endTime.getTime();
        final long days= miliSec / (1000 * 60 * 60 * 24);
        return days;
    }

    private String dateToString(final Date date){
        final String pattern = "yyyy-MM-dd HH:mm:00";
        final DateFormat df = new SimpleDateFormat(pattern);
        final String todayAsString = df.format(date);
        
        return todayAsString;
    }
}
