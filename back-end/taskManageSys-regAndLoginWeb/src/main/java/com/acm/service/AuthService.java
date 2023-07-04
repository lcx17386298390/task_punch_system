package com.acm.service;

import com.acm.api.model.Admin;
import com.acm.dataservice.mapper.AdminMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthService implements UserDetailsService {
    @Resource
    AdminMapper adminMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username==null)
            throw new UsernameNotFoundException("用户名不能为空");
        Admin admin=adminMapper.findAuthByName(username);
        if(admin==null)
            throw new UsernameNotFoundException("用户名或密码错误");
        return User
                .withUsername(admin.getUsername())
                .password(admin.getPassword())
                .roles("user")
                .build();
    }
}
