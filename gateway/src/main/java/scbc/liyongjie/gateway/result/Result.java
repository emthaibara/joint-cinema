package scbc.liyongjie.gateway.result;

import scbc.liyongjie.gateway.enums.CodeMsgEnums;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/9
 */


public class Result <T>{
    private Integer status;
    private T data;
    private String codeMsg;



    public Result<?> error(CodeMsgEnums codeMsgEnums){
        this.codeMsg = codeMsgEnums.getCodeMsg();
        this.status = codeMsgEnums.getStatus();
        this.data = null ;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCodeMsg() {
        return codeMsg;
    }

    public void setCodeMsg(String codeMsg) {
        this.codeMsg = codeMsg;
    }
}
