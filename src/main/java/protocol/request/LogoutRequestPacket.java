package protocol.request;

import lombok.Data;
import protocol.Packet;
import protocol.command.Command;

/**
 * @ProjectName: zcx-im
 * @Package: protocol.request
 * @ClassName: LogoutRequestPacket
 * @Author: loafer
 * @Description: 登出封包
 * @Date: 2020/6/1 9:52
 * @Version: 1.0
 */
public class LogoutRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return Command.LOGOUT_REQUEST;
    }
}
