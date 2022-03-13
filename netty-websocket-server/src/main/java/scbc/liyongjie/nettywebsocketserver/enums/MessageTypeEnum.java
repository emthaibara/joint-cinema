package scbc.liyongjie.nettywebsocketserver.enums;

public enum MessageTypeEnum {

    BIND(1,"初始化连接，申请绑定"),
    FORCE_OFFLINE(5,"异地登陆，您已被挤下线"),
    PRIVATE_CHAT(2,"单聊消息"),
    GROUP_CHAT(3,"群发消息"),
    FRIEND_REQUEST(4,"好友申请");

    private final String content;
    private final Integer type;

    MessageTypeEnum(Integer type, String content) {
        this.type = type;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Integer getType() {
        return type;
    }
}
