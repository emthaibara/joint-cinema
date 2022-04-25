package scbc.liyongjie.nettywebsocketserverhome.enums;

public enum MessageTypeEnum {

    BIND(1,"初始化连接，申请绑定"),
    FRIEND_APPLY(2,"好友申请消息"),
    SHARE_VIDEO_LAUNCH(3,"共享视频发起"),
    CINEMA_LAUNCH(4,"好友发起的放映室通知");

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
