package com.nendrasys.facades.customRegistration;

import de.hybris.platform.commercefacades.customer.impl.DefaultCustomerFacade;
import de.hybris.platform.commercefacades.user.data.RegisterData;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.core.model.user.CustomerModel;
import org.springframework.util.Assert;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNullStandardMessage;

public class DefaultCustomRegistrationFacade extends DefaultCustomerFacade {

    protected void setCommonPropertiesForRegister(final RegisterData registerData, final CustomerModel customerModel)
    {
        customerModel.setName(getCustomerNameStrategy().getName(registerData.getFirstName(), registerData.getLastName()));
        setTitleForRegister(registerData, customerModel);
        setUidForRegister(registerData, customerModel);
        customerModel.setSessionLanguage(getCommonI18NService().getCurrentLanguage());
        customerModel.setSessionCurrency(getCommonI18NService().getCurrentCurrency());
        customerModel.setIsBusinessUser(registerData.isIsBusinessUser());
    }

}
