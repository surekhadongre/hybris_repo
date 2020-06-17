package com.nendrasys.core.evaluators.impl;

import de.hybris.platform.cms2.model.restrictions.ProductRegistrationRestrictionModel;
import de.hybris.platform.cms2.servicelayer.data.RestrictionData;
import de.hybris.platform.cms2.servicelayer.services.evaluator.CMSRestrictionEvaluator;
import de.hybris.platform.cms2.servicelayer.services.evaluator.impl.CMSUserRestrictionEvaluator;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.user.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class ProductRegistrationRestrictionEvaluator implements CMSRestrictionEvaluator<ProductRegistrationRestrictionModel> {

    private static final Logger LOG = Logger.getLogger(ProductRegistrationRestrictionEvaluator.class);
    private UserService userService;

    protected UserService getUserService() {
        return this.userService;
    }

    @Required
    public void setUserService(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean evaluate(final ProductRegistrationRestrictionModel productRegistrationRestriction, final RestrictionData restrictionData) {
        /*final UserModel user = this.getUserService().getCurrentUser();
        if (LOG.isDebugEnabled())
            LOG.debug("Current User: " + user.getUid());
        if(getUserService().isAnonymousUser(user))
            return true;
        else
            return false;*/

        final UserModel user = this.getUserService().getCurrentUser();
        if (getUserService().isAnonymousUser(user)) {
            return false;
        }
        return true;
    }
}
