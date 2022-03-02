package cn.scbc.servicevideouploadapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/2/18
 *
 */
@Service
public class SecondPassService {

    private final Logger logger = LoggerFactory.getLogger(SecondPassService.class);

    public void doSecondPass(){

    }

    public Boolean isSecondPass(String md5){

        return folderSelect(md5);
    }

    private Boolean redisSelect(String md5){

        return Boolean.FALSE;
    }

    private Boolean folderSelect(String md5){

        return Boolean.FALSE;
    }

}
