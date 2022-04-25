package scbc.liyongjie.servicessoapi.exception;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/6
 */

public class PasswordException extends RuntimeException{
    public PasswordException() {
    }

    public PasswordException(String message) {
        super(message);
    }

    public PasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordException(Throwable cause) {
        super(cause);
    }

    public PasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
