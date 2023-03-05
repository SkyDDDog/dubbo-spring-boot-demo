package com.west2.dubbo.springboot.demo.provider.service.db;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.west2.dubbo.springboot.demo.provider.entity.db.User;
import com.west2.dubbo.springboot.demo.provider.mapper.UserMapper;
import com.west2.dubbo.springboot.demo.provider.service.base.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Slf4j
@Service
public class DbUserService extends CrudService<UserMapper, User> {

    @Autowired
    private BCryptPasswordEncoder encoder;

    public User userRegister(String username, String plainPassword) {
        User user = new User();
        user.setUsername(username).
                setPassword(encoder.encode(plainPassword)).
                setId(IdWorker.getId(user)+"");
        user.setNewRecord(true);
        if (0 < this.save(user)) {
            return user;
        } else {
            return null;
        }
    }

    public User getUserByName(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        List<User> list = this.findList(wrapper);
        if (0 < list.size()) {
            return list.get(0);
        } else {
            return null;
        }

    }



}
