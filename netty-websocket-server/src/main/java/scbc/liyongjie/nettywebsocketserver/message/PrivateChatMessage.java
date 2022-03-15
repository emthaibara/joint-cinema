package scbc.liyongjie.nettywebsocketserver.message;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/25
 */

public class PrivateChatMessage extends AbstractMessage{

    /**
     * 发起者
     */
    private String sender;

    /**
     * 接收者
     */
    private String receiver;

    private String message;

    @Override
    public String toString() {
        return "PrivateChatMessage{" +
                "token='" + token + '\'' +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
