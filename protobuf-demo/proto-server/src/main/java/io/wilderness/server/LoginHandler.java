package io.wilderness.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.wilderness.warp.C2SLoginReq;
import io.wilderness.warp.MessageChat;
import io.wilderness.warp.S2CLoginRes;
import lombok.extern.slf4j.Slf4j;

/**
 * @author an_qiang
 */
@Slf4j
public class LoginHandler extends SimpleChannelInboundHandler<C2SLoginReq> {
    public static final String HANDLER_NAME = "LoginHandler";

    @Override
    protected void channelRead0(final ChannelHandlerContext ctx, final C2SLoginReq loginReq) {
        log.debug("login:" + loginReq.toString());
        ctx.pipeline().addAfter(LoginHandler.HANDLER_NAME, LifeHandler.HANDLER_NAME, new LifeHandler());
        ctx.pipeline().addAfter(LifeHandler.HANDLER_NAME, MessageHandler.HANDLER_NAME, new MessageHandler());
        ctx.pipeline().remove(LoginHandler.HANDLER_NAME);

        ctx.writeAndFlush(MessageChat.newBuilder()
                .setMessageType(MessageChat.MessageType.S2CLOGINRES)
                .setLoginRes(S2CLoginRes.newBuilder().setStatus(1).build())
                .build());
    }
}
