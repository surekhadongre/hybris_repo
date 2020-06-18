/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.nendrasys.storefront.security.impl;

import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.commerceservices.strategies.CheckoutCustomerStrategy;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.order.CartService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import com.nendrasys.storefront.security.GuestCheckoutCartCleanStrategy;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Required;


public class DefaultGuestCheckoutCartCleanStrategy implements GuestCheckoutCartCleanStrategy
{
	public static final String AJAX_REQUEST_HEADER_NAME = "X-Requested-With";

	private List<String> skipPatterns;
	private CheckoutCustomerStrategy checkoutCustomerStrategy;
	private CartService cartService;
	private SessionService sessionService;
	private UserService userService;

	@Override
	public void cleanGuestCart(final HttpServletRequest request)
	{

		if (isAnonymousCheckout() && StringUtils.isBlank(request.getHeader(AJAX_REQUEST_HEADER_NAME)) && isGetMethod(request)
				&& !checkWhetherURLContainsSkipPattern(request))
		{
			final CartModel cartModel = getCartService().getSessionCart();
			cartModel.setDeliveryAddress(null);
			cartModel.setDeliveryMode(null);
			cartModel.setPaymentInfo(null);
			cartModel.setUser(getUserService().getAnonymousUser());
			getCartService().saveOrder(cartModel);
			getSessionService().removeAttribute(WebConstants.ANONYMOUS_CHECKOUT);
			getSessionService().removeAttribute(WebConstants.ANONYMOUS_CHECKOUT_GUID);
		}

	}

	@Override
	public boolean checkWhetherURLContainsSkipPattern(final HttpServletRequest request)
	{
		boolean contains = false;
		final String requestUrl = request.getRequestURL().toString();
		for (final String patternStr : this.skipPatterns)
		{
			final Pattern pattern = Pattern.compile(patternStr);
			if (pattern.matcher(requestUrl).matches())
			{
				contains = true;
				break;
			}
		}
		return contains;
	}

	protected boolean isGetMethod(final HttpServletRequest httpRequest)
	{
		return "GET".equalsIgnoreCase(httpRequest.getMethod());
	}

	protected CheckoutCustomerStrategy getCheckoutCustomerStrategy()
	{
		return this.checkoutCustomerStrategy;
	}

	protected boolean isAnonymousCheckout()
	{
		return Boolean.TRUE.equals(getSessionService().getAttribute(WebConstants.ANONYMOUS_CHECKOUT))
				&& getCheckoutCustomerStrategy().isAnonymousCheckout();
	}

	@Required
	public void setCheckoutCustomerStrategy(final CheckoutCustomerStrategy checkoutCustomerStrategy)
	{
		this.checkoutCustomerStrategy = checkoutCustomerStrategy;
	}

	protected CartService getCartService()
	{
		return this.cartService;
	}

	@Required
	public void setCartService(final CartService cartService)
	{
		this.cartService = cartService;
	}

	protected SessionService getSessionService()
	{
		return this.sessionService;
	}

	@Required
	public void setSessionService(final SessionService sessionService)
	{
		this.sessionService = sessionService;
	}

	protected UserService getUserService()
	{
		return this.userService;
	}

	@Required
	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}

	public List<String> getSkipPatterns()
	{
		return this.skipPatterns;
	}

	@Required
	public void setSkipPatterns(final List<String> skipPatterns)
	{
		this.skipPatterns = skipPatterns;
	}

}
