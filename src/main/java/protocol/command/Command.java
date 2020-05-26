package protocol.command;

/**
 * @author Administrator
 * 指令抽象
 */
public interface Command {
    /**
     * 用户登录指令
     */
    Byte LOGIN_REQUEST = 1;
    /**
     * 用户登录响应指令
     */
    Byte LOGIN_RESPONSE = 2;
    /**
     * 用户发送消息的响应指令
     */
    Byte MESSAGE_REQUEST = 3;
    /**
     * 服务器响应用户发送的消息
     */
    Byte MESSAGE_RESPONSE = 4;
}
