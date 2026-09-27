package com.manu.SOLID_Principles.SRP.WithSRP;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class ObjectMapperUtils {
    public static ObjectMapper mapper = new ObjectMapper();

    public static User readValue(final String stream) throws IOException {
        return mapper.readValue(stream, User.class);
    }
}
