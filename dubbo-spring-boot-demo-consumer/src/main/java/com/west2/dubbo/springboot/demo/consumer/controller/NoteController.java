package com.west2.dubbo.springboot.demo.consumer.controller;

import com.west2.dubbo.springboot.demo.consumer.common.CommonResult;
import com.west2.dubbo.springboot.demo.consumer.entity.vo.NoteVO;
import com.west2.provider.service.proto.NoteListResponse;
import com.west2.provider.service.proto.NoteRequest;
import com.west2.provider.service.proto.NoteResponse;
import com.west2.provider.service.proto.NoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(value = "note")
@Api(value = "NoteController", tags = "备忘录接口")
public class NoteController {

    @DubboReference
    private NoteService noteService;

    @ApiOperation(value = "创建Note")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public CommonResult createNote(@RequestBody NoteVO vo) {
        CommonResult result = new CommonResult().init();

        NoteRequest req = NoteRequest.newBuilder().
                setContent(vo.getContent()).
                setNewRecord(true).
                build();
        NoteResponse resp = noteService.saveNote(req);
        result.success("note", resp.getNote());

        return (CommonResult) result.end();
    }

    @ApiOperation(value = "查询所有Note")
    @RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
    public CommonResult noteList() {
        CommonResult result = new CommonResult().init();

        NoteListResponse resp = noteService.noteList(NoteRequest.newBuilder().build());
        result.success("note", resp.getNoteListList());

        return (CommonResult) result.end();
    }


}
