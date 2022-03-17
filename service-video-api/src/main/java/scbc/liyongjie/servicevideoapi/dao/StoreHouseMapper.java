package scbc.liyongjie.servicevideoapi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import scbc.liyongjie.servicevideoapi.po.StoreHouse;
@Repository
public interface StoreHouseMapper {
    int deleteByPrimaryKey(String number);

    int insert(StoreHouse record);

    StoreHouse selectByPrimaryKey(String number);

    List<StoreHouse> selectAll();

    int updateByPrimaryKey(StoreHouse record);
}