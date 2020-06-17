/*
package com.nendrasys.storefront.util;

import com.nendrasys.storefront.forms.CustomAddressForm;
import de.hybris.platform.acceleratorstorefrontcommons.forms.AddressForm;
import de.hybris.platform.acceleratorstorefrontcommons.util.AddressDataUtil;
import de.hybris.platform.commercefacades.user.data.AddressData;
import org.springframework.stereotype.Component;

@Component("defaultCustomAddressDataUtil")
public class CustomAddressDataUtil extends AddressDataUtil {
    @Override
    public AddressData convertToAddressData(final AddressForm addressForm) {
        final CustomAddressForm customAddressForm = (CustomAddressForm)addressForm;
        final AddressData addressData = super.convertToAddressData(addressForm);
        addressData.setVat(customAddressForm.getVat());
        System.out.println("/////////CustomAddressDataUtil////////////////////");
        return addressData;
    }
}
*/
