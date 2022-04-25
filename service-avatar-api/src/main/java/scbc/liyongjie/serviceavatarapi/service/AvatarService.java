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

    private static final String DEFAULT_AVATAR = "/resources/avatar/avatar.png";

    private static final String ACCESS = "/resources/avatar/";

    @Resource
    private UserMapper userMapper;

    @Value("${default.avatar.storePath}")
    private String local;

    public String avatar(String number, MultipartFile newAvatar){
        log.info("user---{}---正在校验待上传的头像...",number);
        if (newAvatar.getSize() == 0 || Objects.isNull(newAvatar.getOriginalFilename()))
            throw new NotDataException();

        String suffix = newAvatar.getOriginalFilename().substring(newAvatar.getOriginalFilename().lastIndexOf(".") + 1);

        if (!SuffixCheckUtils.check(suffix))
            throw new AvatarTypeException();

        if (MAX_SIZE < newAvatar.getSize())
            throw new OverSizeAvatarException();

        log.info("user---{}---校验完成!----success!",number);

        String avatarUUID = UUIDUtils.buildUUID();
        String avatarPath = local+ACCESS+avatarUUID+"."+suffix;

        log.info("user--{}----头像传输中...-----传输地址----{}",number,avatarPath);
        transport(newAvatar,avatarPath);
        log.info("user--{}----头像传输成功",number);

        User user = userMapper.selectByPrimaryKey(number);
        if (!DEFAULT_AVATAR.equals(user.getAvatar())){
            String accessOld = user.getAvatar();
            String oldPath = local+accessOld;
            Path old = Paths.get(oldPath);
            try {
                Files.delete(old);
            } catch (IOException e) {
                log.error("旧照片删除 io异常");
            }
        }
        String accessPath = ACCESS+avatarUUID+"."+suffix;
        user.setAvatar(accessPath);
        userMapper.updateByPrimaryKey(user);
        log.info("user--{}----更新了头像",number);
        return accessPath;
    }

    private void transport(MultipartFile newAvatar,String avatarPath){
        log.info("构建传输img文件中...-----transferTo---path---{}",avatarPath);
        Path avatarFile = Paths.get(avatarPath);
        try {

            if(!Files.exists(avatarFile))
                 Files.createFile(avatarFile);
            log.info("creat success！...-----transferTo---path---{}",avatarPath);

            log.info("transferTo...");
            newAvatar.transferTo(avatarFile);
        } catch (IOException e) {
            log.error(e.getMessage());
            log.error("transferTo fail！");
            throw new UploadFailException();
        }
    }

}
