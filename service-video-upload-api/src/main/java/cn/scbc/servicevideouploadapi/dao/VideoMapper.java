package cn.scbc.servicevideouploadapi.dao;

import cn.scbc.servicevideouploadapi.po.Video;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VideoMapper {

    int insert(Video record);

    List<String> selectByMd5(String md5);

}