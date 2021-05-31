package com.meet2025.dataring;

import com.meet2025.dataring.domain.DataCatalog;
import com.meet2025.dataring.domain.DataCatalogRepository;
import com.meet2025.dataring.service.DataCatalogService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author Roy Cao
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase
public class CachingTests {

    @MockBean
    private DataCatalogRepository dataCatalogRepository;

    @Autowired
    private DataCatalogService dataCatalogService;

    @Test
    public void findDataCatalog_ReturnCatalog() throws Exception {
        BDDMockito.given(dataCatalogRepository.findByName(anyString()))
                .willReturn(new DataCatalog("Organization","Organization Catalog"));

        dataCatalogService.getDataCatalog("organization");
        dataCatalogService.getDataCatalog("organization");

        verify(dataCatalogRepository,times(1)).findByName("organization");
    }
}
