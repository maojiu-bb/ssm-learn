package com.dao;

import com.pojo.Worker;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface WorkerMapper {
    @SuppressWarnings("all")
    @Select("select * from t_worker where id = #{id}")
    Worker selectWorker(int id);

    @SuppressWarnings("all")
    @Update("update t_worker set name = #{name}, age = #{age}, position = #{position} where id = #{id}")
    void updateWorker(Worker worker);

    @SuppressWarnings("all")
    @Delete("delete from t_worker where id = #{id}")
    void deleteWorker(int id);

    @SuppressWarnings("all")
    @Insert("insert into t_worker (name, age, position) values (#{name}, #{age}, #{position})")
    void insertWorker(Worker worker);
}
