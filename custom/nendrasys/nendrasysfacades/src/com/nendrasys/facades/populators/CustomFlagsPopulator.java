package com.nendrasys.facades.populators;

import com.nendrasys.core.model.ElectronicsColorVariantProductModel;
import com.nendrasys.facades.product.data.GenderData;


import de.hybris.platform.commercefacades.product.converters.populator.AbstractProductPopulator;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.enums.Gender;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.variants.model.VariantProductModel;
import org.springframework.beans.factory.annotation.Required;

import javax.xml.transform.Source;

public class CustomFlagsPopulator <SOURCE extends ProductModel, TARGET extends ProductData> extends AbstractProductPopulator<SOURCE, TARGET>{

    /*@Override
    public void populate(ProductModel productModel, ProductData productData) throws ConversionException {
        ElectronicsColorVariantProductModel electronicsColorVariantProductModel=(ElectronicsColorVariantProductModel)productModel;

        productData.setFLAGS(electronicsColorVariantProductModel.getIsNewProduct());
    }
*/
    @Override
    public void populate(final ProductModel source, final ProductData target) throws ConversionException
    {
        //final ProductModel baseProduct = getBaseProduct(source);

        if (source instanceof ElectronicsColorVariantProductModel)
        {
            final ElectronicsColorVariantProductModel electronicsColorVariantProductModel = (ElectronicsColorVariantProductModel) source;
            if (electronicsColorVariantProductModel!=null)
                target.setFLAGS(electronicsColorVariantProductModel.getIsNewProduct());

        }

    }

    protected ProductModel getBaseProduct(final ProductModel productModel)
    {
        ProductModel currentProduct = productModel;
        while (currentProduct instanceof VariantProductModel)
        {
            final VariantProductModel variant = (VariantProductModel) currentProduct;
            currentProduct = variant.getBaseProduct();
        }
        return currentProduct;
    }

}
