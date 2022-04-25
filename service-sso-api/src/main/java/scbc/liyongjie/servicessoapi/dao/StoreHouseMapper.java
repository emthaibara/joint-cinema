package scbc.liyongjie.servicessoapi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import scbc.liyongjie.servicessoapi.po.StoreHouse;
@Repository
public interface StoreHouseMapper {
    int deleteByPrimaryKey(String number);

    int insert(StoreHouse record);

    StoreHouse selectByPrimaryKey(String number);

    List<StoreHouse> selectAll();

    int updateByPrimaryKey(StoreHouse record);
}