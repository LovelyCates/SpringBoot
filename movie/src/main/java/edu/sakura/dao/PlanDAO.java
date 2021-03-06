package edu.sakura.dao;

import edu.sakura.entity.Plan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface PlanDAO extends BaseDAO<Plan, Integer> {
    Integer checkUsable(@Param("hid") Integer hall_id, @Param("t") Date playtime);

    List<Plan> findPlanListByMovieId(@Param("mid") Integer id);
}
