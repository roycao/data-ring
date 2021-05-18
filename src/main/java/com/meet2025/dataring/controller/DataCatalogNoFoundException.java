package com.meet2025.dataring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Roy Cao
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DataCatalogNoFoundException extends RuntimeException {
}
