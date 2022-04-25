package cn.scbc.servicevideouploadapi.dao;

import cn.scbc.servicevideouploadapi.po.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Video record);

    Video selectByPrimaryKey(String uuid);

    List<Video> selectAll();

    List<Video> selectByMd5(String storehouse,String md5);

    int updateByPrimaryKey(Video record);
}