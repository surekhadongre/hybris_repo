package com.nendrasys.storefront.controllers.pages;

import com.nendrasys.storefront.controllers.ControllerConstants;
import com.nendrasys.storefront.controllers.util.CustomAddressDataUtil;
import com.nendrasys.storefront.forms.CustomAddressForm;
import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.Breadcrumb;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.forms.AddressForm;
import de.hybris.platform.acceleratorstorefrontcommons.util.AddressDataUtil;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.commercefacades.address.data.AddressVerificationResult;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.order.CheckoutFacade;
import de.hybris.platform.commercefacades.user.UserFacade;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.address.AddressVerificationDecision;
import de.hybris.platform.commerceservices.enums.CountryType;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/my-account")
public class NendrasysAddOnAccountPageController extends AccountPageController {
    private static final String ADDRESS_FORM_ATTR = "addressForm";
    private static final String ADDRESS_DATA_ATTR = "addressData";
    private static final String COUNTRY_DATA_ATTR = "countryData";
    private static final String TITLE_DATA_ATTR = "titleData";
    private static final String ADDRESS_BOOK_EMPTY_ATTR = "addressBookEmpty";
    private static final String IS_DEFAULT_ADDRESS_ATTR = "isDefaultAddress";
    private static final String ADD_EDIT_ADDRESS_CMS_PAGE = "add-edit-address";
    private static final String MY_ACCOUNT_ADDRESS_BOOK_URL = "/my-account/address-book";
    private static final String TEXT_ACCOUNT_ADDRESS_BOOK = "text.account.addressBook";
    private static final String BREADCRUMBS_ATTR = "breadcrumbs";
    private static final String FORM_GLOBAL_ERROR = "form.global.error";
    private static final String REDIRECT_TO_EDIT_ADDRESS_PAGE = REDIRECT_PREFIX + "/my-account/edit-address/";
    private static final String ADDRESS_CODE_PATH_VARIABLE_PATTERN = "{addressCode:.*}";
    private static final String REGIONS_ATTR = "regions";
    private static final String COUNTRY_ATTR = "country";

    @Resource(name = "customerFacade")
    private CustomerFacade customerFacade;

    @Resource(name = "acceleratorCheckoutFacade")
    private CheckoutFacade checkoutFacade;

    @Resource(name = "accountBreadcrumbBuilder")
    private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

    @Resource(name = "userFacade")
    private UserFacade userFacade;

    @Resource(name = "customAddressDataUtil")
    private CustomAddressDataUtil customaddressDataUtil;

    @RequestMapping(value = "/addressform", method = RequestMethod.GET)
    public String getCountryAddressForm(@RequestParam("addressCode") final String addressCode,
                                        @RequestParam("countryIsoCode") final String countryIsoCode, final Model model)
    {
        model.addAttribute("supportedCountries", getCountries());
        populateModelRegionAndCountry(model, countryIsoCode);

        final CustomAddressForm addressForm = new CustomAddressForm();
        /*final AddressForm addressForm = new AddressForm();*/
        model.addAttribute(ADDRESS_FORM_ATTR, addressForm);
        for (final AddressData addressData : this.userFacade.getAddressBook())
        {
            if (addressData.getId() != null && addressData.getId().equals(addressCode)
                    && countryIsoCode.equals(addressData.getCountry().getIsocode()))
            {
                model.addAttribute(ADDRESS_DATA_ATTR, addressData);
                this.customaddressDataUtil.convert(addressData, addressForm);
                break;
            }
        }
        return ControllerConstants.Views.Fragments.Account.CountryAddressForm;
    }


    @Override
    @RequestMapping(value = "/add-address", method = RequestMethod.GET)
    @RequireHardLogIn
    public String addAddress(final Model model) throws CMSItemNotFoundException
    {
        model.addAttribute(COUNTRY_DATA_ATTR, this.checkoutFacade.getCountries(CountryType.SHIPPING));
        model.addAttribute(TITLE_DATA_ATTR, this.userFacade.getTitles());
        final CustomAddressForm addressForm = getPreparedAddressForm();
        model.addAttribute(ADDRESS_FORM_ATTR, addressForm);
        model.addAttribute(ADDRESS_BOOK_EMPTY_ATTR, Boolean.valueOf(CollectionUtils.isEmpty(this.userFacade.getAddressBook())));
        model.addAttribute(IS_DEFAULT_ADDRESS_ATTR, Boolean.FALSE);
        final ContentPageModel addEditAddressPage = getContentPageForLabelOrId(ADD_EDIT_ADDRESS_CMS_PAGE);
        storeCmsPageInModel(model, addEditAddressPage);
        setUpMetaDataForContentPage(model, addEditAddressPage);

        final List<Breadcrumb> breadcrumbs = this.accountBreadcrumbBuilder.getBreadcrumbs(null);
        breadcrumbs.add(new Breadcrumb(MY_ACCOUNT_ADDRESS_BOOK_URL,
                getMessageSource().getMessage(TEXT_ACCOUNT_ADDRESS_BOOK, null, getI18nService().getCurrentLocale()), null));
        breadcrumbs.add(new Breadcrumb("#",
                getMessageSource().getMessage("text.account.addressBook.addEditAddress", null, getI18nService().getCurrentLocale()),
                null));
        model.addAttribute(BREADCRUMBS_ATTR, breadcrumbs);
        model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
        return getViewForPage(model);
    }

    protected CustomAddressForm getPreparedAddressForm()
    {
        final CustomerData currentCustomerData = this.customerFacade.getCurrentCustomer();
        final CustomAddressForm addressForm = new CustomAddressForm();
        addressForm.setFirstName(currentCustomerData.getFirstName());
        addressForm.setLastName(currentCustomerData.getLastName());
        addressForm.setTitleCode(currentCustomerData.getTitleCode());
        return addressForm;
    }

    @RequestMapping(value = "/add-address", method = RequestMethod.POST)
    @RequireHardLogIn
    public String addAddress(final @ModelAttribute("addressForm") CustomAddressForm addressForm, final BindingResult bindingResult, final Model model,
                             final RedirectAttributes redirectModel) throws CMSItemNotFoundException
    {
        getAddressValidator().validate(addressForm, bindingResult);
        if (bindingResult.hasErrors())
        {
            GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
            final ContentPageModel addEditAddressPage = getContentPageForLabelOrId(ADD_EDIT_ADDRESS_CMS_PAGE);
            storeCmsPageInModel(model, addEditAddressPage);
            setUpMetaDataForContentPage(model, addEditAddressPage);
            setUpAddressFormAfterError(addressForm, model);
            return getViewForPage(model);
        }

        final AddressData newAddress = this.customaddressDataUtil.convertToVisibleAddressData(addressForm);

        if (CollectionUtils.isEmpty(this.userFacade.getAddressBook()))
        {
            newAddress.setDefaultAddress(true);
        }
        else
        {
            newAddress.setDefaultAddress(addressForm.getDefaultAddress() != null && addressForm.getDefaultAddress().booleanValue());
        }

        final AddressVerificationResult<AddressVerificationDecision> verificationResult = getAddressVerificationFacade()
                .verifyAddressData(newAddress);
        final boolean addressRequiresReview = getAddressVerificationResultHandler().handleResult(verificationResult, newAddress,
                model, redirectModel, bindingResult, getAddressVerificationFacade().isCustomerAllowedToIgnoreAddressSuggestions(),
                "checkout.multi.address.added");

        populateModelRegionAndCountry(model, addressForm.getCountryIso());
        model.addAttribute("edit", Boolean.FALSE);
        model.addAttribute(IS_DEFAULT_ADDRESS_ATTR, Boolean.valueOf(this.userFacade.isDefaultAddress(addressForm.getAddressId())));

        if (addressRequiresReview)
        {
            storeCmsPageInModel(model, getContentPageForLabelOrId(ADD_EDIT_ADDRESS_CMS_PAGE));
            setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ADD_EDIT_ADDRESS_CMS_PAGE));
            return getViewForPage(model);
        }

        this.userFacade.addAddress(newAddress);


        GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "account.confirmation.address.added",
                null);

        return REDIRECT_TO_EDIT_ADDRESS_PAGE + newAddress.getId();
    }

    @RequestMapping(value = "/edit-address/" + ADDRESS_CODE_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
    @RequireHardLogIn
    public String editAddress(@PathVariable("addressCode") final String addressCode, final Model model)
            throws CMSItemNotFoundException
    {
        final CustomAddressForm addressForm = new CustomAddressForm();
        model.addAttribute(COUNTRY_DATA_ATTR, this.checkoutFacade.getCountries(CountryType.SHIPPING));
        model.addAttribute(TITLE_DATA_ATTR, this.userFacade.getTitles());
        model.addAttribute(ADDRESS_FORM_ATTR, addressForm);
        final List<AddressData> addressBook = this.userFacade.getAddressBook();
        model.addAttribute(ADDRESS_BOOK_EMPTY_ATTR, Boolean.valueOf(CollectionUtils.isEmpty(addressBook)));


        for (final AddressData addressData : addressBook)
        {
            if (addressData.getId() != null && addressData.getId().equals(addressCode))
            {
                model.addAttribute(REGIONS_ATTR, getI18NFacade().getRegionsForCountryIso(addressData.getCountry().getIsocode()));
                model.addAttribute(COUNTRY_ATTR, addressData.getCountry().getIsocode());
                model.addAttribute(ADDRESS_DATA_ATTR, addressData);
                this.customaddressDataUtil.convert(addressData, addressForm);

                if (this.userFacade.isDefaultAddress(addressData.getId()))
                {
                    addressForm.setDefaultAddress(Boolean.TRUE);
                    model.addAttribute(IS_DEFAULT_ADDRESS_ATTR, Boolean.TRUE);
                }
                else
                {
                    addressForm.setDefaultAddress(Boolean.FALSE);
                    model.addAttribute(IS_DEFAULT_ADDRESS_ATTR, Boolean.FALSE);
                }
                break;
            }
        }
        final ContentPageModel addEditAddressPage = getContentPageForLabelOrId(ADD_EDIT_ADDRESS_CMS_PAGE);
        storeCmsPageInModel(model, addEditAddressPage);
        setUpMetaDataForContentPage(model, addEditAddressPage);

        final List<Breadcrumb> breadcrumbs = this.accountBreadcrumbBuilder.getBreadcrumbs(null);
        breadcrumbs.add(new Breadcrumb(MY_ACCOUNT_ADDRESS_BOOK_URL,
                getMessageSource().getMessage(TEXT_ACCOUNT_ADDRESS_BOOK, null, getI18nService().getCurrentLocale()), null));
        breadcrumbs.add(new Breadcrumb("#",
                getMessageSource().getMessage("text.account.addressBook.addEditAddress", null, getI18nService().getCurrentLocale()),
                null));
        model.addAttribute(BREADCRUMBS_ATTR, breadcrumbs);
        model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
        model.addAttribute("edit", Boolean.TRUE);
        return getViewForPage(model);
    }

    @RequestMapping(value = "/edit-address/" + ADDRESS_CODE_PATH_VARIABLE_PATTERN, method = RequestMethod.POST)
    @RequireHardLogIn
    public String editAddress(final @ModelAttribute("addressForm") CustomAddressForm addressForm, final BindingResult bindingResult, final Model model,
                              final RedirectAttributes redirectModel) throws CMSItemNotFoundException
    {
        getAddressValidator().validate(addressForm, bindingResult);
        final ContentPageModel addEditAddressPage = getContentPageForLabelOrId(ADD_EDIT_ADDRESS_CMS_PAGE);
        if (bindingResult.hasErrors())
        {
            GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
            storeCmsPageInModel(model, addEditAddressPage);
            setUpMetaDataForContentPage(model, addEditAddressPage);
            setUpAddressFormAfterError(addressForm, model);
            return getViewForPage(model);
        }

        model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

        final AddressData newAddress = this.customaddressDataUtil.convertToVisibleAddressData(addressForm);

        if (Boolean.TRUE.equals(addressForm.getDefaultAddress()) || this.userFacade.getAddressBook().size() <= 1)
        {
            newAddress.setDefaultAddress(true);
        }

        final AddressVerificationResult<AddressVerificationDecision> verificationResult = getAddressVerificationFacade()
                .verifyAddressData(newAddress);
        final boolean addressRequiresReview = getAddressVerificationResultHandler().handleResult(verificationResult, newAddress,
                model, redirectModel, bindingResult, getAddressVerificationFacade().isCustomerAllowedToIgnoreAddressSuggestions(),
                "checkout.multi.address.updated");

        model.addAttribute(REGIONS_ATTR, getI18NFacade().getRegionsForCountryIso(addressForm.getCountryIso()));
        model.addAttribute(COUNTRY_ATTR, addressForm.getCountryIso());
        model.addAttribute("edit", Boolean.TRUE);
        model.addAttribute(IS_DEFAULT_ADDRESS_ATTR, Boolean.valueOf(this.userFacade.isDefaultAddress(addressForm.getAddressId())));

        if (addressRequiresReview)
        {
            storeCmsPageInModel(model, addEditAddressPage);
            setUpMetaDataForContentPage(model, addEditAddressPage);
            return getViewForPage(model);
        }

        this.userFacade.editAddress(newAddress);

        GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "account.confirmation.address.updated",
                null);
        return REDIRECT_TO_EDIT_ADDRESS_PAGE + newAddress.getId();
    }



}
