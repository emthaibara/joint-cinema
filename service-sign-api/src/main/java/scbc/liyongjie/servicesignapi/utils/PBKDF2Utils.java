package scbc.liyongjie.servicesignapi.utils;


import com.password4j.Hash;
import com.password4j.Password;


/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/4
 */

public class PBKDF2Utils {
    public static Hash PBKDF2(String password){
        return Password
                .hash(password)
                .addRandomSalt()
                .addPepper()
                .withPBKDF2();
    }
}
