package com.nendrasys.storefront.register;

import de.hybris.platform.acceleratorstorefrontcommons.forms.RegisterForm;

public class CustomRegisterForm extends RegisterForm {
    private boolean isBusinessUser;

    public boolean isIsBusinessUser() {
        return this.isBusinessUser;
    }

    public void setIsBusinessUser(final boolean businessUser) {
        this.isBusinessUser = businessUser;
    }
}
