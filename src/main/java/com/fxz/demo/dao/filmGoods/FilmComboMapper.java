package com.fxz.demo.dao.filmGoods;

import com.fxz.demo.entity.FilmCombo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fuxiaozhi on 2018\7\13 0013.
 */

@Repository
public interface FilmComboMapper {

    @Select("select * from h_film_combo")
    List<FilmCombo> filmComboList();

}
