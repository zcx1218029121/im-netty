package client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.response.CreateGroupResponsePacket;

/**
 * @ProjectName: zcx-im
 * @Package: client.handler
 * @ClassName: CreateGroupResponseHandler
 * @Author: loafer
 * @Description: 创建登录响应
 * @Date: 2020/6/1 11:41
 * @Version: 1.0
 */
public class CreateGroupResponseHandler extends SimpleChannelInboundHandler<CreateGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupResponsePacket msg) throws Exception {
        System.out.print("群创建成功，id 为[" + msg.getGroupId() + "], ");
        System.out.println("群里面有：" + msg.getUserNameList());
    }
}
