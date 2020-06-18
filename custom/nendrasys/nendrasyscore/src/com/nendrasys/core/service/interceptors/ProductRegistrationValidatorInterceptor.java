package com.nendrasys.core.service.interceptors;

import com.nendrasys.core.model.ProductRegistrationModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductRegistrationValidatorInterceptor implements ValidateInterceptor<ProductRegistrationModel> {
    @Override
    public void onValidate(final ProductRegistrationModel productRegistrationModel, final InterceptorContext ctx) throws InterceptorException {
        System.out.println("in validator");
        final Set productRegistrationModelSet = ctx.getAllRegisteredElements();
        final List<ProductRegistrationModel> productRegistrationModelList = (List<ProductRegistrationModel>) productRegistrationModelSet.stream().collect(Collectors.toList());
      /*  productRegistrationModelList.forEach(model->{
            if(model.getProductId()==productRegistrationModel.getProductId() || model.getCompanyName()==productRegistrationModel.getCompanyName())
                try {
                    throw new InterceptorException("Product Id and Company Name must be Unique");
                } catch (final InterceptorException e) {
                    e.printStackTrace();
                }
        });*/
      for(final ProductRegistrationModel model: productRegistrationModelList){
          if(model.getProductId()==productRegistrationModel.getProductId() || model.getCompanyName()==productRegistrationModel.getCompanyName())
              System.out.println("i validator::"+model.getProductId()+" "+model.getCompanyName()+ "   "+productRegistrationModel.getCompanyName()+" "+productRegistrationModel.getProductId());
              throw new InterceptorException("Product Id and Company Name must be Unique");

      }
        System.out.println("in validator end size::"+productRegistrationModelList.size());
    }

}
