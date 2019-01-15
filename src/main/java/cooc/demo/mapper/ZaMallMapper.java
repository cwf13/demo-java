package cooc.demo.mapper;

import cooc.demo.model.ZaMall;

import java.util.List;
import java.util.Map;

public interface ZaMallMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ZaMall record);

    int insertSelective(ZaMall record);

    ZaMall selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ZaMall record);

    int updateByPrimaryKey(ZaMall record);

    List<Map<String, String>> selectZaMallByMap(Map<String, Object> map);
}