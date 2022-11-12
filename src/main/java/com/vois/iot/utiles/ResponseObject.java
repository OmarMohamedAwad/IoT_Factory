package com.vois.iot.utiles;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseObject {
	@JsonProperty("success")
    private boolean success;
    @JsonProperty("data")
    private List<?> infoList;
    @JsonProperty("message")
    private String message;

    // A default constructor is required for serialization/deserialization to work
    public ResponseObject(boolean success, List<?> data, String message) {
    	this.success = success;
    	this.infoList = data;
    	this.message = message;
    }
    
    
}
