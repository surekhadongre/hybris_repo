package com.nendrasys.core.qualifierProvider;

import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.europe1.enums.UserPriceGroup;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PriceValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.TaxValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.impl.DefaultPDTCriteriaFactory;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.impl.DefaultPriceValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.impl.DefaultTaxValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.impl.PDTEnumGroupsHelper;
import de.hybris.platform.product.BaseCriteria;
import de.hybris.platform.servicelayer.internal.i18n.I18NConstants;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import org.springframework.beans.factory.annotation.Required;

public class CustomDefaultPDTCriteriaFactory extends DefaultPDTCriteriaFactory {
    private PDTEnumGroupsHelper customPdtEnumGroupsHelper;
    private UserService customUserService;
    private SessionService customSessionService;

    public PDTEnumGroupsHelper getCustomPdtEnumGroupsHelper() {
        return this.customPdtEnumGroupsHelper;
    }

    @Required
    public void setCustomPdtEnumGroupsHelper(final PDTEnumGroupsHelper customPdtEnumGroupsHelper) {
        this.customPdtEnumGroupsHelper = customPdtEnumGroupsHelper;
    }

    public UserService getCustomUserService() {
        return this.customUserService;
    }

    @Required
    public void setCustomUserService(final UserService customUserService) {
        this.customUserService = customUserService;
    }


    public SessionService getCustomSessionService() {
        return this.customSessionService;
    }

    @Required
    public void setCustomSessionService(final SessionService customSessionService) {
        this.customSessionService = customSessionService;
    }

    @Override
    public PriceValueInfoCriteria priceInfoCriteriaFromBaseCriteria(final BaseCriteria baseCriteria) throws CalculationException {

        final UserPriceGroup sessionUserPricegroup = this.customSessionService.getAttribute(UserModel.EUROPE1PRICEFACTORY_UPG);
        //final UserPriceGroup userPriceGroup = sessionUserPricegroup != null ? sessionUserPricegroup : this.pdtEnumGroupsHelper.getUPG(this.userService.getCurrentUser());
       if (sessionUserPricegroup != null) {
           return DefaultPriceValueInfoCriteria.buildForInfo() //
                   .withProduct(baseCriteria.getProduct()) //
                   .withProductPriceGroup(this.customPdtEnumGroupsHelper.getPPG(baseCriteria.getProduct())) //
                   .withUser(this.customUserService.getCurrentUser()) //
                   .withUserPriceGroup(sessionUserPricegroup)
                   .withCurrency(this.customSessionService.getAttribute(I18NConstants.CURRENCY_SESSION_ATTR_KEY))//
                   .withNet(baseCriteria.isNet()) //
                   .withDate(baseCriteria.getDate()) //
                   .build();
       }
        else {
            return super.priceInfoCriteriaFromBaseCriteria(baseCriteria);
        }
    }
}
