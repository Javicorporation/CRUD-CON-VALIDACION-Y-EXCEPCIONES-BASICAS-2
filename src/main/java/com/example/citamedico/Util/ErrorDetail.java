package com.example.citamedico.Util;

import lombok.Data;

@Data
public class ErrorDetail {
    private int status;
    private String message;
    private String details;
    private long timeStamp;

}
