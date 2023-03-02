package com.west2.dubbo.springboot.demo.provider.service.triple;


import com.west2.provider.service.proto.demoRequest;
import com.west2.provider.service.proto.demoResponse;
import com.west2.provider.service.proto.demoService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.concurrent.CompletableFuture;

@DubboService
public class DemoServiceImpl implements demoService {

    @Override
    public demoResponse sayHello(demoRequest request) {
        return demoResponse.newBuilder().setHello("hello "+request.getName()).build();
    }

    @Override
    public CompletableFuture<demoResponse> sayHelloAsync(demoRequest request) {
        return demoService.super.sayHelloAsync(request);
    }
}
