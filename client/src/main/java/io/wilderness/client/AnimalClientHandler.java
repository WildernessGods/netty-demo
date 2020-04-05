package io.wilderness.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.wilderness.warp.Zoo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnimalClientHandler extends SimpleChannelInboundHandler<Zoo.MessageZoo> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        Zoo.MessageZoo messageZoo = Zoo.MessageZoo.newBuilder()
                .setAnimalType(Zoo.MessageZoo.AnimalType.DOG)
                .setDog(Zoo.Dog.newBuilder()
//                .setChicken(Zoo.Chicken.newBuilder()
//                        .setName("鸡鸡")
                        .setLeg(4)
//                        .setBarking("咯咯")
                        .setSwim(true)
                        .build()
                ).build();
        log.debug("send:" + messageZoo.toString());
        ctx.writeAndFlush(messageZoo);
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
