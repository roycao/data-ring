package com.meet2025.dataring.service;

import com.meet2025.dataring.controller.DataCatalogNoFoundException;
import com.meet2025.dataring.domain.DataCatalog;
import com.meet2025.dataring.domain.DataCatalogRepository;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

/**
 * @author Roy Cao
 */
@ExtendWith(MockitoExtension.class)
public class DataCatalogServiceTest {

    @Mock
    private DataCatalogRepository dataCatalogRepository;

    private DataCatalogService catalogService;

    @BeforeEach
    public void Setup() throws Exception{
        catalogService = new DataCatalogService(dataCatalogRepository);
    }

    @Test
    public void getDataCatalog_ShouldReturnInfo(){
        given(this.dataCatalogRepository.findByName("Organization"))
                .willReturn(new DataCatalog("Organization","Organization Catalog"));

        DataCatalog catalog = catalogService.getDataCatalog("Organization");
        assertThat(catalog.getName()).isEqualTo("Organization");
        assertThat(catalog.getDescription()).isEqualTo("Organization Catalog");
    }

    @Test
    public void getDataCatalog_ShouldReturnNotFoundException(){
        given(this.dataCatalogRepository.findByName("Organization"))
                .willReturn(null);

        DataCatalogNoFoundException ex = assertThrows(DataCatalogNoFoundException.class, () -> {
            this.catalogService.getDataCatalog("Organization");
        });

        assertThat(ex).isNotNull();
    }
}