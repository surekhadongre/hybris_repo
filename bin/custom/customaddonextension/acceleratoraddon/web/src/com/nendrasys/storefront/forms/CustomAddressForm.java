package com.nendrasys.storefront.forms;

import de.hybris.platform.acceleratorstorefrontcommons.forms.AddressForm;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomAddressForm extends AddressForm {

    private String vat;

    @NotNull(message = "{vatnumber.invalid}")
    @Size(min = 1, max = 5, message = "{vatnumber.invalid}")
    public String getVat() {
        return this.vat;
    }

    public void setVat(final String vat) {
        this.vat = vat;
    }
}
