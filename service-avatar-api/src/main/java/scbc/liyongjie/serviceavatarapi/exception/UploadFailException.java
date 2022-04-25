package scbc.liyongjie.serviceavatarapi.exception;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/16
 */


public class UploadFailException extends RuntimeException{
    public UploadFailException() {
    }

    public UploadFailException(String message) {
        super(message);
    }

    public UploadFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public UploadFailException(Throwable cause) {
        super(cause);
    }

    public UploadFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
