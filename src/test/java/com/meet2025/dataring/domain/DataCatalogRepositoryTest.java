package com.meet2025.dataring.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Roy Cao
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
class DataCatalogRepositoryTest {

    @Autowired
    private DataCatalogRepository dataCatalogRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void findByName_ShouldReturnDataCatalog() throws Exception{
        DataCatalog savedDataCatalog = testEntityManager.persistFlushFind(
                new DataCatalog("abc", "Organization Info"));

        DataCatalog organization = dataCatalogRepository.findByName("abc");

        Assertions.assertThat(savedDataCatalog.getName()).isEqualTo(organization.getName());
        Assertions.assertThat(savedDataCatalog.getDescription()).isEqualTo(organization.getDescription());

    }
}