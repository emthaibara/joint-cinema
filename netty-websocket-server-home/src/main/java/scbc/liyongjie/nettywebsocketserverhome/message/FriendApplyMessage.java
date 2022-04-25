package scbc.liyongjie.nettywebsocketserverhome.message;

import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/15
 */

public class FriendApplyMessage {

    private Integer type;
    private String senderNumber;
    private String senderNickName;
    private String senderAvatar;
    private String receiver;
    private String message;

    @Override
    public String toString() {
        return "FriendApplyMessage{" +
                "type=" + type +
                ", senderNumber='" + senderNumber + '\'' +
                ", senderNickName='" + senderNickName + '\'' +
                ", senderAvatar='" + senderAvatar + '\'' +
                ", receiver='" + receiver + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FriendApplyMessage)) return false;
        FriendApplyMessage that = (FriendApplyMessage) o;
        return Objects.equals(getType(), that.getType()) && Objects.equals(getSenderNumber(), that.getSenderNumber()) && Objects.equals(getSenderNickName(), that.getSenderNickName()) && Objects.equals(getSenderAvatar(), that.getSenderAvatar()) && Objects.equals(getReceiver(), that.getReceiver()) && Objects.equals(getMessage(), that.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getSenderNumber(), getSenderNickName(), getSenderAvatar(), getReceiver(), getMessage());
    }

    public String getSenderAvatar() {
        return senderAvatar;
    }

    public void setSenderAvatar(String senderAvatar) {
        this.senderAvatar = senderAvatar;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSenderNumber() {
        return senderNumber;
    }

    public void setSenderNumber(String senderNumber) {
        this.senderNumber = senderNumber;
    }

    public String getSenderNickName() {
        return senderNickName;
    }

    public void setSenderNickName(String senderNickName) {
        this.senderNickName = senderNickName;
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
