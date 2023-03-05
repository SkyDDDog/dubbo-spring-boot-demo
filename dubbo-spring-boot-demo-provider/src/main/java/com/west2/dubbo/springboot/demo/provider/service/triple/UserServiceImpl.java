package com.west2.dubbo.springboot.demo.provider.service.triple;

import com.west2.dubbo.springboot.demo.provider.entity.db.User;
import com.west2.dubbo.springboot.demo.provider.service.db.DbUserService;
import com.west2.provider.service.proto.*;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

//@Service
@DubboService
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DbUserService userService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    private static UserModel buildModel(User user) {
        return UserModel.newBuilder().
                setId(user.getId()).
                setUsername(user.getUsername()).
                setPassword(user.getPassword()).
                build();
    }

    @Override
    public UserResponse userRegister(UserRegisterRequest request) {
        User user = userService.userRegister(request.getUsername(), request.getPassword());
        UserResponse resp = UserResponse.newBuilder().
                setUser(buildModel(user)).
                build();
        return resp;
    }

    @Override
    public CompletableFuture<UserResponse> userRegisterAsync(UserRegisterRequest request) {
        return UserService.super.userRegisterAsync(request);
    }

    @Override
    public UserResponse userLogin(UserLoginRequest req) {
        User dbUser = userService.getUserByName(req.getUsername());
        UserResponse.Builder builder = UserResponse.newBuilder();
        UserModel.Builder modelBuilder = UserModel.newBuilder();
        req.getPassword();
        if (dbUser != null && encoder.matches(req.getPassword(), dbUser.getPassword())) {
            builder.setUser(buildModel(dbUser));
        }
        UserResponse resp = builder.build();
        return resp;
    }

    @Override
    public CompletableFuture<UserResponse> userLoginAsync(UserLoginRequest request) {
        return UserService.super.userLoginAsync(request);
    }
}
