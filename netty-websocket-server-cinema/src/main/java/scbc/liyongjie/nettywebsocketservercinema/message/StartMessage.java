package scbc.liyongjie.nettywebsocketservercinema.message;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 */

public class StartMessage {

    private String cinemaUUID;

    public String getCinemaUUID() {
        return cinemaUUID;
    }

    public void setCinemaUUID(String cinemaUUID) {
        this.cinemaUUID = cinemaUUID;
    }
}
