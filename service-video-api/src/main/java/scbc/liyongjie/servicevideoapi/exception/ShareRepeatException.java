package scbc.liyongjie.servicevideoapi.exception;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/19
 */


public class ShareRepeatException extends RuntimeException{
    public ShareRepeatException() {
    }

    public ShareRepeatException(String message) {
        super(message);
    }

    public ShareRepeatException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShareRepeatException(Throwable cause) {
        super(cause);
    }

    public ShareRepeatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
