package edu.sakura.service;

import edu.sakura.dao.AdminDAO;
import edu.sakura.entity.Admin;
import edu.sakura.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service  // 业务逻辑层
@Transactional  // 事务管理
public class AdminServiceImpl implements AdminService{

    // 依赖注入
    @Autowired
    AdminDAO adminDAO;

    @Override
    public Result<Admin> login(Admin admin) {
        if(admin == null)
        {
            return Result.fail("登录失败！");
        }
        else{
            Admin loginAdmin = adminDAO.selectAdmin(admin);
            if (loginAdmin != null)
                return  Result.success(loginAdmin);
            else
                return Result.fail("登录失败！");
        }
    }
}
