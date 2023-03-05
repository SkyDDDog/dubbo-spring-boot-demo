package com.west2.dubbo.springboot.demo.provider.service.triple;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.west2.dubbo.springboot.demo.provider.entity.db.Note;
import com.west2.dubbo.springboot.demo.provider.service.db.DbNoteService;
import com.west2.provider.service.proto.*;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@DubboService
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private DbNoteService noteService;

    private static NoteModel buildModel(Note note) {
        return NoteModel.newBuilder().setContent(note.getContent()).build();
    }

    private static List<NoteModel> buildModels(List<Note> list) {
        ArrayList<NoteModel> result = new ArrayList<>(list.size());
        for (Note note : list) {
            result.add(buildModel(note));
        }
        return result;
    }


    @Override
    public NoteResponse saveNote(NoteRequest req) {
        Note note = new Note();
        note.setContent(req.getContent()).
                setNewRecord(req.getNewRecord());
        noteService.save(note);

        return NoteResponse.newBuilder().setNote(buildModel(note)).build();
    }

    @Override
    public CompletableFuture<NoteResponse> saveNoteAsync(NoteRequest request) {
        return NoteService.super.saveNoteAsync(request);
    }

    @Override
    public NoteListResponse noteList(NoteRequest request) {
        List<Note> list = noteService.findList(new QueryWrapper<>());
        NoteListResponse.Builder builder = NoteListResponse.newBuilder();

        for (int i = 0; i < list.size(); i++) {
//            builder.setNoteList(i, );
            builder.addNoteList(buildModel(list.get(i)));
        }

        return builder.build();
    }

    @Override
    public CompletableFuture<NoteListResponse> noteListAsync(NoteRequest request) {
        return NoteService.super.noteListAsync(request);
    }
}
