package scbc.liyongjie.servicessoapi.enums;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/5
 */


public enum PrefixEnum {

    TOKEN("token"),
    NUMBER("number"),
    UUID("uuid");
    private final String prefix;

    PrefixEnum(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
