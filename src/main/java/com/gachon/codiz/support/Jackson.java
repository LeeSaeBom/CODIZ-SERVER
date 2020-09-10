package com.gachon.codiz.support;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Jackson {

    private static final ObjectMapper MAPPER =
            new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
                              .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                              .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                              .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                              .registerModule(new JavaTimeModule());

    public static String writeValueAsString(Object message) {
        try {
            return MAPPER.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            return StringUtils.EMPTY;
        }
    }
}
