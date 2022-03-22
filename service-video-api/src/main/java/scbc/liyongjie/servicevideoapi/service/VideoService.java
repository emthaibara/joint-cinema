package scbc.liyongjie.servicevideoapi.service;

import org.springframework.stereotype.Service;
import scbc.liyongjie.servicevideoapi.dao.StoreHouseMapper;
import scbc.liyongjie.servicevideoapi.dao.VideoMapper;
import scbc.liyongjie.servicevideoapi.exception.UnRegisteredException;
import scbc.liyongjie.servicevideoapi.po.StoreHouse;
import scbc.liyongjie.servicevideoapi.po.Video;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/17
 */

@Service
public class VideoService {

    @Resource
    private StoreHouseMapper storeHouseMapper;

    @Resource
    private VideoMapper videoMapper;

    public List<Video> getPrivateStoreHouseVideoList(String number) {
        StoreHouse storeHouse = storeHouseMapper.selectByPrimaryKey(number);
        if (Objects.isNull(storeHouse))
            throw new UnRegisteredException();
        String storeHouseUUID = storeHouse.getStorehouse();
        return videoMapper.selectByStoreHouseUUID(storeHouseUUID);
    }




}
