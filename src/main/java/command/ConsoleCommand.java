package command;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @ProjectName: zcx-im
 * @Package: command
 * @ClassName: ConsoleCommand
 * @Author: loafer
 * @Description: 命令行抽象
 * @Date: 2020/6/1 9:40
 * @Version: 1.0
 */
public interface ConsoleCommand {
    /**
     * 命令行执行
     * @param scanner
     * @param channel
     */
    void exec(Scanner scanner, Channel channel);
}
