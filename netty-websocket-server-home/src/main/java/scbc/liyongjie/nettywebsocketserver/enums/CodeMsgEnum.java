package scbc.liyongjie.nettywebsocketserver.enums;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/30
 */


public enum CodeMsgEnum {

    VERIFY_FAIL(1001,"jwt token verify fail"),
    FRIEND_REPEAT(1002,"好友已经添加"),
    FRIEND_NOT_EXIST(1003,"好友不存在，无法删除");

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
