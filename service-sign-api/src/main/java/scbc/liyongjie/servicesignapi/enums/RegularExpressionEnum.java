package scbc.liyongjie.servicesignapi.enums;

public enum RegularExpressionEnum {

    PSSWORD_RE("密码至少包含 数字和英文，长度6-20","^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$"),
    NUMBER_RE("手机号格式为0-9的数字组成且长度为","^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$"),
    NICKNAME_RE("昵称为字母开头，允许5-16字节，允许字母数字下划线","a^[a-zA-Z][-zA-Z0-9_]{4,15}$");

    private final String effect;
    private final String regularExpression;

    RegularExpressionEnum(String effect, String regularExpression) {
        this.effect = effect;
        this.regularExpression = regularExpression;
    }

    public String getEffect() {
        return effect;
    }

    public String getRegularExpression() {
        return regularExpression;
    }

}
