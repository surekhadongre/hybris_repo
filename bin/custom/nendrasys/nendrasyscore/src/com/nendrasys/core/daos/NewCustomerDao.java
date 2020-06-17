package com.nendrasys.core.daos;

import de.hybris.platform.commerceservices.customer.dao.CustomerDao;
import de.hybris.platform.core.model.user.CustomerModel;

import java.util.Date;
import java.util.List;

/**
 * to get all the customers
 */
public interface NewCustomerDao extends CustomerDao {
    /**
     * @return {@Link List<CustomerModel>} fetch all the customers
     */
    public List<CustomerModel> fetchAllCustomers(String date1, String date2);
}
