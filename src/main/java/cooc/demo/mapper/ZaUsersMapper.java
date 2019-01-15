package cooc.demo.mapper;

import cooc.demo.model.ZaUsers;

import java.util.List;
import java.util.Map;

public interface ZaUsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ZaUsers record);

    int insertSelective(ZaUsers record);

    ZaUsers selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ZaUsers record);

    int updateByPrimaryKey(ZaUsers record);

    ZaUsers queryByLogins(Map map);

    List<Map<String,String>> getUserList();
}