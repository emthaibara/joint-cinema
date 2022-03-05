package scbc.liyongjie.servicesignapi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import scbc.liyongjie.servicesignapi.po.NumberPo;

@Repository
public interface NumberPoMapper {
    int deleteByPrimaryKey(String number);

    int insert(NumberPo record);

    NumberPo selectByPrimaryKey(String number);

    List<NumberPo> selectAll();

    int updateByPrimaryKey(NumberPo record);
}