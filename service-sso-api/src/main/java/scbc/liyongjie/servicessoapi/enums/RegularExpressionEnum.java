package scbc.liyongjie.servicessoapi.enums;

public enum RegularExpressionEnum {

    NUMBER_RE("手机号格式为0-9的数字组成且长度为","^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$");

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
