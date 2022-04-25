package scbc.liyongjie.servicesignapi.pojo;


import scbc.liyongjie.servicesignapi.validator.annotation.User;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/4
 */

@User
public class UserPoJo {

    private String number;
    private String name;
    private String password;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserPoJo{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
