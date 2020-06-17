package com.nendrasys.storefront.controllers.productRegistration;

import com.nendrasys.core.exceptions.DuplicateProductIdException;
import com.nendrasys.facades.product.data.ProductRegisterData;
import com.nendrasys.facades.productRegistration.ProductRegistrationFacade;
import com.nendrasys.storefront.controllers.ControllerConstants;
import com.nendrasys.storefront.register.ProductRegisterForm;
import com.nendrasys.storefront.validator.ProductRegistrationValidator;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractLoginPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProductRegistrationPageController extends AbstractLoginPageController {

    private static final Logger LOGGER = Logger.getLogger(ProductRegistrationPageController.class);

    private static final String FORM_GLOBAL_ERROR = "form.global.error";

    private static final String PRODUCTREGISTRATION_CMS_PAGE = "productCMSPage";

    @Resource(name = "defaultProductRegistrationFacade")
    private ProductRegistrationFacade productRegistrationFacade;


    @Resource(name = "productRegistrationValidator")
    private ProductRegistrationValidator productRegistrationValidator;


    public ProductRegistrationValidator getProductRegistrationValidator() {
        return this.productRegistrationValidator;
    }


    @RequestMapping(value = "/registerProduct",method = RequestMethod.GET)
    public String registerPage(@ModelAttribute("productRegisterForm") final ProductRegisterForm form , final Model model) throws CMSItemNotFoundException {
        model.addAttribute(new ProductRegisterForm());
        final ContentPageModel productRegistrationCMSPage = getContentPageForLabelOrId(PRODUCTREGISTRATION_CMS_PAGE);
        storeCmsPageInModel(model, productRegistrationCMSPage);
        setUpMetaDataForContentPage(model, productRegistrationCMSPage);
        return getViewForPage(model);
       // return ControllerConstants.Views.ProductRegistration.ProductRegistrationForm;
    }

    @RequestMapping(value = "/registerProduct",method = RequestMethod.POST)
    public String registerProduct(final Model model,@ModelAttribute("productRegisterForm") final ProductRegisterForm form, final BindingResult bindingResult, final HttpServletRequest req, final HttpServletResponse res)throws CMSItemNotFoundException {
        getProductRegistrationValidator().validate(form,bindingResult);
        return processProductRegistration(form,bindingResult,model,req,res);
    }

    protected String processProductRegistration(final ProductRegisterForm form, final BindingResult bindingResult,
                                                final Model model, final HttpServletRequest req, final HttpServletResponse res)throws CMSItemNotFoundException {
        final ProductRegisterData data = new ProductRegisterData();

        if (bindingResult.hasErrors())
        {
            model.addAttribute(form);
            //return ControllerConstants.Views.ProductRegistration.ProductRegistrationForm;
            GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
            return handleRegistrationError(model);
        }
        data.setProductId(form.getProductId());
        data.setQuantityNeeded(form.getQuantityNeeded());
        data.setCompanyName(form.getCompanyName());
        try {
            this.productRegistrationFacade.register(data);
        }
        catch (final DuplicateProductIdException e){
            LOGGER.debug("Registration failed");
            model.addAttribute(form);
            bindingResult.rejectValue("productId","product.register.productId.duplicate");
            bindingResult.rejectValue("companyName","product.register.companyName.duplicate");
            //return ControllerConstants.Views.ProductRegistration.ProductRegistrationForm;
            GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
            return handleRegistrationError(model);
        }
        catch (final Exception e){
            LOGGER.debug("unknown exception occured while product Registration");
            return ControllerConstants.Views.ProductRegistration.ProductRegistrationForm;
        }
        return ControllerConstants.Views.ProductRegistration.ProductRegistration;
    }

    @Override
    protected AbstractPageModel getCmsPage() throws CMSItemNotFoundException {
        return getContentPageForLabelOrId("login");
    }

    @Override
    protected String getSuccessRedirect(final HttpServletRequest request, final HttpServletResponse response) {
        return null;
    }

    @Override
    protected String getView() {
        return ControllerConstants.Views.ProductRegistration.ProductRegistrationForm;
    }
}
