package com.fxz.demo.controller;

import com.fxz.demo.entity.FilmCombo;
import com.fxz.demo.entity.FilmGoods;
import com.fxz.demo.service.FilmService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fuxiaozhi on 2018\7\13 0013.
 */
@RestController
@RequestMapping("filmCombo")
public class FilmController {

    @Resource
    private FilmService filmService;

    @RequestMapping("/filmComboList")
    public List<FilmCombo> filmComboList(){
        return filmService.filmComboList();
    }

    @RequestMapping("/filmGoodsList")
    public List<FilmGoods> filmGoodsList(){
        List<FilmGoods> filmGoods = new ArrayList<>();
        filmGoods = filmService.filmGoodsList();
        return filmGoods;
    }

}
