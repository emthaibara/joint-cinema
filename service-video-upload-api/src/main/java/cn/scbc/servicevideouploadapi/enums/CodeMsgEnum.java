package cn.scbc.servicevideouploadapi.enums;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/2/18
 */

public enum CodeMsgEnum {

    NOT_EXITS(101123,"该视频可能已经上传，或上传中断请重新上传");

    private final Integer status;
    private final String codeMsg;

    CodeMsgEnum(Integer status, String codeMsg) {
        this.status = status;
        this.codeMsg = codeMsg;
    }

    public Integer getStatus() {
        return status;
    }

    public String getCodeMsg() {
        return codeMsg;
    }

}
