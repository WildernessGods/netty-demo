package io.wilderness.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.timeout.IdleStateHandler;
import io.wilderness.warp.MessageChat;

public class ChatClientInitializer extends ChannelInitializer<SocketChannel> {

    private final SslContext sslContext;

    public ChatClientInitializer(SslContext sslContext) {
        this.sslContext = sslContext;
    }

    @Override
    public void initChannel(SocketChannel ch) {
        ChannelPipeline p = ch.pipeline();
//        p.addLast(new LoggingHandler(LogLevel.INFO));

//        p.addLast(sslContext.newHandler(ch.alloc(), ChatClient.HOST, ChatClient.PORT));

        p.addLast(new ProtobufVarint32FrameDecoder());
        p.addLast(new ProtobufDecoder(MessageChat.getDefaultInstance()));

        p.addLast(new ProtobufVarint32LengthFieldPrepender());
        p.addLast(new ProtobufEncoder());

        p.addLast("HANDLER_IDLE_STATE", new IdleStateHandler(0, 0, 5));
        p.addLast(ChatClientHandler.HANDLER_NAME, new ChatClientHandler());
    }
}
