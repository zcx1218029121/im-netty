package server;

import com.sun.xml.internal.ws.api.model.MEP;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
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

        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet = PacketCodeC.INSTANCE.decode(byteBuf);
        if(packet instanceof LoginRequestPacket){
            LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;
            if (loginRequestPacket.getUsername().equals("flash") && loginRequestPacket.getPassword().equals("123")){

               //处理登录
                ctx.channel().writeAndFlush(makeLoginResponse(true,"登录成功",ctx));
            }else {
                // 处理登录失败
                ctx.channel().writeAndFlush(makeLoginResponse(false,"账号或者密码错误",ctx));
            }
        }else if (packet instanceof MessageRequestPacket){
            MessageRequestPacket messageRequestPacket = ((MessageRequestPacket) packet);
            System.out.println(new Date() + ": 收到客户端消息: " + messageRequestPacket.getMessage());

            MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
            messageResponsePacket.setMessage("服务端回复【" + messageRequestPacket.getMessage() + "】");
//            ByteBuf responseByteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc(), messageResponsePacket);
//            ctx.channel().writeAndFlush(responseByteBuf);
        }
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
