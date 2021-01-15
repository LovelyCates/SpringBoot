package edu.sakura.service;

import edu.sakura.entity.Plan;
import edu.sakura.util.Result;

public interface PlanService {

    public Result<Plan> addPlan(Plan plan);
}
