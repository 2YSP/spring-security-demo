package cn.sp.config;

import cn.sp.entity.User;
import cn.sp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 2YSP
 * @Description:
 * @Date: Created in 2018/1/12
 */
@Service
public class AnyUserDetailsService implements UserDetailsService{

    private final UserService userService;

    @Autowired
    AnyUserDetailsService(UserService userService){
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.queryByUserName(userName);
        if(user == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        List<SimpleGrantedAuthority> authorities = createAuthorities(user.getRoles());

        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),authorities);
    }

    /**
     * 权限字符串转换
     * 如 "USER,ADMIN" -> SimpleGrantedAuthority("USER") + SimpleGrantedAuthority("ADMIN")
     * @param roleStr
     * @return
     */
    private List<SimpleGrantedAuthority> createAuthorities(String roleStr){
        String[] roles = roleStr.split(",");
        List<SimpleGrantedAuthority> simpleGrantedAuthorityList = new ArrayList<>();
        for (String role : roles){
            simpleGrantedAuthorityList.add(new SimpleGrantedAuthority(role));
        }

        return simpleGrantedAuthorityList;
    }
}
