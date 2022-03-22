package scbc.liyongjie.servicessoapi.pojo;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 */


public class UserPoJo {

    private String number;
    private String avatar;
    private String nickname;
    private String storehouseUUID;

    public String getStorehouseUUID() {
        return storehouseUUID;
    }

    public void setStorehouseUUID(String storehouseUUID) {
        this.storehouseUUID = storehouseUUID;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
