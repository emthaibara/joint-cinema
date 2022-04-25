package scbc.liyongjie.nettywebsocketservercinema.enums;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/30
 */


public enum CodeMsgEnum {

    CINEMA_NOT_EXIST(50005,"该放映室不存在或已经销毁"),
    NOT_CINEMA_MEMBER(5006,"你可能不是该放映室的成员emmmmm0.0");

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
