package scbc.liyongjie.servicevideoapi.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import scbc.liyongjie.servicevideoapi.po.ShareVideo;

import java.util.List;


@Repository
public interface ShareVideoMapper {

    int insert(ShareVideo record);

    ShareVideo selectByPrimaryKey(@Param("number") String number, @Param("uuid") String uuid, @Param("providerNumber") String providerNumber);

    List<ShareVideo> selectByNumber(String number);

    void deleteVideo(String uuid);

    void deleteByPrimaryKey(@Param("number") String number, @Param("uuid") String uuid, @Param("providerNumber") String providerNumber);
}