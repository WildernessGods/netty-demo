package io.wilderness.grpc;

import io.grpc.stub.StreamObserver;
import io.wilderness.grpc.proto.GreeterGrpc;
import io.wilderness.grpc.proto.HelloReply;
import io.wilderness.grpc.proto.HelloRequest;

/**
 * @author an_qiang
 */
public class GreeterGrpcImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        System.out.println("1 request:" + request.getName());
        responseObserver.onNext(HelloReply.newBuilder().setMessage("11").build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<HelloRequest> sayHelloRequestStreaming(StreamObserver<HelloReply> responseObserver) {
        return new StreamObserver<HelloRequest>() {
            @Override
            public void onNext(HelloRequest helloRequest) {
                System.out.println("2 request:" + helloRequest.getName());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("2 error:" + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(HelloReply.newBuilder().setMessage("22").build());
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void sayHelloReturnStreaming(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        System.out.println("3 request:" + request.getName());
        responseObserver.onNext(HelloReply.newBuilder().setMessage("33").build());
        responseObserver.onNext(HelloReply.newBuilder().setMessage("333").build());
        responseObserver.onNext(HelloReply.newBuilder().setMessage("3333").build());
        responseObserver.onNext(HelloReply.newBuilder().setMessage("33333").build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<HelloRequest> sayHelloStreamings(StreamObserver<HelloReply> responseObserver) {
        return new StreamObserver<HelloRequest>() {
            @Override
            public void onNext(HelloRequest helloRequest) {
                System.out.println("4 request:" + helloRequest.getName());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("4 error:" + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(HelloReply.newBuilder().setMessage("44").build());
                responseObserver.onNext(HelloReply.newBuilder().setMessage("444").build());
                responseObserver.onNext(HelloReply.newBuilder().setMessage("4444").build());
                responseObserver.onNext(HelloReply.newBuilder().setMessage("44444").build());
                responseObserver.onCompleted();
            }
        };
    }
}
