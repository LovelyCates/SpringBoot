package edu.sakura.dao;

import edu.sakura.entity.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PlanDAO extends BaseDAO<Movie, Integer> {
}
