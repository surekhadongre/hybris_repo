package com.nendrasys.facades.populators;

import de.hybris.platform.commercefacades.user.converters.populator.AddressPopulator;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.core.model.user.AddressModel;

public class CustomAddressPopulator extends AddressPopulator {
    @Override
    public void populate(final AddressModel source, final AddressData target) {
        super.populate(source, target);
        target.setVat(source.getVat());
    }
}
