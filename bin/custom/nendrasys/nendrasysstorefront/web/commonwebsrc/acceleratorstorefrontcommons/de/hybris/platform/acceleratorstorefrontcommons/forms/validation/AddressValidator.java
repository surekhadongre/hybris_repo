/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorstorefrontcommons.forms.validation;

import de.hybris.platform.acceleratorstorefrontcommons.forms.AddressForm;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * Validator for address forms. Enforces the order of validation
 */
@Component("addressValidator")
public class AddressValidator implements Validator
{
	private static final int MAX_FIELD_LENGTH = 255;
	private static final int MAX_POSTCODE_LENGTH = 10;


	@Override
	public boolean supports(final Class<?> aClass)
	{
		return AddressForm.class.equals(aClass);
	}

	@Override
	public void validate(final Object object, final Errors errors)
	{
		final AddressForm addressForm = (AddressForm) object;
		validateStandardFields(addressForm, errors);
		validateCountrySpecificFields(addressForm, errors);
		/*validateVATNumber(addressForm,errors);*/
	}

	/*protected void validateVATNumber(final AddressForm addressForm, final Errors errors){
		if(addressForm.getVat() != null){
			if(!( addressForm.getVat().matches("^[a-zA-Z0-9]*$")))
				errors.rejectValue(AddressField.VATNUMBER.getFieldKey(),AddressField.VATNUMBER.getErrorKey());
		}
	}*/

	protected void validateStandardFields(final AddressForm addressForm, final Errors errors)
	{
		validateStringField(addressForm.getCountryIso(), AddressField.COUNTRY, MAX_FIELD_LENGTH, errors);
		validateStringField(addressForm.getFirstName(), AddressField.FIRSTNAME, MAX_FIELD_LENGTH, errors);
		validateStringField(addressForm.getLastName(), AddressField.LASTNAME, MAX_FIELD_LENGTH, errors);
		validateStringField(addressForm.getLine1(), AddressField.LINE1, MAX_FIELD_LENGTH, errors);
		validateStringField(addressForm.getTownCity(), AddressField.TOWN, MAX_FIELD_LENGTH, errors);
		validateStringField(addressForm.getPostcode(), AddressField.POSTCODE, MAX_POSTCODE_LENGTH, errors);
	}

	protected void validateCountrySpecificFields(final AddressForm addressForm, final Errors errors)
	{
		final String isoCode = addressForm.getCountryIso();
		if (isoCode != null)
		{
			switch (CountryCode.lookup(isoCode))
			{
				case CHINA:
					validateStringFieldLength(addressForm.getTitleCode(), AddressField.TITLE, MAX_FIELD_LENGTH, errors);
					validateFieldNotNull(addressForm.getRegionIso(), AddressField.REGION, errors);
					break;
				case CANADA:
					validateStringFieldLength(addressForm.getTitleCode(), AddressField.TITLE, MAX_FIELD_LENGTH, errors);
					validateFieldNotNull(addressForm.getRegionIso(), AddressField.REGION, errors);
					break;
				case USA:
					validateStringFieldLength(addressForm.getTitleCode(), AddressField.TITLE, MAX_FIELD_LENGTH, errors);
					validateFieldNotNull(addressForm.getRegionIso(), AddressField.REGION, errors);
					break;
				case JAPAN:
					validateFieldNotNull(addressForm.getRegionIso(), AddressField.REGION, errors);
					validateStringField(addressForm.getLine2(), AddressField.LINE2, MAX_FIELD_LENGTH, errors);
					break;
				default:
					validateStringFieldLength(addressForm.getTitleCode(), AddressField.TITLE, MAX_FIELD_LENGTH, errors);
					break;
			}
		}
	}

	protected static void validateStringField(final String addressField, final AddressField fieldType,
											  final int maxFieldLength, final Errors errors)
	{
		if (addressField == null || StringUtils.isEmpty(addressField) || (StringUtils.length(addressField) > maxFieldLength))
		{
			errors.rejectValue(fieldType.getFieldKey(), fieldType.getErrorKey());
		}
	}

	protected static void validateStringFieldLength(final String field, final AddressField fieldType, final int maxFieldLength,
			final Errors errors)
	{
		if (StringUtils.isNotEmpty(field) && StringUtils.length(field) > maxFieldLength)
		{
			errors.rejectValue(fieldType.getFieldKey(), fieldType.getErrorKey());
		}
	}

	protected static void validateFieldNotNull(final String addressField, final AddressField fieldType,
											   final Errors errors)
	{
		if (addressField == null)
		{
			errors.rejectValue(fieldType.getFieldKey(), fieldType.getErrorKey());
		}
	}

	protected enum CountryCode
	{
		USA("US"), CANADA("CA"), JAPAN("JP"), CHINA("CN"), BRITAIN("GB"), GERMANY("DE"), DEFAULT("");

		private final String isoCode;

		private static final Map<String, CountryCode> lookupMap = new HashMap<String, CountryCode>();
		static
		{
			for (final CountryCode code : CountryCode.values())
			{
				lookupMap.put(code.getIsoCode(), code);
			}
		}

		private CountryCode(final String isoCodeStr)
		{
			this.isoCode = isoCodeStr;
		}

		public static CountryCode lookup(final String isoCodeStr)
		{
			CountryCode code = lookupMap.get(isoCodeStr);
			if (code == null)
			{
				code = DEFAULT;
			}
			return code;
		}

		public String getIsoCode()
		{
			return this.isoCode;
		}
	}

	protected enum AddressField
	{
		TITLE("titleCode", "address.title.invalid"), FIRSTNAME("firstName", "address.firstName.invalid"),
		LASTNAME("lastName", "address.lastName.invalid"), LINE1("line1", "address.line1.invalid"),
		LINE2("line2", "address.line2.invalid"), TOWN("townCity", "address.townCity.invalid"),
		POSTCODE("postcode", "address.postcode.invalid"), REGION("regionIso", "address.regionIso.invalid"),
		COUNTRY("countryIso", "address.country.invalid"),
		VATNUMBER("vat","vatnumber.invalid");
		;

		private final String fieldKey;
		private final String errorKey;

		private AddressField(final String fieldKey, final String errorKey)
		{
			this.fieldKey = fieldKey;
			this.errorKey = errorKey;
		}

		public String getFieldKey()
		{
			return this.fieldKey;
		}

		public String getErrorKey()
		{
			return this.errorKey;
		}
	}
}
