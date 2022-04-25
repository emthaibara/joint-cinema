package scbc.liyongjie.servicesignapi.exception;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/4
 */
public class SignException extends RuntimeException{

    public SignException() {
        super();
    }

    public SignException(String message) {
        super(message);
    }

    public SignException(String message, Throwable cause) {
        super(message, cause);
    }

    public SignException(Throwable cause) {
        super(cause);
    }

    protected SignException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
