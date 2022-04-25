package cn.scbc.servicevideouploadapi.exception;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/13
 */


public class StoreHouseNotExistsException extends RuntimeException{
    public StoreHouseNotExistsException() {
    }

    public StoreHouseNotExistsException(String message) {
        super(message);
    }

    public StoreHouseNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public StoreHouseNotExistsException(Throwable cause) {
        super(cause);
    }

    public StoreHouseNotExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
