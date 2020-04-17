package io.wilderness.frame.client;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http2.Http2FrameCodec;
import io.netty.handler.codec.http2.Http2FrameCodecBuilder;
import io.netty.handler.codec.http2.Http2MultiplexHandler;
import io.netty.handler.codec.http2.Http2Settings;
import io.netty.handler.ssl.SslContext;

/**
 * Configures client pipeline to support HTTP/2 frames via {@link Http2FrameCodec} and {@link Http2MultiplexHandler}.
 */
public final class Http2ClientFrameInitializer extends ChannelInitializer<Channel> {

    private final SslContext sslCtx;

    public Http2ClientFrameInitializer(SslContext sslCtx) {
        this.sslCtx = sslCtx;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        // ensure that our 'trust all' SSL handler is the first in the pipeline if SSL is enabled.
        if (sslCtx != null) {
            ch.pipeline().addFirst(sslCtx.newHandler(ch.alloc()));
        }

        final Http2FrameCodec http2FrameCodec = Http2FrameCodecBuilder.forClient()
                .initialSettings(Http2Settings.defaultSettings()) // this is the default, but shows it can be changed.
                .build();
        ch.pipeline().addLast(http2FrameCodec);
        ch.pipeline().addLast(new Http2MultiplexHandler(new SimpleChannelInboundHandler() {
            @Override
            protected void channelRead0(ChannelHandlerContext ctx, Object msg) {
                // NOOP (this is the handler for 'inbound' streams, which is not relevant in this example)
            }
        }));
    }

}
