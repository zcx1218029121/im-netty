package client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.response.GroupMessageResponsePacket;

/**
 * @ProjectName: zcx-im
 * @Package: client.handler
 * @ClassName: GroupMessageResponseHandler
 * @Author: loafer
 * @Description:
 * @Date: 2020/6/1 16:40
 * @Version: 1.0
 */
public class GroupMessageResponseHandler extends SimpleChannelInboundHandler<GroupMessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageResponsePacket msg) throws Exception {
        System.out.println("["+msg.getFromUserName()+"]" + ":" + msg.getContent());
    }
}
