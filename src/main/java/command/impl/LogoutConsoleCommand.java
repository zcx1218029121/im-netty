package command.impl;

import command.ConsoleCommand;
import io.netty.channel.Channel;
import protocol.request.LogoutRequestPacket;

import java.util.Scanner;

/**
 * @ProjectName: zcx-im
 * @Package: command.impl
 * @ClassName: LogoutConsoleCommand
 * @Author: loafer
 * @Description: 登出指令
 * @Date: 2020/6/1 10:04
 * @Version: 1.0
 */
public class LogoutConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LogoutRequestPacket logoutRequestPacket = new LogoutRequestPacket();
        channel.writeAndFlush(logoutRequestPacket);
    }
}
