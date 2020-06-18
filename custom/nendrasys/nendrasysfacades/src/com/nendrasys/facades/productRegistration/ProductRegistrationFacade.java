package com.nendrasys.facades.productRegistration;

import com.nendrasys.core.exceptions.DuplicateProductIdException;
import com.nendrasys.facades.product.data.ProductRegisterData;

/**
 * ProductRegistrationFacade
 */
public interface ProductRegistrationFacade {
    /**
     * @param data
     * @throws DuplicateProductIdException
     */
    public void register(ProductRegisterData data) throws DuplicateProductIdException;
}
