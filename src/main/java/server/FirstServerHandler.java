package server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import protocol.Packet;
import protocol.PacketCodeC;
import protocol.request.LoginRequestPacket;
import protocol.request.MessageRequestPacket;
import protocol.response.LoginResponsePacket;
import protocol.response.MessageResponsePacket;

import java.nio.charset.Charset;
import java.util.Date;

public class FirstServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        TextWebSocketFrame textWebSocketFrame = (TextWebSocketFrame) msg;



        ctx.channel().writeAndFlush(new TextWebSocketFrame("我是你爹"));
    }
    //    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        super.channelActive(ctx);
//        System.out.println(new Date() + ": 客户端写出数据");
//
//        // 1. 获取数据
//        ByteBuf buffer = getByteBuf(ctx);
//
//        // 2. 写数据
//        ctx.channel().writeAndFlush(buffer);
//    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx,String txt) {
        // 1. 获取二进制抽象 ByteBuf
        ByteBuf buffer = ctx.alloc().buffer();

        // 2. 准备数据，指定字符串的字符集为 utf-8
        byte[] bytes = txt.getBytes(Charset.forName("utf-8"));

        // 3. 填充数据到 ByteBuf
        buffer.writeBytes(bytes);

        return buffer;
    }
    private ByteBuf makeLoginResponse(boolean success,String reason,ChannelHandlerContext ctx){
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setReason(reason);
        loginResponsePacket.setSuccess(success);
        return null;

    }
}
