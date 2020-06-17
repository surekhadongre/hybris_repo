/*
package com.nendrasys.storefront.controllers.payment;

import com.nendrasys.storefront.acceleratorservice.payment.controllers.SilentOrderPostMockController;
import com.nendrasys.storefront.acceleratorservice.payment.forms.SopPaymentDetailsForm;
import com.nendrasys.storefront.acceleratorservice.payment.validation.UrlSchemeValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

//@Controller
//@RequestMapping("/sop-mocknew")
public class NendrasysSilentOrderPostMockController extends SilentOrderPostMockController {

    @Override
    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String doValidateAndPost(@Valid final SopPaymentDetailsForm form, final BindingResult bindingResult, final HttpServletRequest request, final Model model) {
        final Map<String, String> params = cloneRequestParameters(request);

        // Remove values that we must not post back to the caller
        params.remove("card_cvNumber");

        getSopPaymentDetailsValidator().validate(form, bindingResult);

        if (bindingResult.hasErrors())
        {
            // Validation errors
            params.put("decision", "REJECT");
            params.put("reasonCode", "102");
            params.put("decision_publicSignature", getMockedPublicDigest("REJECT" + "102"));

            // Remove card number on validation error
            params.remove("card_accountNumber");

            final List<String> missingFields = new ArrayList<>();
            final List<String> invalidFields = new ArrayList<>();

            processMissingFields(bindingResult, missingFields, invalidFields);

            for (int i = 0; i < missingFields.size(); i++)
            {
                params.put("MissingField" + i, missingFields.get(i));
            }
            for (int i = 0; i < invalidFields.size(); i++)
            {
                params.put("InvalidField" + i, invalidFields.get(i));
            }
        }
        else
        {
            // No validation errors create subscription ID

            final String subscriptionId = UUID.randomUUID().toString();
            params.put("ccAuthReply_cvCode", "M");
            params.put("paySubscriptionCreateReply_subscriptionID", subscriptionId);
            params.put("paySubscriptionCreateReply_subscriptionIDPublicSignature", getMockedPublicDigest(subscriptionId));

            //random no. as response code
            params.put("responseCode",""+new Random().nextInt(100000));

            processTransactionDecision(request, null, params, false);

            //Mask the card number in the response
            final String endPortion = form.getCard_accountNumber().trim().substring(form.getCard_accountNumber().length() - 4);
            final String maskedCardNumber = "************" + endPortion;

            params.put("card_accountNumber", maskedCardNumber);
        }

        model.addAttribute("postParams", params);

        final String postUrl = params.get("orderPage_receiptResponseURL");
        if (UrlSchemeValidator.validate(postUrl))
        {
            model.addAttribute("postUrl", postUrl);
        }
        else
        {
            model.addAttribute("postUrl", "javascript:false;");
        }

        final String merchantCallbackUrl = params.get("orderPage_merchantURLPostAddress");
        if (UrlSchemeValidator.validate(merchantCallbackUrl))
        {
            sendMerchantCallback(merchantCallbackUrl, params);
        }

        return SOP_REDIRECT_POST_PAGE;
    }
}
*/
