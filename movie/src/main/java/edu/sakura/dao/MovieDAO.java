package edu.sakura.dao;

import edu.sakura.entity.Hall;
import edu.sakura.entity.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MovieDAO  extends BaseDAO<Movie, Integer> {

    // 获取可以使用的影厅
    List<Hall> findUsableAll();
}