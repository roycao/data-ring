package com.meet2025.dataring.controller;

import com.meet2025.dataring.domain.DataCatalog;
import com.meet2025.dataring.service.DataCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Roy Cao
 */
@RestController
@RequestMapping("/datacatalogs")
public class DataCatalogController {

    @Autowired
    private DataCatalogService dataCatalogService;

    @GetMapping("/{name}")
    public DataCatalog getDataCatalog(@PathVariable String name){
        DataCatalog dataCatalog = dataCatalogService.getDataCatalog(name);
        if(dataCatalog == null){
            throw new DataCatalogNoFoundException();
        }
        return dataCatalog;
    }

    @GetMapping
    public List<DataCatalog> getAllDataCatalogs()
    {
        return dataCatalogService.getAllDataCatalogs();
    }

    @PostMapping
    public DataCatalog createDatalog(@RequestBody DataCatalog dataCatalog){
        return dataCatalogService.createDataCatalogService(dataCatalog);
    }
}
