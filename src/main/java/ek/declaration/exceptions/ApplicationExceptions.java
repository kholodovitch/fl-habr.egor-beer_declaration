package ek.declaration.exceptions;

import java.util.function.Function;
import java.util.function.Supplier;

public class ApplicationExceptions {

    public static Function<? super Throwable, RuntimeException> invalidRequest() {
        return thr -> new ApplicationException(400, thr.getMessage());
    }

    public static Supplier<RuntimeException> methodNotAllowed(String message) {
        return () -> new ApplicationException(405, message);
    }

    public static Supplier<RuntimeException> notFound(String message) {
        return () -> new ApplicationException(404, message);
    }
}
