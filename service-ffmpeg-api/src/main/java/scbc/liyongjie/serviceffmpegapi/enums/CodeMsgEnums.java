package scbc.liyongjie.serviceffmpegapi.enums;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/12
 */


public enum CodeMsgEnums {

    ;

    private final String codeMsg;
    private final Integer status;

    CodeMsgEnums(String codeMsg, Integer status) {
        this.codeMsg = codeMsg;
        this.status = status;
    }

    public String getCodeMsg() {
        return codeMsg;
    }

    public Integer getStatus() {
        return status;
    }
}
