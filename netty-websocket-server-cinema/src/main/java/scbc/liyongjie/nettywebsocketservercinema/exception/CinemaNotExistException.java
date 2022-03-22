package scbc.liyongjie.nettywebsocketservercinema.exception;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 */


public class CinemaNotExistException extends RuntimeException{
    public CinemaNotExistException() {
    }

    public CinemaNotExistException(String message) {
        super(message);
    }

    public CinemaNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public CinemaNotExistException(Throwable cause) {
        super(cause);
    }

    public CinemaNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
