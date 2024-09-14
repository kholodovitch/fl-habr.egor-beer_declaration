package ek.declaration.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Headers;
import ek.declaration.exceptions.ApplicationExceptions;
import io.vavr.control.Try;

import java.io.InputStream;

public abstract class HandlerJSON {

    private final ObjectMapper objectMapper = new ObjectMapper();;

    protected <T> byte[] writeResponse(T response) {
        return Try.of(() -> objectMapper.writeValueAsBytes(response))
                .getOrElseThrow(ApplicationExceptions.invalidRequest());
    }

    protected static Headers getHeaders(String key, String value) {
        Headers headers = new Headers();
        headers.set(key, value);
        return headers;
    }
}
