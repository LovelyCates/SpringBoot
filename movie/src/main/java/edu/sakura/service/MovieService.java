package edu.sakura.service;

import edu.sakura.entity.Movie;
import edu.sakura.entity.MovieVO;
import edu.sakura.util.Result;

import java.util.List;

public interface MovieService {
    // 自己封装过
    Result<Movie> addMovie(Movie movie);

    List<Movie> findByPage(Integer pageNum, Integer pageSize);

    Integer findTotals();

    List<MovieVO> findAllMovie();
}
