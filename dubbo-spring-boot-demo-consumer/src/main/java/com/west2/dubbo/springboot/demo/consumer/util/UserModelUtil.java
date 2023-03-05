package com.west2.dubbo.springboot.demo.consumer.util;

import com.west2.dubbo.springboot.demo.consumer.entity.vo.UserVO;
import com.west2.provider.service.proto.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserModelUtil {

    public static UserVO buildVO(UserModel model) {
        UserVO vo = new UserVO();
        vo.setUsername(model.getUsername()).
                setPassword(model.getPassword());
        return vo;
    }


}
