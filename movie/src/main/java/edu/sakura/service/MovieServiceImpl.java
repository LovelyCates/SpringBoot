package edu.sakura.service;

import edu.sakura.dao.MovieDAO;
import edu.sakura.entity.Hall;
import edu.sakura.entity.Movie;
import edu.sakura.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class MovieServiceImpl implements MovieService{
    @Autowired
    MovieDAO movieDAO;

    @Override
    public Result<Movie> addMovie(Movie movie) {
        if (Objects.nonNull(movie)){
            int n = movieDAO.save(movie);
            return Result.success("添加成功", movie);
        }
        return Result.fail("添加失败");
    }

    @Override
    public List<Movie> findByPage(Integer pageNum, Integer pageSize) {
        // pageNum 当前页面，pageSize 每页显示记录数
        int start = (pageNum - 1) * pageSize;
        int rows = pageSize;
        return movieDAO.findByPage(start, rows);
    }

    @Override
    public Integer findTotals() {
        return movieDAO.findTotals();
    }

    @Override
    public List<Movie> findAllMovie() {
        return movieDAO.findAll();
    }

    @Override
    public List<Hall> findUsableHall() {
        return movieDAO.findUsableAll();
    }

    @Override
    public Movie findOne(Integer id) {
        return movieDAO.findOne(id);
    }
}
