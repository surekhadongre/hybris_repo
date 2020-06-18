/*
package com.nendrasys.storefront.forms.validation;

import com.nendrasys.storefront.forms.CustomAddressForm;
import de.hybris.platform.acceleratorstorefrontcommons.forms.validation.AddressValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

*/
/*@Component("customAddressValidation")*//*

public class CustomAddressValidation extends AddressValidator {
    @Override
    public void validate(final Object object, final Errors errors) {
        super.validate(object, errors);
        final CustomAddressForm customAddressForm = (CustomAddressForm)object;
        validateVATNumber(customAddressForm,errors);
        System.out.println("///////////Validatorrrrrrrrrrrrrrr///////"+customAddressForm.getVat());
    }

    protected void validateVATNumber(final CustomAddressForm customAddressForm, final Errors errors){
		if(customAddressForm.getVat() != null){
			if(!( customAddressForm.getVat().matches("^[a-zA-Z0-9]*$")))
				errors.rejectValue(AddressField.VATNUMBER.getFieldKey(),AddressField.VATNUMBER.getErrorKey());
		}
	}
}
*/
