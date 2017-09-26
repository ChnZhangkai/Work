package com.zk.springboot.service;

import java.util.List;

import com.zk.springboot.pojo.User;
import com.zk.springboot.pojo.UserExample;

public interface UserService {

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 查询所有
     * @param example
     * @return
     */
    List<User> selectByExample(UserExample example);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 修改数据
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);
	
}
