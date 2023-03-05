package com.west2.dubbo.springboot.demo.provider.entity.db;

import com.west2.dubbo.springboot.demo.provider.entity.base.DataEntity;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User extends DataEntity<User> {

    private String username;

    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", isNewRecord=" + isNewRecord +
                ", remarks='" + remarks + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", delFlag='" + delFlag + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
