package com.nendrasys.facades.populators;

import com.nendrasys.core.model.ApparelProductModel;
import com.nendrasys.core.model.ElectronicsColorVariantProductModel;
import com.nendrasys.facades.product.data.GenderData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.enums.Gender;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.variants.model.VariantProductModel;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class TestFlagPopulator implements Populator<ProductModel, ProductData> {

  /*  @Override
    public void populate(final ProductModel source, final ProductData target) throws ConversionException
    {
        if (source instanceof ElectronicsColorVariantProductModel)
        {
            final ElectronicsColorVariantProductModel electronicsColorVariantProductModel = (ElectronicsColorVariantProductModel) source;

                target.setFLAGS(electronicsColorVariantProductModel.getIsNewProduct());

        }
    }*/

    @Override
    public void populate(final ProductModel source, final ProductData target) throws ConversionException
    {
        final ProductModel baseProduct = getBaseProduct(source);

        if (baseProduct instanceof ElectronicsColorVariantProductModel)
        {
            final ElectronicsColorVariantProductModel electronicsColorVariantProductModel = (ElectronicsColorVariantProductModel) baseProduct;
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
