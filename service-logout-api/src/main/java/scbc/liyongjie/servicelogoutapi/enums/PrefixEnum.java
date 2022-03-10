package scbc.liyongjie.servicelogoutapi.enums;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/5
 */


public enum PrefixEnum {

    TOKEN("token"),
    NUMBER("number");

    private final String prefix;

    PrefixEnum(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
