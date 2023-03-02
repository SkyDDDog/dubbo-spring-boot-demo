package com.west2.dubbo.springboot.demo.provider.service.db;

import com.west2.dubbo.springboot.demo.provider.entity.db.Note;
import com.west2.dubbo.springboot.demo.provider.mapper.NoteMapper;
import com.west2.dubbo.springboot.demo.provider.service.base.CrudService;
import org.springframework.stereotype.Service;

@Service
public class DbNoteService extends CrudService<NoteMapper, Note> {






}
