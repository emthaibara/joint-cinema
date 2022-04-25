package scbc.liyongjie.servicessoapi.util;

import com.password4j.Password;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/5
 *          密码校验 ----- PBKDF2
 */


public class PBKDF2Utils {

    public static Boolean check(String pwd,String hash,String salt){
        return Password
                .check(pwd,hash)
                .addPepper()
                .addSalt(salt)
                .withPBKDF2();
    }

}
