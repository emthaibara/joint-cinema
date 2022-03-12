package cn.scbc.servicevideouploadapi.exception;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/13
 */


public class ChunkUploadException extends RuntimeException{
    public ChunkUploadException() {
    }

    public ChunkUploadException(String message) {
        super(message);
    }

    public ChunkUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChunkUploadException(Throwable cause) {
        super(cause);
    }

    public ChunkUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
