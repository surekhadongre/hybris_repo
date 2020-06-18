package com.nendrasys.core.custom;

import com.google.common.base.Strings;
import de.hybris.platform.cms2.model.restrictions.CMSUserRestrictionModel;
import de.hybris.platform.cms2.model.restrictions.ProductRegistrationRestrictionModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;
import de.hybris.platform.util.localization.Localization;

import java.util.Collection;
import java.util.Iterator;

public class ProductRegistrationRestrictionDynamicDescription implements DynamicAttributeHandler<String, ProductRegistrationRestrictionModel> {
    @Override
    public String get(final ProductRegistrationRestrictionModel model) {

        final StringBuilder result = new StringBuilder();

            final String localizedString = Localization.getLocalizedString("type.ProductRegistrationRestriction.description.text");
            result.append(localizedString == null ? "Display only for signed in users, Do not Display for Anonymous User:" : localizedString);
        return result.toString();
    }

    @Override
    public void set(final ProductRegistrationRestrictionModel model, final String s) {

    }
}
