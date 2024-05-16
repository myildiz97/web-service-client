package com.ims.restModel;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GeneralResponse(
        HashMap<String, String> responseEntity) {
}
