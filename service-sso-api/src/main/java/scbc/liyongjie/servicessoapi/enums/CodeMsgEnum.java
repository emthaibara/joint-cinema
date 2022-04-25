package scbc.liyongjie.servicessoapi.enums;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/2/18
 */
public enum CodeMsgEnum {

    NOTEXIST(10122,"该用户尚未注册，请先注册后登录"),
    FAIL(10012,"密码不正确请重新输入");

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
