package com.nendrasys.core.service.interceptors;

import com.nendrasys.core.model.ManufacturingDetailsModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PersistenceOperation;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import org.apache.commons.lang.StringUtils;


public class ManufacturingDetailsPrepareInterceptor implements PrepareInterceptor<ManufacturingDetailsModel> {
    @Override
    public void onPrepare(final ManufacturingDetailsModel manufacturingDetailsModel, final InterceptorContext interceptorContext) throws InterceptorException {
        if(!StringUtils.isBlank(manufacturingDetailsModel.getCompany()))
        manufacturingDetailsModel.setCompany(StringUtils.upperCase(manufacturingDetailsModel.getCompany()));
    }
}
