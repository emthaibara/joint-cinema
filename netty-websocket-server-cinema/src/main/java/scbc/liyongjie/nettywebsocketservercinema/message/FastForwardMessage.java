package scbc.liyongjie.nettywebsocketservercinema.message;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 */


public class FastForwardMessage {

    private String cinemaUUID;
    private String progress;

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getCinemaUUID() {
        return cinemaUUID;
    }

    public void setCinemaUUID(String cinemaUUID) {
        this.cinemaUUID = cinemaUUID;
    }
}
