package command;

import command.impl.CreateGroupConsoleCommand;
import command.impl.LogoutConsoleCommand;
import command.impl.SendGroupConsoleCommand;
import command.impl.SendToUserConsoleCommand;
import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ProjectName: zcx-im
 * @Package: command
 * @ClassName: ConsoleCommandManager
 * @Author: loafer
 * @Description: 命令行管理器
 * @Date: 2020/6/1 9:41
 * @Version: 1.0
 */
public class ConsoleCommandManager implements ConsoleCommand {
    /**
     * 命令行执行map
     */
    private Map<String, ConsoleCommand> consoleCommandMap;


    public ConsoleCommandManager() {
        consoleCommandMap = new HashMap<>(3);
        consoleCommandMap.put("s", new SendToUserConsoleCommand());
        consoleCommandMap.put("lo", new LogoutConsoleCommand());
        consoleCommandMap.put("cg", new CreateGroupConsoleCommand());
        consoleCommandMap.put("g", new SendGroupConsoleCommand());
    }

    @Override
    public void exec(Scanner scanner, Channel channel) {
        String command = scanner.next();

        ConsoleCommand consoleCommand = consoleCommandMap.get(command);

        if (consoleCommand != null) {
            consoleCommand.exec(scanner, channel);
        } else {
            System.err.println("无法识别[" + command + "]指令，请重新输入!");
        }
    }

}
