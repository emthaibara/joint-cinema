package scbc.liyongjie.servicevideoapi.pojo;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/16
 */


public class ShareVideoPoJo {

    private String url;
    private String thumbnail;
    private String provider_number;
    private String provider_nickname;
    private String provider_avatar;
    private String name;
    private String size;
    private String uuid;
    private String duration;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getProvider_number() {
        return provider_number;
    }

    public void setProvider_number(String provider_number) {
        this.provider_number = provider_number;
    }

    public String getProvider_nickname() {
        return provider_nickname;
    }

    public void setProvider_nickname(String provider_nickname) {
        this.provider_nickname = provider_nickname;
    }

    public String getProvider_avatar() {
        return provider_avatar;
    }

    public void setProvider_avatar(String provider_avatar) {
        this.provider_avatar = provider_avatar;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
