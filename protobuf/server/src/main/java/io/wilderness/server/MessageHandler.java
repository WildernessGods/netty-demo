package io.wilderness.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.wilderness.warp.C2SMessageReq;
import io.wilderness.warp.MessageChat;
import io.wilderness.warp.S2CMessageRes;
import lombok.extern.slf4j.Slf4j;

/**
 * @author an_qiang
 */
@Slf4j
public class MessageHandler extends SimpleChannelInboundHandler<C2SMessageReq> {
    public static final String HANDLER_NAME = "MessageHandler";

    @Override
    protected void channelRead0(final ChannelHandlerContext ctx, final C2SMessageReq messageReq) {
        log.debug("message:" + messageReq.toString());

        ctx.writeAndFlush(MessageChat.newBuilder()
                .setMessageType(MessageChat.MessageType.S2CMESSAGERES)
                .setMessageRes(S2CMessageRes.newBuilder().setSourceId(messageReq.getTargetId()).setMsg("456").build())
                .build());
    }
}
