package scbc.liyongjie.serviceavatarapi.pojo;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/24
 */


public class SetAvatarPoJo {
    private MultipartFile avatar;
    private String number;

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
