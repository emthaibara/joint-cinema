package scbc.liyongjie.nettywebsocketserverhome.message;

import java.util.Objects;

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
    private String videoThumbnail;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VideoShareLaunchMessage)) return false;
        VideoShareLaunchMessage that = (VideoShareLaunchMessage) o;
        return Objects.equals(getType(), that.getType()) && Objects.equals(getSenderNumber(), that.getSenderNumber()) && Objects.equals(getSenderNickName(), that.getSenderNickName()) && Objects.equals(getSenderAvatar(), that.getSenderAvatar()) && Objects.equals(getVideoName(), that.getVideoName()) && Objects.equals(getShareVideo(), that.getShareVideo()) && Objects.equals(getShareVideoUUID(), that.getShareVideoUUID()) && Objects.equals(getReceiver(), that.getReceiver()) && Objects.equals(getMessage(), that.getMessage()) && Objects.equals(getVideoThumbnail(), that.getVideoThumbnail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getSenderNumber(), getSenderNickName(), getSenderAvatar(), getVideoName(), getShareVideo(), getShareVideoUUID(), getReceiver(), getMessage(), getVideoThumbnail());
    }

    @Override
    public String toString() {
        return "VideoShareLaunchMessage{" +
                "type=" + type +
                ", senderNumber='" + senderNumber + '\'' +
                ", senderNickName='" + senderNickName + '\'' +
                ", senderAvatar='" + senderAvatar + '\'' +
                ", videoName='" + videoName + '\'' +
                ", shareVideo='" + shareVideo + '\'' +
                ", shareVideoUUID='" + shareVideoUUID + '\'' +
                ", receiver='" + receiver + '\'' +
                ", message='" + message + '\'' +
                ", videoThumbnail='" + videoThumbnail + '\'' +
                '}';
    }

    public String getVideoThumbnail() {
        return videoThumbnail;
    }

    public void setVideoThumbnail(String videoThumbnail) {
        this.videoThumbnail = videoThumbnail;
    }

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
