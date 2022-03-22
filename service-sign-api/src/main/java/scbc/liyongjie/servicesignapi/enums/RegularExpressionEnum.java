package scbc.liyongjie.servicesignapi.enums;

public enum RegularExpressionEnum {

    PSSWORD_RE("密码至少包含 数字和英文，长度6-20","^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$"),
    NUMBER_RE("手机号格式为0-9的数字组成且长度为","^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$"),
    NICKNAME_RE("昵称可以是2-15位的中文,英文,数字,下划线以及一些常用的标点符号","^[\\d\\w\\u4e00-\\u9fa5,\\.;\\:\"'?!\\-]{2,15}$");

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
