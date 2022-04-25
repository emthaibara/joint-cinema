package scbc.liyongjie.servicessoapi.result;

import scbc.liyongjie.servicessoapi.enums.CodeMsgEnum;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/29
 */

public class Result<T> {

    private Integer status;
    private String codeMsg;
    private T data;
    
    public Result() {

    }
    
    public Result(T data) {
        this.data = data;
        codeMsg = null;
        status = 1;
    }

    public Result(String codeMsg, Integer status){
        this.status = status;
        this.codeMsg = codeMsg;
        this.data = null;
    }

    public static Result<?> loginSuccess(){
        return new Result<>("login success!");
    }

    public Result<?> error(CodeMsgEnum codeMsgEnum){
        this.codeMsg = codeMsgEnum.getCodeMsg();
        this.status = codeMsgEnum.getStatus();
        this.data = null ;
        return this;
    }

    public Result<?> error(String codeMsg,T data){
        this.codeMsg = codeMsg;
        this.status = -1;
        this.data = data ;
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
