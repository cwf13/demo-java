package cooc.demo.mapper;

import cooc.demo.model.ZaMallExchangeRec;

public interface ZaMallExchangeRecMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ZaMallExchangeRec record);

    int insertSelective(ZaMallExchangeRec record);

    ZaMallExchangeRec selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ZaMallExchangeRec record);

    int updateByPrimaryKey(ZaMallExchangeRec record);
}