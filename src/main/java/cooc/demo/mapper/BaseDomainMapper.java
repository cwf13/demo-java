package cooc.demo.mapper;

import cooc.demo.model.BaseDomain;

import java.util.Map;

public interface BaseDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseDomain record);

    int insertSelective(BaseDomain record);

    BaseDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseDomain record);

    int updateByPrimaryKey(BaseDomain record);

    Map<String, String> selectBaseDomainByDomain(String domain);
}