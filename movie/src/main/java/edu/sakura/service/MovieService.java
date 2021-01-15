package edu.sakura.service;

import edu.sakura.entity.Hall;
import edu.sakura.entity.Movie;
import edu.sakura.util.Result;

import java.util.List;

public interface MovieService {
    // 自己封装过
    Result<Movie> addMovie(Movie movie);

    List<Movie> findByPage(Integer pageNum, Integer pageSize);

    Integer findTotals();

    // 查询所有的电影信息
    List<Movie> findAllMovie();

    // 获取可以使用的影厅
    List<Hall> findUsableHall();

    // 根据电影ID查询电影信息
    Movie findOne(Integer id);
}
