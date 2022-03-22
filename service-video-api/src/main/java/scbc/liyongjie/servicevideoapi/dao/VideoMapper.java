package scbc.liyongjie.servicevideoapi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import scbc.liyongjie.servicevideoapi.po.Video;
@Repository
public interface VideoMapper {

    List<Video> selectByStoreHouseUUID(String storehouse);

    Video selectByPrimaryKey(String uuid);
}