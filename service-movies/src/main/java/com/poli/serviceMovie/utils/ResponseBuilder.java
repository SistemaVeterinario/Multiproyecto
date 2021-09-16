package com.poli.serviceMovie.utils;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import org.springframework.stereotype.Component;
import static org.springframework.http.HttpStatus.OK;

@Component
public class ResponseBuilder {

    public Response success(){
        return Response.builder()
                .status(OK.value())
                .data(OK)
                .build();
    }
    public Response success(Object data){
        return Response.builder()
                .status(OK.value())
                .data(data)
                .build();
    }
    public Response failed(){
        return Response.builder()
                .status(INTERNAL_SERVER_ERROR.value())
                .data(INTERNAL_SERVER_ERROR)
                .build();
    }
    public Response failed(Object data){
        return Response.builder()
                .status(INTERNAL_SERVER_ERROR.value())
                .data(data)
                .build();
    }
}
