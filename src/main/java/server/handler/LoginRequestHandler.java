package server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.request.LoginRequestPacket;
import protocol.request.MessageRequestPacket;
import protocol.response.LoginResponsePacket;
import protocol.response.MessageResponsePacket;

public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket msg) throws Exception {
        if (msg.getPassword().equals("123") && msg.getUsername().equals("admin")) {
            reply(ctx, "登录成功",true);
        } else {
            ctx.channel().writeAndFlush(new MessageResponsePacket());
            reply(ctx, "账号或者密码错误",false);
        }
    }

    private void reply(ChannelHandlerContext ctx, String msg,boolean isSuccess) {
        ctx.channel().writeAndFlush(new LoginResponsePacket(isSuccess,msg));
    }
}
