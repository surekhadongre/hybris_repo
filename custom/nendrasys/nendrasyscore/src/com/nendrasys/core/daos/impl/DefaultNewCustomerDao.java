package com.nendrasys.core.daos.impl;

import com.nendrasys.core.daos.NewCustomerDao;
import de.hybris.platform.commerceservices.customer.dao.impl.DefaultCustomerDao;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Required;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class DefaultNewCustomerDao extends DefaultCustomerDao implements NewCustomerDao {

    private FlexibleSearchService flexibleSearchService;

    protected FlexibleSearchService getFlexibleSearchService() {
        return this.flexibleSearchService;
    }

    @Required
    public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }

    @Override
    public List<CustomerModel> fetchAllCustomers(final String date1, final String date2) {
            final Map<String,Object> param = new HashedMap();
            param.put("date1",date1);
            param.put("date2",date2);
            final StringBuilder query = new StringBuilder();
            query.append(" SELECT {").append(CustomerModel.PK).append("}");
            query.append(" FROM {").append(CustomerModel._TYPECODE).append("} ");
            query.append("WHERE {").append(CustomerModel.CREATIONTIME).append("}");
            query.append(" BETWEEN ").append("'" + date1 + "'");
            query.append(" AND ").append("'" + date2 + "'");

            final SearchResult<CustomerModel> searchResult = getFlexibleSearchService().search(query.toString());
            return searchResult.getResult();
    }

}
