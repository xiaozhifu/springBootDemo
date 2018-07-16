package com.fxz.demo.service;

import com.fxz.demo.dao.FilmComboMapper;
import com.fxz.demo.dao.FilmGoodsMapper;
import com.fxz.demo.entity.FilmCombo;
import com.fxz.demo.entity.FilmGoods;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by fuxiaozhi on 2018\7\16 0016.
 */
@Service
public class FilmService {

    @Resource
    private FilmComboMapper filmComboMapper;
    @Resource
    private FilmGoodsMapper filmGoodsMapper;

    public List<FilmCombo> filmComboList() {
        return filmComboMapper.filmComboList();
    }

    public List<FilmGoods> filmGoodsList() {
        return filmGoodsMapper.filmGoodsList();
    }

}
