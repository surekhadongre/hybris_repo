package com.nendrasys.core.service.impl;

import com.nendrasys.core.exceptions.DuplicateProductIdException;
import com.nendrasys.core.model.ProductRegistrationModel;
import com.nendrasys.core.service.ProductRegistrationService;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.impl.UniqueAttributesInterceptor;
import de.hybris.platform.servicelayer.model.ModelService;
import org.springframework.beans.factory.annotation.Required;

public class DefaultProductRegistrationService implements ProductRegistrationService {
   private ModelService modelService;

    protected ModelService getModelService() {
        return this.modelService;
    }

    @Required
    public void setModelService(final ModelService modelService) {
        this.modelService = modelService;
    }

    @Override
    public void register(final ProductRegistrationModel model) throws DuplicateProductIdException {
        try {
            getModelService().save(model);
        }
        catch (final ModelSavingException e)
        {
            if (e.getCause() instanceof InterceptorException
                    && ((InterceptorException) e.getCause()).getInterceptor().getClass().equals(UniqueAttributesInterceptor.class))
            {
                throw new DuplicateProductIdException(model.getProductId(), e);
            }

            else
            {
                throw e;
            }
        }
		catch (final AmbiguousIdentifierException e)
        {
            throw new DuplicateProductIdException(model.getProductId(), e);
        }

    }
}
