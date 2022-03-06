package scbc.liyongjie.servicessoapi.pojo;

import scbc.liyongjie.servicessoapi.Validator.annotation.User;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/5
 */

@User
public class UserPoJo {

    private String number;
    private String password;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
