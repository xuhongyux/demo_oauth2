package com.xiayu.demo.serveice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author xuhongyu
 * @create 2022-04-26 1:45 下午
 */
@Service
public class UserDetailsServiceConfig implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //设置用户密码
        String password = passwordEncoder.encode("123456");
        //创建用户以及权限
        return new User("user",password, AuthorityUtils.commaSeparatedStringToAuthorityList("USER"));
    }
}
