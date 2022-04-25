package scbc.liyongjie.servicenicknameapi.exception;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/23
 */


public class NickNameException extends RuntimeException{
    public NickNameException() {
    }

    public NickNameException(String message) {
        super(message);
    }

    public NickNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public NickNameException(Throwable cause) {
        super(cause);
    }

    public NickNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
