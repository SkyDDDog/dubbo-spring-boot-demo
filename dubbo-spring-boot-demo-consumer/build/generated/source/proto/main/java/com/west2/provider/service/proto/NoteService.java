package com.west2.provider.service.proto;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

public interface NoteService {

    static final String JAVA_SERVICE_NAME = "com.west2.provider.service.proto.NoteService";
    static final String SERVICE_NAME = "proto.NoteService";

    // FIXME, initialize Dubbo3 stub when interface loaded, thinking of new ways doing this.
    static final boolean inited = NoteServiceDubbo.init();

    com.west2.provider.service.proto.NoteResponse saveNote(com.west2.provider.service.proto.NoteRequest request);

    default CompletableFuture<com.west2.provider.service.proto.NoteResponse> saveNoteAsync(com.west2.provider.service.proto.NoteRequest request){
        return CompletableFuture.supplyAsync(() -> saveNote(request));
    }

    com.west2.provider.service.proto.NoteListResponse noteList(com.west2.provider.service.proto.NoteRequest request);

    default CompletableFuture<com.west2.provider.service.proto.NoteListResponse> noteListAsync(com.west2.provider.service.proto.NoteRequest request){
        return CompletableFuture.supplyAsync(() -> noteList(request));
    }




}
