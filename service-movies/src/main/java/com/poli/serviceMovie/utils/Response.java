package com.poli.serviceMovie.utils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private Integer status;
    private Object data;
}
