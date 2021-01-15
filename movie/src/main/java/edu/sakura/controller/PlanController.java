package edu.sakura.controller;


import edu.sakura.entity.Plan;
import edu.sakura.service.PlanService;
import edu.sakura.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plan")
@CrossOrigin  // 允许跨域（前后端分离）
@Slf4j  // 日志对象，替代使用 System.out.println
public class PlanController {

    // 依赖 service 层
    @Autowired
    private PlanService planService;

    @PostMapping("/add")
    public Result<Plan> login(@RequestBody Plan plan){
        log.info("测试页面传递的值：" + plan);
        Result<Plan> result = planService.addPlan(plan);
        log.info("测试返回的数据：" + result);
        return result;
    }
}
