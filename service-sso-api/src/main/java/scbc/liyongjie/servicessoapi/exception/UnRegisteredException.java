package scbc.liyongjie.servicessoapi.exception;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/6
 */

public class UnRegisteredException extends RuntimeException{

    public UnRegisteredException() {
        super();
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

    protected UnRegisteredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
