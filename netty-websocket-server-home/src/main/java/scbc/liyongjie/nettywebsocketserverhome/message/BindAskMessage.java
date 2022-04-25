package scbc.liyongjie.nettywebsocketserverhome.message;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/25
 */

public class BindAskMessage{

    private String number;

    @Override
    public String toString() {
        return "BindAskMessage{" +
                "number='" + number + '\'' +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
