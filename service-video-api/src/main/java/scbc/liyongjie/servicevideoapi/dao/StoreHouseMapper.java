package scbc.liyongjie.servicevideoapi.dao;


import org.springframework.stereotype.Repository;
import scbc.liyongjie.servicevideoapi.po.StoreHouse;
@Repository
public interface StoreHouseMapper {

    StoreHouse selectByPrimaryKey(String number);

}