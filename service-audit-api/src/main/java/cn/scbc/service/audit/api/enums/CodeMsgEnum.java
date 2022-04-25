package cn.scbc.service.audit.api.enums;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/4/15
 */

public enum CodeMsgEnum {
    ;
    private final String codeMsg;
    private final Integer status;

    CodeMsgEnum(String codeMsg, Integer status) {
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
