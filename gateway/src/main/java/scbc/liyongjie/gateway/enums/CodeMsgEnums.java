package scbc.liyongjie.gateway.enums;

public enum CodeMsgEnums {

    ILLEGAL("非法的请求",101011),
    EXPIRED("登录超时,请重新登录",1111);

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
