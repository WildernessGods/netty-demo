package io.wilderness.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.wilderness.warp.C2SHeartbeatReq;
import io.wilderness.warp.C2SLoginReq;
import io.wilderness.warp.C2SMessageReq;
import io.wilderness.warp.MessageChat;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProtobufClientHandler extends SimpleChannelInboundHandler<MessageChat> {
    public static final String HANDLER_NAME = "ChatClientHandler";

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        ctx.writeAndFlush(MessageChat.newBuilder()
                .setMessageType(MessageChat.MessageType.C2SLOGINREQ)
                .setLoginReq(C2SLoginReq.newBuilder().setName("admin").setPassword("123456").build())
                .build());
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, MessageChat messageChat) throws Exception {
        log.debug("receive:" + messageChat.toString());
        if (messageChat.getMessageType() == MessageChat.MessageType.S2CHEARTBEATRES) {
            ctx.writeAndFlush(MessageChat.newBuilder()
                    .setMessageType(MessageChat.MessageType.C2SMESSAGEREQ)
                    .setMessageReq(C2SMessageReq.newBuilder().setTargetId("root").setMsg("123456").build())
                    .build());
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
        if (evt instanceof IdleStateEvent) {
            ctx.writeAndFlush(MessageChat.newBuilder()
                    .setMessageType(MessageChat.MessageType.C2SHEARTBEATREQ)
                    .setHeartbeatReq(C2SHeartbeatReq.newBuilder().build())
                    .build());
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        ctx.close();
    }
}
