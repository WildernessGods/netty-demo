package io.wilderness.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.wilderness.warp.C2SHeartbeatReq;
import io.wilderness.warp.MessageChat;
import io.wilderness.warp.S2CHeartbeatRes;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LifeHandler extends SimpleChannelInboundHandler<C2SHeartbeatReq> {
    public static final String HANDLER_NAME = "LifeHandler";

    private int heartbeatInterval = 40;

    private int heartbeatCheckCycle = 5;

    private long lastActionTime;

    public LifeHandler() {
        lastActionTime = System.currentTimeMillis();
    }

    @Override
    protected void channelRead0(final ChannelHandlerContext ctx, final C2SHeartbeatReq heartbeatReq) {
        lastActionTime = System.currentTimeMillis();
        log.debug("收到心跳包");
        ctx.writeAndFlush(MessageChat.newBuilder()
                .setMessageType(MessageChat.MessageType.S2CHEARTBEATRES)
                .setHeartbeatRes(S2CHeartbeatRes.newBuilder().build())
                .build());
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            if (System.currentTimeMillis() - lastActionTime > heartbeatInterval * heartbeatCheckCycle * 1000) {
                ctx.close();
            }
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        log.error("客户端关闭");
    }
}