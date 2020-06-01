package command.impl;

import command.ConsoleCommand;
import io.netty.channel.Channel;
import protocol.request.CreateGroupRequestPacket;
import session.Session;
import util.SessionUtil;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ProjectName: zcx-im
 * @Package: command.impl
 * @ClassName: CreateGroupConsoleCommand
 * @Author: loafer
 * @Description: 创建群聊的指令
 * @Date: 2020/6/1 9:44
 * @Version: 1.0
 */
public class CreateGroupConsoleCommand implements ConsoleCommand {
    private static final String USER_ID_SPLITER = ",";

    @Override
    public void exec(Scanner scanner, Channel channel) {
        CreateGroupRequestPacket createGroupRequestPacket = new CreateGroupRequestPacket();

        System.out.print("【拉人群聊】输入 userId 列表，userId 之间英文逗号隔开：");
        String userIds = scanner.next();
        createGroupRequestPacket.setUserIdList(Arrays.asList(userIds.split(USER_ID_SPLITER)));

        channel.writeAndFlush(createGroupRequestPacket);
    }
}
