package command.impl;

import command.ConsoleCommand;
import io.netty.channel.Channel;
import protocol.request.MessageRequestPacket;

import java.util.Scanner;

/**
 * @ProjectName: zcx-im
 * @Package: command.impl
 * @ClassName: SendToUserConsoleCommand
 * @Author: loafer
 * @Description: 发送消息的指令
 * @Date: 2020/6/1 10:08
 * @Version: 1.0
 */
public class SendToUserConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个用户：");

        String toUserId = scanner.next();
        String message = scanner.next();
        System.out.print(toUserId);
        System.out.print(message);
        channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
    }
}
