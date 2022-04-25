package scbc.liyongjie.nettywebsocketservercinema.exception;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/30
 */


public class NotCinemaMemberException extends RuntimeException{
    public NotCinemaMemberException() {
    }

    public NotCinemaMemberException(String message) {
        super(message);
    }

    public NotCinemaMemberException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotCinemaMemberException(Throwable cause) {
        super(cause);
    }

    public NotCinemaMemberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
