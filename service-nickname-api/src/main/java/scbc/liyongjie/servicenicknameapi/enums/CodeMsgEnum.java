package scbc.liyongjie.servicenicknameapi.enums;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/30
 */


public enum CodeMsgEnum {

    VIOLATION_NICK_NAME(1003,"昵称可以是2-15位的中文,英文,数字,下划线以及一些常用的标点符号"),
    UN_REGISTER(1004,"您还未注册一个账号，请先注册登录后再操作");

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
