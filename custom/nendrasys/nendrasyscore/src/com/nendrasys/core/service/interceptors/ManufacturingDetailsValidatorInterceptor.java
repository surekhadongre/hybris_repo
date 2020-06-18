package com.nendrasys.core.service.interceptors;

import com.nendrasys.core.model.ManufacturingDetailsModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;
import org.apache.commons.lang.StringUtils;

class ManufacturingDetailsValidateInterceptor implements ValidateInterceptor<ManufacturingDetailsModel> {
    @Override
    public void onValidate(final ManufacturingDetailsModel manufacturingDetailsModel, final InterceptorContext interceptorContext) throws InterceptorException {
        if (manufacturingDetailsModel.getRating()!= null){
            if( manufacturingDetailsModel.getRating()<0)
                throw new InterceptorException("Ratings cannot be Negative Value");
        }
    }
}
