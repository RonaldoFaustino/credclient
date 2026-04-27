package com.devsuperior.crudcliente.services.exceptions;

public class ResourceNotFoundException extends  RuntimeException {

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}