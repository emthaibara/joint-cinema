package scbc.liyongjie.nettywebsocketservercinema.message;


/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 *
 */

public class ChatMessage {

    private String senderNumber;
    private String senderAvatar;
    private String senderName;
    private String message;
    private String cinemaUUID;

    public String getSenderNumber() {
        return senderNumber;
    }

    public void setSenderNumber(String senderNumber) {
        this.senderNumber = senderNumber;
    }

    public String getCinemaUUID() {
        return cinemaUUID;
    }

    public void setCinemaUUID(String cinemaUUID) {
        this.cinemaUUID = cinemaUUID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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

}
