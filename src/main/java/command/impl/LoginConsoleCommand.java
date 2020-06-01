package command.impl;

import command.ConsoleCommand;
import io.netty.channel.Channel;
import protocol.request.LoginRequestPacket;

import java.util.Scanner;

/**
 * @ProjectName: zcx-im
 * @Package: command.impl
 * @ClassName: LoginConsoleCommand
 * @Author: loafer
 * @Description: 登录command
 * @Date: 2020/6/1 10:06
 * @Version: 1.0
 */
public class LoginConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

        System.out.print("输入用户名登录: ");
        loginRequestPacket.setUsername(scanner.nextLine());
        loginRequestPacket.setPassword("pwd");

        // 发送登录数据包
        channel.writeAndFlush(loginRequestPacket);
        waitForLoginResponse();
    }

    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}
