package edu.sakura.dao;

import edu.sakura.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/*
@Controller  // 控制层
@Service  // 业务层
*/
@Repository
@Mapper
public interface AdminDAO {
    Admin selectAdmin(Admin admin);
}
