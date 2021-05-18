package com.meet2025.dataring.controller;

import com.meet2025.dataring.domain.DataCatalog;
import com.meet2025.dataring.service.DataCatalogService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Roy Cao
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest
public class DataCatalogControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DataCatalogService catalogService;

    @Test
    public void TestDataCatalog_ShouldReturnDataCatalog() throws Exception{
        when(this.catalogService.getDataCatalog(anyString())).thenReturn(
                new DataCatalog("Organization","Organization Catalog"));

        mockMvc.perform(get("/datacatalogs/organization"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Organization"))
                .andExpect(jsonPath("description").value("Organization Catalog"));
    }

    @Test
    public void getDataCatalog_NotFound() throws Exception{
        when(this.catalogService.getDataCatalog(anyString())).thenReturn(null);
        this.mockMvc.perform(get("/datacatalogs/organization"))
                .andExpect(status().isNotFound());
    }
}
