package scbc.liyongjie.nettywebsocketserverhome.message;


/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 */

public class CinemaApplyMessage {

    private Integer type;
    private String sender_nickname;
    private String sender_avatar;
    private String videoName;
    private String videoThumbnail;

    @Override
    public String toString() {
        return "CinemaApplyMessage{" +
                "type=" + type +
                ", sender_nickname='" + sender_nickname + '\'' +
                ", sender_avatar='" + sender_avatar + '\'' +
                ", videoName='" + videoName + '\'' +
                ", videoThumbnail='" + videoThumbnail + '\'' +
                '}';
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSender_nickname() {
        return sender_nickname;
    }

    public void setSender_nickname(String sender_nickname) {
        this.sender_nickname = sender_nickname;
    }

    public String getSender_avatar() {
        return sender_avatar;
    }

    public void setSender_avatar(String sender_avatar) {
        this.sender_avatar = sender_avatar;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoThumbnail() {
        return videoThumbnail;
    }

    public void setVideoThumbnail(String videoThumbnail) {
        this.videoThumbnail = videoThumbnail;
    }
}
