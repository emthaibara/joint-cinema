package cn.scbc.service.audit.api.result;

import cn.scbc.service.audit.api.enums.CodeMsgEnum;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/4/15
 */


public class Result <T>{

    private Integer status;
    private T data;
    private String codeMsg;

    public Result(){
        this.status = 1;
        this.data = null;
        this.codeMsg = null;
    }

    public Result(T data){
        this.data = data;
        this.codeMsg = null;
        this.status = 1;
    }

    public Result<T> error(CodeMsgEnum codeMsgEnum,T data){
        this.data = data;
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
