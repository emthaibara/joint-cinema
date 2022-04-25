package scbc.liyongjie.nettywebsocketserverhome.result;


import scbc.liyongjie.nettywebsocketserverhome.enums.CodeMsgEnum;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/30
 */

public class Result <T>{

    private Integer status;
    private String codeMsg;
    private T data;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
        this.codeMsg = null;
        this.status = 1;
    }

    public Result<?> error(CodeMsgEnum codeMsgEnum) {
        this.data = null;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
