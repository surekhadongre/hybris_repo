package com.nendrasys.core.service.interceptors;

import com.nendrasys.core.model.ManufactDetAuditEntryModel;
import com.nendrasys.core.model.ManufacturingDetailsModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PersistenceOperation;
import de.hybris.platform.servicelayer.interceptor.RemoveInterceptor;

public class ManufacturingDetailsRemoveInterceptor implements RemoveInterceptor<ManufacturingDetailsModel> {
    @Override
    public void onRemove(final ManufacturingDetailsModel manufacturingDetailsModel, final InterceptorContext interceptorContext) throws InterceptorException {
        final ManufactDetAuditEntryModel manufactDetAuditEntryModel = interceptorContext.getModelService().create(ManufactDetAuditEntryModel.class);
        manufactDetAuditEntryModel.setCompany(manufacturingDetailsModel.getCompany());
        interceptorContext.registerElementFor(manufactDetAuditEntryModel, PersistenceOperation.SAVE);
    }
}
