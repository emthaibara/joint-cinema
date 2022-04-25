package scbc.liyongjie.servicesignapi.exception;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/12
 */


public class StoreHouseBuildException extends RuntimeException{
    public StoreHouseBuildException() {
        super();
    }

    public StoreHouseBuildException(String message) {
        super(message);
    }

    public StoreHouseBuildException(String message, Throwable cause) {
        super(message, cause);
    }

    public StoreHouseBuildException(Throwable cause) {
        super(cause);
    }

    protected StoreHouseBuildException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
