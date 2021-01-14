package edu.sakura.service;

import edu.sakura.entity.Admin;
import edu.sakura.util.Result;

import java.util.List;

public interface AdminService {

     // 后台登录管理员的方法
     Result<Admin> login(Admin admin);
}
