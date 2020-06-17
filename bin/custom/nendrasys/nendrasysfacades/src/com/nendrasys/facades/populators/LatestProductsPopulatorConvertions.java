package com.nendrasys.facades.populators;

import com.nendrasys.core.model.ElectronicsColorVariantProductModel;
import de.hybris.platform.commercefacades.product.data.ImageData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.variants.model.VariantProductModel;

import java.util.Collection;

public class LatestProductsPopulatorConvertions implements Populator<ProductModel,ProductData> {

    @Override
    public void populate(final ProductModel source, final ProductData target) throws ConversionException {
      /*  final ProductModel baseProduct = getBaseProduct(source);

        if (baseProduct instanceof ElectronicsColorVariantProductModel)
        {*/
           // final ElectronicsColorVariantProductModel electronicsColorVariantProductModel = (ElectronicsColorVariantProductModel) baseProduct;
           // target.setImages((Collection<ImageData>) source.getPicture());
           // target.setFLAGS(source.getFLAGS());
            //target.setMANUFACTURINGDETAILS(source.getMANUFACTURINGDETAILS());

            target.setAverageRating(source.getAverageRating());
            target.setCode(source.getCode());
            target.setName(source.getName());
            target.setSummary(source.getSummary());
            target.setNumberOfReviews(source.getNumberOfReviews());
            System.out.println("In Converter populator::"+target.getName()+" "+target.getCode());
       // }

    }

   /* protected ProductModel getBaseProduct(final ProductModel productModel)
    {
        ProductModel currentProduct = productModel;
        while (currentProduct instanceof VariantProductModel)
        {
            final VariantProductModel variant = (VariantProductModel) currentProduct;
            currentProduct = variant.getBaseProduct();
        }
        return currentProduct;

    }
*/
}

