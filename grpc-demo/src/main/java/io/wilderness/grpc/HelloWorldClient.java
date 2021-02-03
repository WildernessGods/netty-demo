package io.wilderness.grpc;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import io.wilderness.grpc.proto.GreeterGrpc;
import io.wilderness.grpc.proto.HelloReply;
import io.wilderness.grpc.proto.HelloRequest;

import java.util.concurrent.TimeUnit;

public class HelloWorldClient {

    private final GreeterGrpc.GreeterBlockingStub blockingStub;
    private final GreeterGrpc.GreeterStub stub;

    public HelloWorldClient(Channel channel) {
        blockingStub = GreeterGrpc.newBlockingStub(channel);
        stub = GreeterGrpc.newStub(channel);
    }

    public static void main(String[] args) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:50051")
                .usePlaintext()
                .build();
        try {
            HelloWorldClient client = new HelloWorldClient(channel);
            client.greet();
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }

    private void greet() throws InterruptedException {
//        HelloReply helloReply = blockingStub.sayHello(HelloRequest.newBuilder().setName("1").build());
//        System.out.println("1 reply:" + helloReply.getMessage());
//
//        System.out.println("-------------------");

//        StreamObserver<HelloRequest> helloRequestStreamObserver = stub.sayHelloRequestStreaming(new StreamObserver<HelloReply>() {
//            @Override
//            public void onNext(HelloReply helloReply) {
//                System.out.println("2 reply:" + helloReply.getMessage());
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                System.out.println("2 error:" + throwable.getMessage());
//            }
//
//            @Override
//            public void onCompleted() {
//                System.out.println("2 onCompleted");
//            }
//        });
//
//        helloRequestStreamObserver.onNext(HelloRequest.newBuilder().setName("22").build());
//        helloRequestStreamObserver.onNext(HelloRequest.newBuilder().setName("222").build());
//        helloRequestStreamObserver.onNext(HelloRequest.newBuilder().setName("2222").build());
//        helloRequestStreamObserver.onNext(HelloRequest.newBuilder().setName("22222").build());
//        helloRequestStreamObserver.onCompleted();
//
//        System.out.println("-------------------");
//
//        Iterator<HelloReply> helloReplyIterator = blockingStub.sayHelloReturnStreaming(HelloRequest.newBuilder().setName(" 3").build());
//        while (helloReplyIterator.hasNext()) {
//            System.out.println("3 reply:" + helloReplyIterator.next().getMessage());
//        }
//
//        System.out.println("-------------------");

        StreamObserver<HelloRequest> helloRequestStreamObserver1 = stub.sayHelloStreamings(new StreamObserver<HelloReply>() {
            @Override
            public void onNext(HelloReply helloReply) {
                System.out.println("4 reply:" + helloReply.getMessage());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("4 error:" + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("4 onCompleted");
            }
        });

        helloRequestStreamObserver1.onNext(HelloRequest.newBuilder().setName("44").build());
        helloRequestStreamObserver1.onNext(HelloRequest.newBuilder().setName("444").build());
        helloRequestStreamObserver1.onNext(HelloRequest.newBuilder().setName("4444").build());
        helloRequestStreamObserver1.onNext(HelloRequest.newBuilder().setName("44444").build());
        helloRequestStreamObserver1.onCompleted();

        System.out.println("-------------------");

        Thread.sleep(20000);
    }
}
