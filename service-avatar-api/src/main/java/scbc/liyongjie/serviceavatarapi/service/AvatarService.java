package scbc.liyongjie.serviceavatarapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import scbc.liyongjie.serviceavatarapi.dao.UserMapper;
import scbc.liyongjie.serviceavatarapi.exception.AvatarTypeException;
import scbc.liyongjie.serviceavatarapi.exception.NotDataException;
import scbc.liyongjie.serviceavatarapi.exception.OverSizeAvatarException;
import scbc.liyongjie.serviceavatarapi.exception.UploadFailException;
import scbc.liyongjie.serviceavatarapi.po.User;
import scbc.liyongjie.serviceavatarapi.util.SuffixCheckUtils;
import scbc.liyongjie.serviceavatarapi.util.UUIDUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/16
 */

@Service
@PropertySource(value = {"classpath:config.properties"},encoding="utf-8")
public class AvatarService {

    private static final Logger log = LoggerFactory.getLogger(AvatarService.class);

    private static final Long MAX_SIZE = 10000000L;

    private static final String DEFAULT_AVATAR = "/resources/img/avatar.svg";

    //上线再使用
    private static final String DOMAIN = "http://www.scbc-liyongjie.top/";

    private static final String ACCESS = "/resources/img/avatar/";

    @Resource
    private UserMapper userMapper;

    @Value("${default.avatar.storePath}")
    private String storePath;

    public String avatar(String number, MultipartFile newAvatar){
        if (newAvatar.getSize() == 0 || Objects.isNull(newAvatar.getOriginalFilename()))
            throw new NotDataException();

        String suffix = newAvatar.getOriginalFilename().substring(newAvatar.getOriginalFilename().lastIndexOf(".") + 1);

        if (!SuffixCheckUtils.check(suffix))
            throw new AvatarTypeException();

        if (MAX_SIZE < newAvatar.getSize())
            throw new OverSizeAvatarException();

        String avatarUUID = UUIDUtils.buildUUID();
        String avatarPath = storePath+avatarUUID+"."+suffix;
        transport(newAvatar,avatarPath);
        User user = userMapper.selectByPrimaryKey(number);
        if (DEFAULT_AVATAR.equals(user.getAvatar())){
            user.setAvatar(avatarPath);
        }else{
            String accessOld = user.getAvatar();
            String oldPath = storePath+accessOld;
            Path old = Paths.get(oldPath);
            try {
                Files.delete(old);
            } catch (IOException e) {
                log.error("旧照片删除 io异常");
            }
        }
        return ACCESS+avatarUUID+"."+suffix;
    }

    private void transport(MultipartFile newAvatar,String avatarPath){
        File avatarFile = new File(avatarPath);
        try {
            newAvatar.transferTo(avatarFile);
        } catch (IOException e) {
            log.error("头像传输失败！");
            throw new UploadFailException();
        }
    }

}
