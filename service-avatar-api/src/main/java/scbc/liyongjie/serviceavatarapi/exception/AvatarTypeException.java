package scbc.liyongjie.serviceavatarapi.exception;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/16
 */


public class AvatarTypeException extends RuntimeException{
    public AvatarTypeException() {
    }

    public AvatarTypeException(String message) {
        super(message);
    }

    public AvatarTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AvatarTypeException(Throwable cause) {
        super(cause);
    }

    public AvatarTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
