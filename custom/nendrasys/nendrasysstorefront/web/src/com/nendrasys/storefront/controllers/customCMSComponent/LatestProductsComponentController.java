package com.nendrasys.storefront.controllers.customCMSComponent;

import com.nendrasys.facades.latestProducts.LatestProductsFacade;
import com.nendrasys.storefront.controllers.ControllerConstants;
import com.nendrasys.storefront.controllers.cms.AbstractAcceleratorCMSComponentController;
import de.hybris.platform.acceleratorcms.model.components.LatestProductsComponentModel;
import de.hybris.platform.acceleratorservices.dataexport.googlelocal.model.Product;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.commercefacades.product.data.ProductData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller("LatestProductsComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.LatestComponents)
public class LatestProductsComponentController extends AbstractAcceleratorCMSComponentController<LatestProductsComponentModel> {

    @Resource
    private LatestProductsFacade productsFacade;


    @Override
    public void fillModel(final HttpServletRequest request, final Model model, final LatestProductsComponentModel component) {
        final List<ProductData> latestProducts = this.productsFacade.getLatestProducts();

        final List<ProductData> latestProductsToBeShown = new ArrayList<>();

        for (int i=1;i<=component.getNoOfProductsToBeShown();i++){
            latestProductsToBeShown.add(latestProducts.get(i));
        }

        model.addAttribute("latestProducts",latestProductsToBeShown);
    }


}
