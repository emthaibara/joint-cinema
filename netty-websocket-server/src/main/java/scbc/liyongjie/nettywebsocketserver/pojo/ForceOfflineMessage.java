package scbc.liyongjie.nettywebsocketserver.pojo;
/**
 *
 *@Author:SCBC_LiYongJie
 *@time:2022/1/25
 *
*/

public class ForceOfflineMessage extends AbstractMessage{

    /**
     * 发起者
     */
    private String sender;

    /**
     * 接收者
     */
    private String receiver;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

}
