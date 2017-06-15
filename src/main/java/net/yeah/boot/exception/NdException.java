package net.yeah.boot.exception;


public class NdException extends RuntimeException {
    private Integer code;

    public NdException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
