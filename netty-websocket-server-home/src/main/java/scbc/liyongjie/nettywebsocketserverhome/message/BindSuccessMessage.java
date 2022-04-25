package scbc.liyongjie.nettywebsocketserverhome.message;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/26
 */


public class BindSuccessMessage {
    private Integer type = 1;
    private String result = "bind success!";

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
