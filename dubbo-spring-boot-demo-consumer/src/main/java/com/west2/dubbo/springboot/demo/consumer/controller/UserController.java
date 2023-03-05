package com.west2.dubbo.springboot.demo.consumer.controller;

import com.west2.dubbo.springboot.demo.consumer.common.CommonResult;
import com.west2.dubbo.springboot.demo.consumer.entity.vo.UserVO;
import com.west2.dubbo.springboot.demo.consumer.util.UserModelUtil;
import com.west2.provider.service.proto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(value = "user")
@Api(value = "UserController", tags = "用户接口")
public class UserController {

    @DubboReference
    private UserService userService;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public CommonResult userRegister(@RequestBody UserVO vo) {
        CommonResult result = new CommonResult().init();
        UserRegisterRequest req = UserRegisterRequest.
                newBuilder().
                setUsername(vo.getUsername()).
                setPassword(vo.getPassword()).
                build();
        UserResponse resp = userService.userRegister(req);
        UserVO user = UserModelUtil.buildVO(resp.getUser());

        result.success("user", user);
        return (CommonResult) result.end();
    }

    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public CommonResult userLogin(@RequestBody UserVO vo) {
        CommonResult result = new CommonResult().init();
        UserLoginRequest req = UserLoginRequest.
                newBuilder().
                setUsername(vo.getUsername()).
                setPassword(vo.getPassword()).
                build();
        UserResponse resp = userService.userLogin(req);
        UserVO user = UserModelUtil.buildVO(resp.getUser());

        result.success("user", user);
        return (CommonResult) result.end();
    }







}
