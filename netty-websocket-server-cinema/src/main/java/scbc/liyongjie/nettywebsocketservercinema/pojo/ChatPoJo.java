package scbc.liyongjie.nettywebsocketservercinema.pojo;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 */

public class ChatPoJo {

    private String senderAvatar;
    private String senderName;
    private String message;

    public String getSenderAvatar() {
        return senderAvatar;
    }

    public void setSenderAvatar(String senderAvatar) {
        this.senderAvatar = senderAvatar;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
