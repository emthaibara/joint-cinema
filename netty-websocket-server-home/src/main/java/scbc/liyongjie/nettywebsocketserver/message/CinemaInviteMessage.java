package scbc.liyongjie.nettywebsocketserver.message;


/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 */

public class CinemaInviteMessage {

    private String cinemaUUID;
    private String sender_nickname;
    private String sender_avatar;

    public String getSender_avatar() {
        return sender_avatar;
    }

    public void setSender_avatar(String sender_avatar) {
        this.sender_avatar = sender_avatar;
    }

    public String getCinemaUUID() {
        return cinemaUUID;
    }

    public void setCinemaUUID(String cinemaUUID) {
        this.cinemaUUID = cinemaUUID;
    }

    public String getSender_nickname() {
        return sender_nickname;
    }

    public void setSender_nickname(String sender_nickname) {
        this.sender_nickname = sender_nickname;
    }
}
