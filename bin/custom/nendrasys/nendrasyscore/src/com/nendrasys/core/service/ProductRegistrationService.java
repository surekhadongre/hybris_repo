package com.nendrasys.core.service;

import com.nendrasys.core.exceptions.DuplicateProductIdException;
import com.nendrasys.core.model.ProductRegistrationModel;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;

/**
 * ProductRegistrationService
 */
public interface ProductRegistrationService {
    /**
     * @param model
     * register ProductRegistrationModel
     */
    public void register(ProductRegistrationModel model) throws DuplicateProductIdException;
}
