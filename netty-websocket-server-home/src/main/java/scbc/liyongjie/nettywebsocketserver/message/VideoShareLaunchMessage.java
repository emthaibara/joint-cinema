package scbc.liyongjie.nettywebsocketserver.message;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/16
 *
 */

public class VideoShareLaunchMessage {

    private Integer type;
    private String senderNumber;
    private String senderNickName;
    private String senderAvatar;
    private String videoName;
    private String shareVideo;
    private String shareVideoUUID;
    private String receiver;
    private String message;

    public String getSenderAvatar() {
        return senderAvatar;
    }

    public void setSenderAvatar(String senderAvatar) {
        this.senderAvatar = senderAvatar;
    }

    public String getShareVideo() {
        return shareVideo;
    }

    public void setShareVideo(String shareVideo) {
        this.shareVideo = shareVideo;
    }

    public String getShareVideoUUID() {
        return shareVideoUUID;
    }

    public void setShareVideoUUID(String shareVideoUUID) {
        this.shareVideoUUID = shareVideoUUID;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSenderNumber() {
        return senderNumber;
    }

    public void setSenderNumber(String senderNumber) {
        this.senderNumber = senderNumber;
    }

    public String getSenderNickName() {
        return senderNickName;
    }

    public void setSenderNickName(String senderNickName) {
        this.senderNickName = senderNickName;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
