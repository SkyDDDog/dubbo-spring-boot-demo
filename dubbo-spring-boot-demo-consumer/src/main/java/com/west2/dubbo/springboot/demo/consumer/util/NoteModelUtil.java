package com.west2.dubbo.springboot.demo.consumer.util;

import com.west2.dubbo.springboot.demo.consumer.entity.vo.NoteVO;
import com.west2.provider.service.proto.NoteModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoteModelUtil {

    public static NoteVO buildVO(NoteModel model) {
        NoteVO vo = new NoteVO();
        vo.setContent(model.getContent());
        return vo;
    }

    public static List<NoteVO> buildVOList(List<NoteModel> modelList) {
        ArrayList<NoteVO> result = new ArrayList<>(modelList.size());
        for (NoteModel noteModel : modelList) {
            result.add(NoteModelUtil.buildVO(noteModel));
        }
        return result;
    }

}
