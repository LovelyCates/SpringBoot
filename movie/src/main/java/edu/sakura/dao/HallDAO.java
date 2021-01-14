package edu.sakura.dao;

import edu.sakura.entity.Hall;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface HallDAO  extends BaseDAO<Hall, Integer> {
    Hall findName(String name);
}
