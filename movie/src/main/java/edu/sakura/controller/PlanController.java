package edu.sakura.controller;


import edu.sakura.entity.Plan;
import edu.sakura.service.PlanService;
import edu.sakura.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "排片相关模块")
@RestController
@RequestMapping("/plan")
@CrossOrigin  // 允许跨域（前后端分离）
@Slf4j  // 日志对象，替代使用 System.out.println
public class PlanController {

    // 依赖 service 层
    @Autowired
    private PlanService planService;

    @ApiOperation("根据电影ID查询此电影的排片信息列表")
    @GetMapping("/findPlanListByMovieId")
    @ApiImplicitParam(name="id", value = "电影ID", defaultValue = "1", dataType = "Integer")
    public List<Plan> findPlanListByMovieId(Integer id){
        log.info("--findPlanListByMovieid--" + id);
        return planService.findPlanListByMovieId(id);
    }

    @ApiOperation("添加排片")
    @PostMapping("/add")
    public Result<Plan> add(@RequestBody Plan plan){
        log.info("测试页面传递的值：" + plan);
        Result<Plan> result = planService.addPlan(plan);
        log.info("测试返回的数据：" + result);
        return result;
    }
}
