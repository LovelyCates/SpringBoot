package edu.sakura.service;

import edu.sakura.entity.Plan;
import edu.sakura.util.Result;

import java.util.List;

public interface PlanService {

    Result<Plan> addPlan(Plan plan);

    // 根据电影ID查询排片列表
    List<Plan> findPlanListByMovieId(Integer id);
}
