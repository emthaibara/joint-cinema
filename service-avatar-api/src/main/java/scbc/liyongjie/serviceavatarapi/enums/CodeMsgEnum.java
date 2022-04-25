package scbc.liyongjie.serviceavatarapi.enums;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/30
 */


public enum CodeMsgEnum {

    AVATAR_TYPE_VIOLATION(2001,"请选择图片类型"),
    NOT_DATA(2002,"头像数据为空"),
    OVER_SIZE(2003,"头像大小超过10mb，请选择合适大小的头像"),
    UN_REGISTER(2004,"您尚未注册账号，请先注册后操作"),
    UPLOAD_FAIL(2005,"服务器上传时异常中断，请重新上传"),
    ;

    private final Integer status;
    private final String codeMsg;

    CodeMsgEnum(Integer status, String codeMsg) {
        this.status = status;
        this.codeMsg = codeMsg;
    }

    public Integer getStatus() {
        return status;
    }

    public String getCodeMsg() {
        return codeMsg;
    }

}
