package scbc.liyongjie.nettywebsocketserver.message;

import java.util.ArrayList;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/25
 */

public class GroupChatMessage extends AbstractMessage{

    /**
     * 发起者
     */
    private String sender;

    /**
     * 接收者
     */
    private ArrayList<String> receivers;

    private String groupName;

    private String message;

    @Override
    public String toString() {
        return "GroupChatMessage{" +
                "token='" + token + '\'' +
                ", sender='" + sender + '\'' +
                ", receivers=" + receivers +
                ", groupName='" + groupName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public ArrayList<String> getReceivers() {
        return receivers;
    }

    public void setReceivers(ArrayList<String> receivers) {
        this.receivers = receivers;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
