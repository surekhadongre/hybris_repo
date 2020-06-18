package com.nendrasys.core.service;

import de.hybris.platform.commerceservices.customer.CustomerService;
import de.hybris.platform.core.model.user.CustomerModel;

import java.util.Date;
import java.util.List;

public interface NewCustomerService extends CustomerService {
    /**
     * @return {@Link List<CustomerModel>}
     */
    public void getAllCustomers(Date creationTime,Date endTime,int noDaysToConsider);

}