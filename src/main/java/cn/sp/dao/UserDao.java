package cn.sp.dao;

import cn.sp.entity.User;

/**
 * @Author: 2YSP
 * @Description:
 * @Date: Created in 2018/1/12
 */
public interface UserDao {

    int insert(User user);

    User queryByUserName(String userName);
}
