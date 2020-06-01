package server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import protocol.request.GroupMessageRequestPacket;
import protocol.response.GroupMessageResponsePacket;
import util.SessionUtil;

/**
 * @ProjectName: zcx-im
 * @Package: server.handler
 * @ClassName: MessageGroupRequestHandler
 * @Author: loafer
 * @Description:
 * @Date: 2020/6/1 16:26
 * @Version: 1.0
 */
public class GroupMessageRequestHandler  extends SimpleChannelInboundHandler<GroupMessageRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageRequestPacket msg) throws Exception {
            // 获取对应的group
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(msg.getToGroupId());
        GroupMessageResponsePacket responsePacket = new GroupMessageResponsePacket();
        responsePacket.setContent(msg.getContent());
        responsePacket.setFromUserName(msg.getFromUserName());
        channelGroup.writeAndFlush(responsePacket);
    }
}
