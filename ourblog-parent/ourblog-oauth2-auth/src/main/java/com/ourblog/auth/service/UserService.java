package com.ourblog.auth.service;

import cn.hutool.core.collection.CollUtil;
import com.ourblog.auth.domain.SecurityUser;
import com.ourblog.common.dto.auth.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户管理业务类
 * Created by macro on 2020/6/19.
 */
@Service
public class UserService implements UserDetailsService {

    private List<UserDto> userList;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // todo: 查询权限表
    @PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("123456");
        userList = new ArrayList<>();
        userList.add(new UserDto(1L,"test1", password,1, CollUtil.toList("ADMIN")));
        userList.add(new UserDto(2L,"test2", password,1, CollUtil.toList("ADMIN")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDto> findUserList = userList.stream().filter(item -> item.getUsername().equals(username)).collect(Collectors.toList());
        SecurityUser securityUser = new SecurityUser(findUserList.get(0));
        return securityUser;
    }

}
