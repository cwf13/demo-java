package cooc.demo.mapper;

import cooc.demo.model.ZaVersion;

import java.util.Map;

public interface ZaVersionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ZaVersion record);

    int insertSelective(ZaVersion record);

    ZaVersion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ZaVersion record);

    int updateByPrimaryKey(ZaVersion record);

    Map<String, String> selectZaVersionByPlatform(String platform);
}