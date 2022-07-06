package shorts.exception;

public class ShortsException extends RuntimeException {
    private int code;

    public int getCode() {
        return code;
    }

    public ShortsException() {
        super();
    }
    public ShortsException(String message, Throwable cause) {
        super(message, cause);
    }
    public ShortsException(String message, int code, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
    public ShortsException(String message) {
        super(message);
    }
    public ShortsException(String message, int code) {
        super(message);
        this.code = code;
    }
    public ShortsException(Throwable cause) {
        super(cause);
    }
}