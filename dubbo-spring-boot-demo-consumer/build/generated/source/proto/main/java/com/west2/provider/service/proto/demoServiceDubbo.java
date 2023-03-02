    package com.west2.provider.service.proto;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

public final class demoServiceDubbo {
private static final AtomicBoolean registered = new AtomicBoolean();

public static boolean init() {
    if (registered.compareAndSet(false, true)) {
            org.apache.dubbo.rpc.protocol.tri.SingleProtobufUtils.marshaller(
            com.west2.provider.service.proto.demoRequest.getDefaultInstance());
            org.apache.dubbo.rpc.protocol.tri.SingleProtobufUtils.marshaller(
            com.west2.provider.service.proto.demoResponse.getDefaultInstance());
    }
    return true;
}

private demoServiceDubbo() {}

}
