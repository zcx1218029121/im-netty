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

    /**
     * 登出的请求
     */
    Byte LOGOUT_REQUEST = 5;
    /**
     * 登出响应
     */
    Byte LOGOUT_RESPONSE = 6;
    /**
     * 创建群聊 请求
     */
    Byte CREATE_GROUP_REQUEST = 7;
    /**
     * 创建群聊 响应
     */
    Byte CREATE_GROUP_RESPONSE = 8;

    /**
     * 群聊 请求
     */
    Byte MESSAGE_GROUP_REQUEST = 9;

    /**
     * 群聊 响应
     */
    Byte MESSAGE_GROUP_RESPONSE = 10;
}
