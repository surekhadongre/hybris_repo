package com.nendrasys.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.model.config.SolrFacetSearchConfigModel;
import org.apache.log4j.Logger;


public class CustomPriceGroupPopulator implements Populator<SolrFacetSearchConfigModel, IndexConfig> {
    private final Logger logger = Logger.getLogger(CustomPriceGroupPopulator.class);
    @Override
    public void populate(final SolrFacetSearchConfigModel source, final IndexConfig target) throws ConversionException {
        this.logger.info("CustomPriceGroupPopulator has been called!!!!!");
        target.setUserGroup(source.getUserGroup());
    }
}
