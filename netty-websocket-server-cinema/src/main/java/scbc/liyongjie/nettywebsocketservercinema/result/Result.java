package scbc.liyongjie.nettywebsocketservercinema.result;


/**
 *
 *@Author:SCBC_LiYongJie
 *@time:2022/3/20
 *
*/

public class Result <T>{

    private Integer status;
    private Integer type;
    private String codeMsg;
    private T data;

    public Result(Integer type , T data) {
        this.type = type;
        this.codeMsg = null;
        this.data = data;
        this.status = 1;
    }

    public Result(T data) {
        this.data = data;
        this.status = 1;
        this.codeMsg = null;
        this.type = -1;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
