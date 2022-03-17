package scbc.liyongjie.serviceavatarapi.exception;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/16
 */


public class OverSizeAvatarException extends RuntimeException{
    public OverSizeAvatarException() {
    }

    public OverSizeAvatarException(String message) {
        super(message);
    }

    public OverSizeAvatarException(String message, Throwable cause) {
        super(message, cause);
    }

    public OverSizeAvatarException(Throwable cause) {
        super(cause);
    }

    public OverSizeAvatarException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
