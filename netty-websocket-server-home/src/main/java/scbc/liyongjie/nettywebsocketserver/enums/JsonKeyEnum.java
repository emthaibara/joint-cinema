package scbc.liyongjie.nettywebsocketserver.enums;

public enum JsonKeyEnum {

    TYPE("type"),
    DATA("data");

    private final String key;

    JsonKeyEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
