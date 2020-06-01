package command.impl;

import command.ConsoleCommand;
import io.netty.channel.Channel;
import protocol.request.GroupMessageRequestPacket;

import java.util.Scanner;

/**
 * @ProjectName: zcx-im
 * @Package: command.impl
 * @ClassName: SendGroupConsoleCommand
 * @Author: loafer
 * @Description:
 * @Date: 2020/6/1 16:43
 * @Version: 1.0
 */
public class SendGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个群组：");

        String toGroupId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new GroupMessageRequestPacket("test", message,toGroupId));

    }
}
