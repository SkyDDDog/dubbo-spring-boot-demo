package com.west2.provider.service.proto;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

public interface demoService {

    static final String JAVA_SERVICE_NAME = "com.west2.provider.service.proto.demoService";
    static final String SERVICE_NAME = "proto.demoService";

    // FIXME, initialize Dubbo3 stub when interface loaded, thinking of new ways doing this.
    static final boolean inited = demoServiceDubbo.init();

    com.west2.provider.service.proto.demoResponse sayHello(com.west2.provider.service.proto.demoRequest request);

    default CompletableFuture<com.west2.provider.service.proto.demoResponse> sayHelloAsync(com.west2.provider.service.proto.demoRequest request){
        return CompletableFuture.supplyAsync(() -> sayHello(request));
    }




}
