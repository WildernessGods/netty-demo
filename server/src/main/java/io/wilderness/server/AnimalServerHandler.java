package io.wilderness.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.wilderness.warp.Zoo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnimalServerHandler extends SimpleChannelInboundHandler<Zoo.MessageZoo> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        Zoo.MessageZoo messageZoo = Zoo.MessageZoo.newBuilder()
                .setAnimalType(Zoo.MessageZoo.AnimalType.DOG)
                .setDog(Zoo.Dog.newBuilder().setName("旺财").setLeg(4).setBarking("汪汪").setSwim(true).build())
                .build();
//        log.debug("send:" + messageZoo.toString());
//        ctx.writeAndFlush(messageZoo);
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Zoo.MessageZoo messageZoo) throws Exception {
        log.debug("receive:" + messageZoo.toString());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }
}
