package scbc.liyongjie.nettywebsocketserver.message;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/30
 */
public abstract class AbstractMessage {

    protected String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
