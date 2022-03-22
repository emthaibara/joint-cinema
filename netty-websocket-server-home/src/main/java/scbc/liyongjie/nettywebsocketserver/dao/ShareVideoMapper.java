package scbc.liyongjie.nettywebsocketserver.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import scbc.liyongjie.nettywebsocketserver.po.ShareVideo;


@Repository
public interface ShareVideoMapper {

    int deleteByPrimaryKey(@Param("number") String number, @Param("uuid") String uuid, @Param("providerNumber") String providerNumber);

    int insert(ShareVideo record);

    ShareVideo selectByPrimaryKey(@Param("number") String number, @Param("uuid") String uuid, @Param("providerNumber") String providerNumber);

    List<ShareVideo> selectAll();

    List<ShareVideo> selectByNumber(String number);


    int updateByPrimaryKey(ShareVideo record);

}