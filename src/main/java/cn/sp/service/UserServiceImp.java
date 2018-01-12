package cn.sp.service;

import cn.sp.constant.RoleConstants;
import cn.sp.dao.UserDao;
import cn.sp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 2YSP
 * @Description:
 * @Date: Created in 2018/1/12
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean insert(User user) {
        if (user == null){
            return false;
        }

        if (queryByUserName(user.getUserName()) != null){
            //已存在
            return false;
        }
        user.setRoles(RoleConstants.ROLE_USER);
        return userDao.insert(user) > 0;
    }

    @Override
    public User queryByUserName(String userName) {
        return userDao.queryByUserName(userName);
    }
}
