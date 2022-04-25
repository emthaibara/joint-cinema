package scbc.liyongjie.nettywebsocketserverhome.enums;

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
