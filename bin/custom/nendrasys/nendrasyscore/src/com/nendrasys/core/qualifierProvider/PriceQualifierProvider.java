package com.nendrasys.core.qualifierProvider;

import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.europe1.constants.GeneratedEurope1Constants;
import de.hybris.platform.europe1.enums.UserPriceGroup;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.Session;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.solrfacetsearch.config.FacetSearchConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.IndexedType;
import de.hybris.platform.solrfacetsearch.provider.Qualifier;
import de.hybris.platform.solrfacetsearch.provider.QualifierProvider;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.beans.factory.annotation.Required;

import java.util.*;


public class PriceQualifierProvider implements QualifierProvider {
    private CommonI18NService commonI18NService;
    private SessionService sessionService;
    ModelService modelService;
    private UserService userService;

    public UserService getUserService() {
        return this.userService;
    }

    @Required
    public void setUserService(final UserService userService) {
        this.userService = userService;
    }

    public ModelService getModelService() {
        return this.modelService;
    }

    @Required
    public void setModelService(final ModelService modelService) {
        this.modelService = modelService;
    }

    protected SessionService getSessionService() {
        return this.sessionService;
    }

    @Required
    public void setSessionService(final SessionService sessionService) {
        this.sessionService = sessionService;
    }

    protected CommonI18NService getCommonI18NService() {
        return this.commonI18NService;
    }

    @Required
    public void setCommonI18NService(final CommonI18NService commonI18NService) {
        this.commonI18NService = commonI18NService;
    }


    private final Set<Class<?>> supportedTypes;

    public PriceQualifierProvider() {
        final Set<Class<?>> types = new HashSet();
        types.add(CurrencyModel.class);
        types.add(GeneratedEurope1Constants.Enumerations.UserPriceGroup.class);
        this.supportedTypes = Collections.unmodifiableSet(types);
    }

    @Override
    public Set<Class<?>> getSupportedTypes() {
        return this.supportedTypes;
    }

    @Override
    public Collection<Qualifier> getAvailableQualifiers(final FacetSearchConfig facetSearchConfig, final IndexedType indexedType) {
        Objects.requireNonNull(facetSearchConfig, "facetSearchConfig is null");
        Objects.requireNonNull(indexedType, "indexedType is null");
        final List<Qualifier> qualifiers = new ArrayList();
        final Iterator var5 = facetSearchConfig.getIndexConfig().getCurrencies().iterator();
        final List<UserGroupModel> userGroups = facetSearchConfig.getIndexConfig().getUserGroup();
        if(userGroups!=null){
            while(var5.hasNext()) {
                final CurrencyModel currency = (CurrencyModel)var5.next();
                userGroups.forEach(user -> {
                    if(user.getUserPriceGroup()!=null)
                        qualifiers.add(new CustomPriceQualifier(currency, user.getUserPriceGroup()));
                    else
                        qualifiers.add(new CustomPriceQualifier(currency,user));
                });
        }
        }
        /*userGroups.forEach(usr->{
            while (var5.hasNext()){
                qualifiers.add(new CustomPriceQualifier())
            }
        });*/
       /* else {
                while (var5.hasNext()){
                    qualifiers.add(new CustomPriceQualifier((CurrencyModel) var5.next()));
                }
        }*/
        return Collections.unmodifiableList(qualifiers);
    }

    @Override
    public boolean canApply(final IndexedProperty indexedProperty) {
        return true;
    }

    @Override
    public void applyQualifier(final Qualifier qualifier) {
        Objects.requireNonNull(qualifier, "qualifier is null");
        if (!(qualifier instanceof PriceQualifierProvider.CustomPriceQualifier)) {
            throw new IllegalArgumentException("provided qualifier is not of expected type");
        } else {
            if(((CustomPriceQualifier) qualifier).userPriceGroup!=null) {
                final UserPriceGroup userPriceGroup = qualifier.getValueForType(UserPriceGroup.class);

                this.commonI18NService.setCurrentCurrency(((PriceQualifierProvider.CustomPriceQualifier) qualifier).getCurrency());
        /*   ((JaloSession)this.sessionService.getRawSession(this.sessionService.getCurrentSession())).
                    getSessionContext().setAttribute("Europe1PriceFactory_UPG",((PriceQualifierProvider.CustomPriceQualifier)qualifier).getUserPriceGroup());*/
                this.sessionService.setAttribute(UserModel.EUROPE1PRICEFACTORY_UPG, this.modelService.getSource(userPriceGroup));
                //this.sessionService.setAttribute(UserModel.EUROPE1PRICEFACTORY_UPG, ((PriceQualifierProvider.CustomPriceQualifier) qualifier).getUserPriceGroup());
              // this.sessionService.setAttribute("userPriceGroup", ((PriceQualifierProvider.CustomPriceQualifier) qualifier).getUserPriceGroup());
            }
            else {
                this.commonI18NService.setCurrentCurrency(((PriceQualifierProvider.CustomPriceQualifier) qualifier).getCurrency());
                this.sessionService.setAttribute(UserModel.EUROPE1PRICEFACTORY_UPG, null);
            }
        }
    }

    @Override
    public Qualifier getCurrentQualifier() {
        final CurrencyModel currency = this.commonI18NService.getCurrentCurrency();
        //final UserGroupModel userGroup = this.userService.getUserGroupForUID(this.userService.getCurrentUser().getUid());
        //final UserPriceGroup userPriceGroup = this.sessionService.getAttribute(UserModel.EUROPE1PRICEFACTORY_UPG);
        final UserPriceGroup userPriceGroup = this.getUserService().getCurrentUser().getEurope1PriceFactory_UPG();
        final UserGroupModel userGroupModel = this.sessionService.getAttribute(UserModel.EUROPE1PRICEFACTORY_UPG);
        if(userPriceGroup!=null) {
            return new CustomPriceQualifier(currency, userPriceGroup);
        }
        else
            return new CustomPriceQualifier(currency,userGroupModel);
    }

    public static class CustomPriceQualifier implements Qualifier {
        private final CurrencyModel currency;
        private  UserPriceGroup userPriceGroup;
        UserGroupModel userGroupModel;


        public CustomPriceQualifier(final CurrencyModel currency, final UserPriceGroup userGroup) {
            Objects.requireNonNull(currency, "currency is null");
            Objects.requireNonNull(userGroup, "userGroup is null");
            this.currency = currency;
            this.userPriceGroup = userGroup;
        }
        public CustomPriceQualifier(final CurrencyModel currency, final UserGroupModel userGroupModel){
            Objects.requireNonNull(currency, "currency is null");
            this.currency = currency;
            this.userGroupModel=userGroupModel;
        }


        public CurrencyModel getCurrency() {
            return this.currency;
        }

        public UserPriceGroup getUserPriceGroup() {
            return this.userPriceGroup;
        }

        public <U> U getValueForType(final Class<U> type) {
            Objects.requireNonNull(type, "type is null");
            if (Objects.equals(type, CurrencyModel.class)) {
                return (U) this.currency;
            } else if (Objects.equals(type, UserPriceGroup.class)) {
                return (U) this.userPriceGroup;
            }else if (Objects.equals(type, UserGroupModel.class)) {
                return (U) this.userGroupModel;
            } else {
                throw new IllegalArgumentException("type not supported");
            }
        }

        public String toFieldQualifier() {
            if (this.userPriceGroup !=null)
                return this.currency.getIsocode()+"-"+ this.userPriceGroup.getCode();
            else
                return this.currency.getIsocode();
        }

        public boolean equals(final Object obj) {
            if (this == obj) {
                return true;
            } else if (obj != null && this.getClass() == obj.getClass()) {
                final PriceQualifierProvider.CustomPriceQualifier that = (PriceQualifierProvider.CustomPriceQualifier)obj;
                return (new EqualsBuilder()).append(this.currency, that.currency).append(this.userPriceGroup, that.userPriceGroup).isEquals();
            } else {
                return false;
            }
        }

        public int hashCode() {
            return this.currency.hashCode() + this.userPriceGroup.hashCode();
        }
    }
}
