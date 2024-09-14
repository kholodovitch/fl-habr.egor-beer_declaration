package ek.declaration;

public enum StatusCode {
    OK(200),
    CREATED(201),
    ACCEPTED(202),
    BAD_REQUEST(400),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405);

    StatusCode(int code) {
        this.code = code;
    }

    private int code;

    public int getCode() {
        return code;
    }
}