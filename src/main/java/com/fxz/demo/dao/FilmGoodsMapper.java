package com.fxz.demo.dao;

import com.fxz.demo.entity.FilmGoods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmGoodsMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(FilmGoods record);

    int insertSelective(FilmGoods record);

    FilmGoods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(FilmGoods record);

    int updateByPrimaryKey(FilmGoods record);

    List<FilmGoods> filmGoodsList();
}