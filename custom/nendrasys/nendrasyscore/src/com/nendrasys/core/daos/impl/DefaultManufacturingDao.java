package com.nendrasys.core.daos.impl;

import com.nendrasys.core.daos.ManufacturingDetailsDao;
import com.nendrasys.core.model.ManufacturingDetailsModel;
import de.hybris.platform.acceleratorservices.dataexport.googlelocal.model.Product;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.servicelayer.data.SearchPageData;
import de.hybris.platform.jalo.link.Link;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.search.paginated.PaginatedFlexibleSearchParameter;
import de.hybris.platform.servicelayer.search.paginated.PaginatedFlexibleSearchService;
import de.hybris.platform.servicelayer.search.paginated.constants.SearchConstants;
import de.hybris.platform.servicelayer.search.paginated.impl.DefaultPaginatedFlexibleSearchService;
import de.hybris.platform.servicelayer.search.paginated.util.PaginatedSearchUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import javax.annotation.Resource;
import java.util.*;


/**
 * Implementation for ManufacturingDetailsDao
 */
public class DefaultManufacturingDao implements ManufacturingDetailsDao {
    private static final Logger LOG = Logger.getLogger(DefaultManufacturingDao.class);
    private static final String GET_ALL_MANUFACTURING_DETAILS="SELECT {md:"+ManufacturingDetailsModel.PK+"} FROM {"+ManufacturingDetailsModel._TYPECODE+" AS md}";
    private FlexibleSearchService flexibleSearchService;
    private PaginatedFlexibleSearchParameter parameter;
    @Resource
    private DefaultPaginatedFlexibleSearchService defaultPaginatedFlexibleSearchService;

    protected FlexibleSearchService getFlexibleSearchService() {
        return this.flexibleSearchService;
    }
    @Required
    public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }
    @Override
    public List<ManufacturingDetailsModel> findManufacturingDetails(final String companyName) {
        final Map<String,Object> param = new HashedMap();
        param.put("company",companyName);
        final String query = "SELECT {"+ManufacturingDetailsModel.PK+"} FROM {"+ManufacturingDetailsModel._TYPECODE+"} WHERE {"+ManufacturingDetailsModel.COMPANY+"} =?company";
        final SearchResult<ManufacturingDetailsModel> searchResult = getFlexibleSearchService().search(query,param);
        final List<ManufacturingDetailsModel> modelList = new ArrayList<>();
        modelList.addAll(searchResult.getResult());
        LOG.info("Convert List in Dao::"+modelList.toString());
        return modelList;
    }

    @Override
    public List<ManufacturingDetailsModel> findManufacturingDetailsByProduct(final String productCode) {
        final StringBuilder query = new StringBuilder();
        query.append(" SELECT {md." + ManufacturingDetailsModel.PK + "} ");
        query.append(" FROM {" + ManufacturingDetailsModel._TYPECODE + " AS md ");
        query.append(" JOIN " + ProductModel._MANUFACTURTOPRODUCTREL + " AS mpr ");
        query.append(" ON { md." + ManufacturingDetailsModel.PK + "}={ mpr." + Link.SOURCE + "} ");
        query.append(" JOIN " + ProductModel._TYPECODE + " AS p ");
        query.append(" ON { mpr." + Link.TARGET + "} = { p." + ProductModel.PK + "} }");
        query.append(" WHERE { p." + ProductModel.CODE + "} ");
        query.append(" = ?").append(ProductModel.CODE);
        System.out.println("Query::"+query);
        final FlexibleSearchQuery query1 = new FlexibleSearchQuery(query);
        query1.addQueryParameter(ProductModel.CODE, productCode);
        final SearchResult<ManufacturingDetailsModel> searchResult = getFlexibleSearchService().search(query1);
        return searchResult.getResult();
    }

    @Override
    public List<ManufacturingDetailsModel> findAllManufacturingDetails(int start, final int range) {
       /* System.out.println("In dao begining::");
        //this.defaultPaginatedFlexibleSearchService =new DefaultPaginatedFlexibleSearchService();
        this.parameter =new PaginatedFlexibleSearchParameter();
        final Map<String, String> sortCodeToQueryAlias = new HashMap<>();
        sortCodeToQueryAlias.put(ManufacturingDetailsModel.COMPANY, "md");
        sortCodeToQueryAlias.put(ManufacturingDetailsModel.COUNTRY, "md");
        this.parameter.setFlexibleSearchQuery(new FlexibleSearchQuery(GET_ALL_MANUFACTURING_DETAILS));
        this.parameter.setSortCodeToQueryAlias(sortCodeToQueryAlias);
        System.out.println("Query::"+GET_ALL_MANUFACTURING_DETAILS);
        final Map<String, String> sortMap = new LinkedHashMap();
        sortMap.put(ManufacturingDetailsModel.COMPANY, SearchConstants.ASCENDING);
        final SearchPageData searchPageData = PaginatedSearchUtils.createSearchPageDataWithPaginationAndSorting(5, 1, true, sortMap);
        this.parameter.setSearchPageData(searchPageData);
        System.out.println("DefSearchService::"+ this.defaultPaginatedFlexibleSearchService.toString());
        System.out.println("Parameter::"+ this.parameter.toString());
        final SearchPageData<ManufacturingDetailsModel> searchResult = this.defaultPaginatedFlexibleSearchService.search(this.parameter);
        System.out.println("dao data size::"+searchResult.getResults().size());*/
        /*int start = 0;
        final int range = 10;*/
        int total=1;
        SearchResult<ManufacturingDetailsModel>   searchResult=null;
        final String query = "SELECT {" + ManufacturingDetailsModel.PK + "} FROM {"+ ManufacturingDetailsModel._TYPECODE + "} ORDER BY {"+ManufacturingDetailsModel.COMPANY+"} ASC";
        final FlexibleSearchQuery fQuery = new FlexibleSearchQuery(query);
        fQuery.setCount(range);
        fQuery.setNeedTotal(true);

        do
        {
            fQuery.setStart(start);
            searchResult = getFlexibleSearchService().search(fQuery);
            total = searchResult.getTotalCount();
            start += range;
            return searchResult.getResult();

        }
        while(start < total);
    }

    @Override
    public List<ManufacturingDetailsModel> findAllManufacturingDetails() {
        final String query = "SELECT {" + ManufacturingDetailsModel.PK + "} FROM {"+ ManufacturingDetailsModel._TYPECODE + "} ORDER BY {"+ManufacturingDetailsModel.COMPANY+"} ASC";
        final FlexibleSearchQuery fQuery = new FlexibleSearchQuery(query);
        final SearchResult<ManufacturingDetailsModel> searchResult = getFlexibleSearchService().search(fQuery);
        return searchResult.getResult();
    }


}

