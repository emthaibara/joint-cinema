package scbc.liyongjie.nettywebsocketserverhome.exception;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/15
 */


public class FriendNotExistException extends RuntimeException{
    public FriendNotExistException() {
    }

    public FriendNotExistException(String message) {
        super(message);
    }

    public FriendNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public FriendNotExistException(Throwable cause) {
        super(cause);
    }

    public FriendNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
