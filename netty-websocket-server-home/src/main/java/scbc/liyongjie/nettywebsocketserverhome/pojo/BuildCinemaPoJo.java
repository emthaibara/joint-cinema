package scbc.liyongjie.nettywebsocketserverhome.pojo;

import java.util.List;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 *
 */

public class BuildCinemaPoJo {

    private String homeowner_number;   //  房主手机号
    private String homeowner_nickname;
    private String homeowner_avatar;
    private List<String> member;    //  成员----待通知   ，成员手机号
    private String videoUrl;    //视频流url
    private String thumbnail;   //影片缩略图
    private String videoName;   //影片名称

    @Override
    public String toString() {
        return "BuildCinemaPoJo{" +
                "homeowner_number='" + homeowner_number + '\'' +
                ", homeowner_nickname='" + homeowner_nickname + '\'' +
                ", homeowner_avatar='" + homeowner_avatar + '\'' +
                ", member=" + member +
                ", videoUrl='" + videoUrl + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", videoName='" + videoName + '\'' +
                '}';
    }

    public String getHomeowner_avatar() {
        return homeowner_avatar;
    }

    public void setHomeowner_avatar(String homeowner_avatar) {
        this.homeowner_avatar = homeowner_avatar;
    }

    public String getHomeowner_number() {
        return homeowner_number;
    }

    public void setHomeowner_number(String homeowner_number) {
        this.homeowner_number = homeowner_number;
    }

    public String getHomeowner_nickname() {
        return homeowner_nickname;
    }

    public void setHomeowner_nickname(String homeowner_nickname) {
        this.homeowner_nickname = homeowner_nickname;
    }

    public List<String> getMember() {
        return member;
    }

    public void setMember(List<String> member) {
        this.member = member;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }
}
