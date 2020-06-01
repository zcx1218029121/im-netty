package protocol.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import protocol.Packet;
import protocol.command.Command;

/**
 * @ProjectName: zcx-im
 * @Package: protocol.response
 * @ClassName: LogoutResponsePacket
 * @Author: loafer
 * @Description: 登出封包
 * @Date: 2020/6/1 9:53
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
public class LogoutResponsePacket extends Packet {
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 响应消息
     */
    private String reason;

    @Override
    public Byte getCommand() {
        return Command.LOGOUT_RESPONSE;
    }
}
