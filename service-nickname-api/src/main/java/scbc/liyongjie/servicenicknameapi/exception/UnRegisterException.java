package scbc.liyongjie.servicenicknameapi.exception;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/16
 */


public class UnRegisterException  extends RuntimeException{
    public UnRegisterException() {
    }

    public UnRegisterException(String message) {
        super(message);
    }

    public UnRegisterException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnRegisterException(Throwable cause) {
        super(cause);
    }

    public UnRegisterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
