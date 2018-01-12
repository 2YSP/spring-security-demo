package cn.sp.service;

import cn.sp.entity.User;

/**
 * @Author: 2YSP
 * @Description:
 * @Date: Created in 2018/1/12
 */
public interface UserService {
    /**
     * 添加新用户
     * username 唯一， 默认 USER 权限
     * @param user
     * @return
     */
    boolean insert(User user);

    /**
     * 查询用户信息
     * @param userName
     * @return
     */
    User queryByUserName(String userName);
}
