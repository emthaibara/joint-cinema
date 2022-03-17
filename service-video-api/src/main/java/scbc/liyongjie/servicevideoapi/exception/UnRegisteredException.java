package scbc.liyongjie.servicevideoapi.exception;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/17
 */


public class UnRegisteredException extends RuntimeException{
    public UnRegisteredException() {
    }

    public UnRegisteredException(String message) {
        super(message);
    }

    public UnRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnRegisteredException(Throwable cause) {
        super(cause);
    }

    public UnRegisteredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
