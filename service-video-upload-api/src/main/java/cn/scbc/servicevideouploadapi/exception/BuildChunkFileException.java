package cn.scbc.servicevideouploadapi.exception;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/13
 */


public class BuildChunkFileException extends RuntimeException{
    public BuildChunkFileException() {
    }

    public BuildChunkFileException(String message) {
        super(message);
    }

    public BuildChunkFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuildChunkFileException(Throwable cause) {
        super(cause);
    }

    public BuildChunkFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
