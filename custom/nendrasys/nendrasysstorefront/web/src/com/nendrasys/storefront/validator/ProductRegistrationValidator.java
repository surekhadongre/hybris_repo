package com.nendrasys.storefront.validator;

import com.nendrasys.storefront.register.ProductRegisterForm;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("productRegistrationValidator")
public class ProductRegistrationValidator implements Validator {
    @Override
    public boolean supports(final Class<?> aClass) {
        return ProductRegisterForm.class.equals(aClass);
    }

    @Override
    public void validate(final Object o, final Errors errors) {
        final ProductRegisterForm form = (ProductRegisterForm)o;
        final String productId = form.getProductId();
        final int quantityNeeded = form.getQuantityNeeded();
        final String companyName = form.getCompanyName();

        validateProductId(errors, productId);
        validateQuantityNeeded(errors,quantityNeeded);
        validateCompanyName(errors,companyName);
        System.out.println("validator");
    }

    protected void validateProductId(final Errors errors, final String productId){
        if (StringUtils.isEmpty(productId)){
            errors.rejectValue("productId","product.register.productId.invalid");
        }
    }

    protected void validateQuantityNeeded(final Errors errors, final int quantityNeeded){
        if (quantityNeeded<=0 || quantityNeeded>100){
            errors.rejectValue("quantityNeeded","product.register.quantityNeeded.invalid");
        }
    }

    protected void validateCompanyName(final Errors errors, final String companyname){
        if (StringUtils.isEmpty(companyname)){
            errors.rejectValue("companyName","product.register.companyname.invalid");
        }
        else if (StringUtils.length(companyname) > 255 )
        {
            errors.rejectValue("companyName", "product.register.companyname.invalid");
        }
    }

}
