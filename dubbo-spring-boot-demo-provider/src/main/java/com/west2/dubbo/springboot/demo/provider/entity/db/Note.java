package com.west2.dubbo.springboot.demo.provider.entity.db;

import com.west2.dubbo.springboot.demo.provider.entity.base.DataEntity;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Note extends DataEntity<Note> {

    private String content;

}
