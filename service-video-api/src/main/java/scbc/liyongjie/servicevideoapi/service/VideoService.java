package scbc.liyongjie.servicevideoapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import scbc.liyongjie.servicevideoapi.dao.ShareVideoMapper;
import scbc.liyongjie.servicevideoapi.dao.StoreHouseMapper;
import scbc.liyongjie.servicevideoapi.dao.VideoMapper;
import scbc.liyongjie.servicevideoapi.exception.UnRegisteredException;
import scbc.liyongjie.servicevideoapi.po.StoreHouse;
import scbc.liyongjie.servicevideoapi.po.Video;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/17
 */

@Service
public class VideoService {
    private static final Logger log = LoggerFactory.getLogger(VideoService.class);

    private static final String ACCESS = "/resources/video/";

    //private static final String LOCAL = "/Users/lemt/Desktop/scbc.liyongjie/scbc.static";

    private static final String LOCAL = "/root";

    @Resource
    private StoreHouseMapper storeHouseMapper;

    @Resource
    private VideoMapper videoMapper;

    @Resource
    private ShareVideoMapper shareVideoMapper;

    public List<Video> getPrivateStoreHouseVideoList(String number) {
        StoreHouse storeHouse = storeHouseMapper.selectByPrimaryKey(number);
        if (Objects.isNull(storeHouse))
            throw new UnRegisteredException();
        String storeHouseUUID = storeHouse.getStorehouse();
        return videoMapper.selectByStoreHouseUUID(storeHouseUUID);
    }

    public void deleteVideo(String number,String videoUUID){
        log.info("user---{}---正在删除视频---{}",number,videoUUID);
        StoreHouse storeHouse = storeHouseMapper.selectByPrimaryKey(number);

        if (Objects.isNull(storeHouse))
            throw new UnRegisteredException();

        Video video = videoMapper.selectByPrimaryKey(videoUUID);
        videoMapper.deleteVideo(storeHouse.getStorehouse(),videoUUID);
        shareVideoMapper.deleteVideo(videoUUID);

        //字符串连接可封装一个utils，这里偷懒了
        String videoPath = LOCAL+ACCESS+storeHouse.getStorehouse()+"/"+video.getMd5()+video.getType();
        String mpdFolder = LOCAL+ACCESS+storeHouse.getStorehouse()+"/"+videoUUID+"/";

        delete(videoPath,mpdFolder);
    }

    private void delete(String videoPath,String mpdFolder){
        Path videoPt = Paths.get(videoPath);
        log.info("mpdFolder:[{}]",mpdFolder);
        Path mpdFolderPath = Paths.get(mpdFolder);
        try {
            if (Files.exists(videoPt))
                Files.delete(videoPt);
            if(Files.exists(mpdFolderPath)){
                Files.list(mpdFolderPath).forEach(path -> {
                    try {
                        Files.delete(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                Files.delete(mpdFolderPath);
            }
        }catch (IOException e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

}
