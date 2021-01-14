package edu.sakura.controller;


import edu.sakura.service.PlanService;
import edu.sakura.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "排片相关模块")
@RestController  //  @Controller + @ResponseBody 后台代码  --------- Json格式数据 --------> 前台代码
// @RequestBody  前台页面 ----------- json格式的数据  -> 后台
@RequestMapping("/plan")
@CrossOrigin  // 允许跨域（前后端分离）
@Slf4j  // 日志对象，替代使用 System.out.println
public class PlanController {

    @Autowired
    PlanService planService;

    @PostMapping("/add")
    @ApiOperation("添加排片")
    public Result AddPlan(){

        return Result.success("添加成功");
    }
}
