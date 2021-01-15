package edu.sakura.service;


import edu.sakura.dao.HallDAO;
import edu.sakura.dao.PlanDAO;
import edu.sakura.entity.Hall;
import edu.sakura.entity.Plan;
import edu.sakura.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class PlanServiceImpl implements PlanService{

    @Autowired
    PlanDAO planDAO;

    @Autowired
    HallDAO hallDAO;

    @Override
    public Result<Plan> addPlan(Plan plan) {
        if (Objects.nonNull(plan)) { // 步骤1：获取到用户选择影厅的座位
            // 根据 影厅 ID 和时间去排片表查询，此影厅是否可以排片
            if (planDAO.checkUsable(plan.getHall_id(), plan.getPlaytime()) == 0) {
                // 步骤2：调用 hall_id 查询座位
                Hall hall = hallDAO.findOne(plan.getHall_id());
                if (Objects.nonNull(hall)) {
                    plan.setSeats(hall.getSeats());
                    // 步骤3：存入数据库
                    int n = planDAO.save(plan);
                    if (n > 0)
                        return Result.success("排片成功", plan);
                }
            } else {
                return Result.fail("此时间段已经排片，排片失败");
            }
        }
        return Result.fail("plan 为 null, 排片失败！");
    }

    @Override
    public List<Plan> findPlanListByMovieId(Integer id) {
        return planDAO.findPlanListByMovieId(id);
    }
}
