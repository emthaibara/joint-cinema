package scbc.liyongjie.serviceavatarapi.exception;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/16
 */


public class NotDataException extends RuntimeException{
    public NotDataException() {
    }

    public NotDataException(String message) {
        super(message);
    }

    public NotDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotDataException(Throwable cause) {
        super(cause);
    }

    public NotDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
