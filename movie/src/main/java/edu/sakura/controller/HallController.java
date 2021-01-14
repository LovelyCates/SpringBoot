package edu.sakura.controller;


import edu.sakura.entity.Hall;
import edu.sakura.service.HallService;
import edu.sakura.util.Result;
import io.swagger.annotations.*;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Api(tags = "影厅相关模块")
@RestController  //  @Controller + @ResponseBody 后台代码  --------- Json格式数据 --------> 前台代码
// @RequestBody  前台页面 ----------- json格式的数据  -> 后台
@RequestMapping("/hall")
@CrossOrigin  // 允许跨域（前后端分离）
@Slf4j  // 日志对象，替代使用 System.out.println
public class HallController {
    // 依赖 service 层
    @Autowired
    private HallService hallService;

    @ApiOperation(value = "添加影厅", notes = "")
    //@ApiImplicitParams({
           // @ApiImplicitParam(name = "name", value = "影厅名称", required = true, paramType = "form"),
           // @ApiImplicitParam(name = "seats", value = "影厅座位", required = true, paramType = "form"),
           // @ApiImplicitParam(name = "status", value = "影厅状态", required = true, paramType = "form")
    //})
    @ApiImplicitParam(name = "hall")
    @PostMapping("/add")
    public Result<Hall> addHall(@ModelAttribute Hall hall){
        log.info("测试页面传递的值：" + hall);
        Result<Hall> result = hallService.addHall(hall);
        log.info("测试返回的数据：" + result);
        return result;
    }

    @ApiOperation(value = "查询所有影厅", notes = "")
    @GetMapping("/findAll")
    public List<Hall> findAll(){
        log.info("-------hallController-----------");
        List<Hall> hallList = hallService.hallList();
        return hallList;
    }

    @ApiOperation(value = "分页查询影厅")
    @GetMapping("/findByPage")
    @ApiImplicitParams({
     @ApiImplicitParam(name="pageNum", value = "当前页", dataType = "int", required = true, defaultValue = "1"),
     @ApiImplicitParam(name = "pageSize", value = "页面数据数", dataType = "int", required = true, defaultValue = "2")
    })
    public Map<String, Object> findByPage(@RequestParam  Integer pageNum, @RequestParam  Integer pageSize){
        HashMap<String, Object> map = new HashMap<>();
        // 检测页面传递的值是否获取到了
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 2 : pageSize;
        log.info("pageNum=" + pageNum +",pageSize=" + pageSize);
        // 调用 Service中方法
        List<Hall> hallList = hallService.findByPage(pageNum, pageSize);
        // 计算总数
        Integer totals = hallService.findTotals();
        // 计算总页数  totals = 5 pageSize = 2, 整除 或 不整除
        Integer totalPage = totals % pageSize == 0 ? totals / pageSize : totals / pageSize + 1;
        map.put("hallList", hallList);  // 数据
        map.put("totals", totals);  // 总记录数
        map.put("totalPage", totalPage);  // 总页数
        map.put("pageNum", pageNum);  // 当前页码
        return map;
    }

    @ApiOperation(value = "查询影厅数", notes = "")
    @GetMapping("/findTotals")
    public Integer findTotals(){
        Integer nums = hallService.findTotals();
        log.info("总记录数：" + nums);
        return nums;
    }

    @ApiOperation(value = "检测名字是否可用")
    @GetMapping("/checkName")
    @ApiImplicitParam(name="name", value = "影厅名", dataType = "String",  required = true)
    public Boolean checkName(@RequestParam  String name){
        if (Objects.nonNull(name)){
            log.info("name = " + name);
            boolean flag = hallService.findName(name);
            log.info("flag  =" + flag);
            return  flag;
        }
        return false;
    }
}
