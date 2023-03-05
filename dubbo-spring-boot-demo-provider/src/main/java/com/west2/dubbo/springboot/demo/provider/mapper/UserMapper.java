package com.west2.dubbo.springboot.demo.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.west2.dubbo.springboot.demo.provider.entity.db.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {



}
