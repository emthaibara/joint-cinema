package cn.scbc.servicevideouploadapi.exception;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/13
 */

public class BuildChunkFolderException extends RuntimeException{
    public BuildChunkFolderException() {
    }

    public BuildChunkFolderException(String message) {
        super(message);
    }

    public BuildChunkFolderException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuildChunkFolderException(Throwable cause) {
        super(cause);
    }

    public BuildChunkFolderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
