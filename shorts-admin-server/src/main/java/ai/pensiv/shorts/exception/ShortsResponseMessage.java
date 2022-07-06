package shorts.exception;

public class ShortsResponseMessage {
    public static final int OK				= 1200;
    public static final int FOUND			= 1302;
    public static final int BAD_REQUEST		= 1400;
    public static final int UNAUTHORIZED	= 1401;
    public static final int FORBIDDEN		= 1403;
    public static final int NOT_FOUND		= 1404;
    public static final int NOT_SUPPORTED	= 1405;
    public static final int SERVER_ERROR	= 1500;

    private int code;
    private String message;

    public ShortsResponseMessage(int code) {
        this.code = code;
    }

    public ShortsResponseMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}