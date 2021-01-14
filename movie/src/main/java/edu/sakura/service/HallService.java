package edu.sakura.service;

import edu.sakura.entity.Hall;
import edu.sakura.util.Result;
import io.swagger.models.auth.In;

import java.util.List;

public interface HallService {
    // 自己封装过
    Result<Hall> addHall(Hall all);

    // 列表--
    List<Hall> hallList();

    // 参数1：当前页
    // 参数2：每页显示的记录数
    List<Hall> findByPage(Integer pageNum, Integer pageSize);

    // 查询总记录数
    Integer findTotals();

    // 验证影厅
    boolean findName(String name);
}
