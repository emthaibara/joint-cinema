package scbc.liyongjie.servicesignapi.enums;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/2/18
 */

public enum CodeMsgEnum {

    REPEAT(1001,"该手机号码已注册，请勿重复注册"),
    STOREHOUSE_BUILD_ERROR(1002,"仓库初始化失败");

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
