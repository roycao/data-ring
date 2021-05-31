package com.meet2025.dataring.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Roy Cao
 */
public interface DataCatalogRepository extends CrudRepository<DataCatalog,String> {
     DataCatalog findByName(String organization);
}
