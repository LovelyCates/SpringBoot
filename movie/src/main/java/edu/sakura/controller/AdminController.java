package edu.sakura.controller;

import edu.sakura.entity.Admin;
import edu.sakura.service.AdminService;
import edu.sakura.util.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "管理员相关模块")
@RestController
@RequestMapping("/admin")
@CrossOrigin  // 允许跨域（前后端分离）
@Slf4j  // 日志对象，替代使用 System.out.println
public class AdminController {

    // 依赖 service 层
    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Result<Admin> login(@RequestBody Admin admin){
       log.info("测试页面传递的值：" + admin);
       Result<Admin> result = adminService.login(admin);
       log.info("测试返回的数据：" + result);
       return result;
    }
}
