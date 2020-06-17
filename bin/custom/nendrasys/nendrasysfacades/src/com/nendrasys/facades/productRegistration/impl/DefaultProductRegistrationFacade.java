package com.nendrasys.facades.productRegistration.impl;

import com.nendrasys.core.exceptions.DuplicateProductIdException;
import com.nendrasys.core.model.ProductRegistrationModel;
import com.nendrasys.core.service.ProductRegistrationService;
import com.nendrasys.facades.product.data.ProductRegisterData;
import com.nendrasys.facades.productRegistration.ProductRegistrationFacade;
import de.hybris.platform.servicelayer.model.ModelService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.Assert;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNullStandardMessage;

public class DefaultProductRegistrationFacade implements ProductRegistrationFacade {
    private ModelService modelService;
    private ProductRegistrationService productRegistrationService;

    protected ProductRegistrationService getProductRegistrationService() {
        return this.productRegistrationService;
    }

    @Required
    public void setProductRegistrationService(final ProductRegistrationService productRegistrationService) {
        this.productRegistrationService = productRegistrationService;
    }

    protected ModelService getModelService() {
        return this.modelService;
    }

    @Required
    public void setModelService(final ModelService modelService) {
        this.modelService = modelService;
    }

    @Override
    public void register(final ProductRegisterData productRegisterData) throws DuplicateProductIdException {
        validateParameterNotNullStandardMessage("productRegisterData", productRegisterData);
        Assert.hasText(productRegisterData.getProductId(), "The field [ProductId] cannot be empty");
        Assert.hasText(String.valueOf(productRegisterData.getQuantityNeeded()), "The field [QuantityNeeded] cannot be empty");
        Assert.hasText(productRegisterData.getCompanyName(), "The field [CompanyName] cannot be empty");
        final ProductRegistrationModel productRegistration = getModelService().create(ProductRegistrationModel.class);
        setCommonPropertiesForRegister(productRegisterData,productRegistration);
        getProductRegistrationService().register(productRegistration);
    }

    protected void setCommonPropertiesForRegister(final ProductRegisterData productRegisterData, final ProductRegistrationModel productRegistrationModel)
    {
        productRegistrationModel.setProductId(productRegisterData.getProductId());
        productRegistrationModel.setQuantityNeeded(productRegisterData.getQuantityNeeded());
        productRegistrationModel.setCompanyName(productRegisterData.getCompanyName());
    }

}
