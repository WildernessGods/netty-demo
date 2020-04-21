package io.wilderness.mqtt.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.mqtt.MqttConnAckMessage;
import io.netty.handler.codec.mqtt.MqttConnAckVariableHeader;
import io.netty.handler.codec.mqtt.MqttConnectReturnCode;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MqttHeartBeatServerHandler extends SimpleChannelInboundHandler<MqttMessage> {

    @Override
    public void channelRead0(ChannelHandlerContext ctx, MqttMessage mqttMessage) throws Exception {
        log.debug("Received MQTT message: " + mqttMessage);
        switch (mqttMessage.fixedHeader().messageType()) {
            case CONNECT: {
                MqttFixedHeader connackFixedHeader = new MqttFixedHeader(MqttMessageType.CONNACK, false, MqttQoS.AT_MOST_ONCE, false, 0);
                MqttConnAckVariableHeader mqttConnAckVariableHeader = new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, false);
                MqttConnAckMessage connack = new MqttConnAckMessage(connackFixedHeader, mqttConnAckVariableHeader);
                ctx.writeAndFlush(connack);
            }
            break;
            case PUBLISH: {
            }
            break;
            case PUBREC: {
            }
            break;
            case PUBREL: {
            }
            break;
            case PUBCOMP: {
            }
            break;
            case SUBSCRIBE: {
            }
            break;
            case UNSUBSCRIBE: {
            }
            break;
            case PINGREQ: {
                MqttFixedHeader pingreqFixedHeader = new MqttFixedHeader(MqttMessageType.PINGRESP, false, MqttQoS.AT_MOST_ONCE, false, 0);
                MqttMessage pingResp = new MqttMessage(pingreqFixedHeader);
                ctx.writeAndFlush(pingResp);
            }
            break;

            case DISCONNECT: {
                ctx.close();
            }
            break;
            default: {
                log.debug("Unexpected message type: " + mqttMessage.fixedHeader().messageType());
                ReferenceCountUtil.release(mqttMessage);
                ctx.close();
            }
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        log.debug("Channel heartBeat lost");
        if (evt instanceof IdleStateEvent && IdleState.READER_IDLE == ((IdleStateEvent) evt).state()) {
            ctx.close();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
