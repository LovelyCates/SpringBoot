package edu.sakura.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
// T 实体类   K 主键字段的数据类型  String Integer
public interface BaseDAO<T, K> {

    int save(T t); //添加

    int update(T t); //修改

    int delete(K k); //根据主键删除

    T findOne(K k); //根据主键查询单个信息

    List<T> findAll(); //查询所有

    // 分页查询
    List<T> findByPage(@Param("start") Integer start,
                       @Param("rows") Integer rows);

    //表中对应的总记录条数
    Integer findTotals();
}
