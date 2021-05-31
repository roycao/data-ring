package com.meet2025.dataring.service;

import com.meet2025.dataring.controller.DataCatalogNoFoundException;
import com.meet2025.dataring.domain.DataCatalog;
import com.meet2025.dataring.domain.DataCatalogRepository;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Roy Cao
 */
@Service
public class DataCatalogService {

    private DataCatalogRepository dataCatalogRepository;

    public DataCatalogService(DataCatalogRepository dataCatalogRepository) {
        this.dataCatalogRepository = dataCatalogRepository;
    }

    @Cacheable("datacatalogs")
    public DataCatalog getDataCatalog(String name) throws DataCatalogNoFoundException {
        DataCatalog catalog = dataCatalogRepository.findByName(name);
        if(catalog == null){
            throw new DataCatalogNoFoundException();
        }

        return catalog;
    }

    public DataCatalog createDataCatalogService(DataCatalog dataCatalog) {
        return dataCatalogRepository.save(dataCatalog);
    }

    public List<DataCatalog> getAllDataCatalogs() {
        Iterable<DataCatalog> all = dataCatalogRepository.findAll();
        return IterableUtils.toList(all);
    }
}
