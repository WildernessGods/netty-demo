package io.wilderness.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.wilderness.warp.MessageChat;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChatServerHandler extends SimpleChannelInboundHandler<MessageChat> {
    public static final String HANDLER_NAME = "ChatServerHandler";

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, MessageChat messageChat) throws Exception {

        if (messageChat.getMessageType() == MessageChat.MessageType.C2SLOGINREQ) {
            ctx.fireChannelRead(messageChat.getLoginReq());
        } else if (messageChat.getMessageType() == MessageChat.MessageType.C2SHEARTBEATREQ) {
            ctx.fireChannelRead(messageChat.getHeartbeatReq());
        } else if (messageChat.getMessageType() == MessageChat.MessageType.C2SMESSAGEREQ) {
            ctx.fireChannelRead(messageChat.getMessageReq());
        }
    }
}
