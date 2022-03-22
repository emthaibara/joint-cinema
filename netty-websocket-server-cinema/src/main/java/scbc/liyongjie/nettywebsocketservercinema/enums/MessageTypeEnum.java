package scbc.liyongjie.nettywebsocketservercinema.enums;

public enum MessageTypeEnum {

    BIND(1,"初始化连接，申请绑定"),
    START(2,"开始"),
    PAUSE(3,"暂停"),
    FAST_FORWARD(4,"快进"),
    CHAT(5,"实时聊天");

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
