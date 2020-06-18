package com.nendrasys.storefront.controllers.util;

import com.nendrasys.storefront.forms.CustomAddressForm;
import de.hybris.platform.acceleratorstorefrontcommons.forms.AddressForm;
import de.hybris.platform.acceleratorstorefrontcommons.util.AddressDataUtil;
import de.hybris.platform.commercefacades.user.data.AddressData;

public class CustomAddressDataUtil extends AddressDataUtil {
    @Override
    public AddressData convertToAddressData(final AddressForm addressForm) {
        final CustomAddressForm customAddressForm = (CustomAddressForm)addressForm;
        final AddressData addressData = super.convertToAddressData(addressForm);
        addressData.setVat(customAddressForm.getVat());
        return addressData;
    }

    @Override
    public void convert(final AddressData source, final AddressForm target) {
        super.convert(source, target);
        final CustomAddressForm customAddressForm = (CustomAddressForm)target;
        customAddressForm.setVat(source.getVat());
    }
}
