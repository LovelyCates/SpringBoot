package edu.sakura.service;

import edu.sakura.dao.HallDAO;
import edu.sakura.entity.Hall;
import edu.sakura.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class HallServiceImpl implements HallService{

    @Autowired
    HallDAO hallDAO;

    @Override
    public Result<Hall> addHall(Hall hall) {
        if (Objects.nonNull(hall)){
            int n = hallDAO.save(hall);
            return Result.success("添加成功", hall);
        }
        return Result.fail("添加失败");
    }

    @Override
    public List<Hall> hallList() {
        List<Hall> hallList = hallDAO.findAll();
        return hallList;
    }

    @Override
    public List<Hall> findByPage(Integer pageNum, Integer pageSize) {
        // pageNum
        int start = (pageNum - 1) * pageSize;
        int rows = pageSize;
        return hallDAO.findByPage(start, rows);
    }

    @Override
    public Integer findTotals() {
        return hallDAO.findTotals();
    }

    @Override
    public boolean findName(String name) {
        return Objects.nonNull(hallDAO.findName(name));
    }


}
