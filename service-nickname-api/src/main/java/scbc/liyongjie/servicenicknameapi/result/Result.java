package scbc.liyongjie.servicenicknameapi.result;


import scbc.liyongjie.servicenicknameapi.enums.CodeMsgEnum;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/30
 */

public class Result<T>{

    private Integer status;
    private String codeMsg;
    private T t;

    public Result(T t) {
        this.t = t;
        this.codeMsg = null;
        this.status = 2000;
    }

    public Result<?> error(CodeMsgEnum codeMsgEnum) {
        this.t = null;
        this.status = codeMsgEnum.getStatus();
        this.codeMsg = codeMsgEnum.getCodeMsg();
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCodeMsg() {
        return codeMsg;
    }

    public void setCodeMsg(String codeMsg) {
        this.codeMsg = codeMsg;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
