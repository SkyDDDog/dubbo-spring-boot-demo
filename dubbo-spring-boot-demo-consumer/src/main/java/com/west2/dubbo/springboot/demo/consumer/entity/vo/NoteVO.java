package com.west2.dubbo.springboot.demo.consumer.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "NoteVO")
public class NoteVO {

    @ApiModelProperty(value = "笔记内容")
    private String content;

}
