package scbc.liyongjie.nettywebsocketserverhome.exception;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/15
 */


public class FriendRepeatException extends RuntimeException{
    public FriendRepeatException() {
        super();
    }

    public FriendRepeatException(String message) {
        super(message);
    }

    public FriendRepeatException(String message, Throwable cause) {
        super(message, cause);
    }

    public FriendRepeatException(Throwable cause) {
        super(cause);
    }

    protected FriendRepeatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
