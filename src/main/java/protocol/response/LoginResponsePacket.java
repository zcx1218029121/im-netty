package protocol.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import protocol.Packet;
import protocol.command.Command;

/**
 * @author zcx1218029121
 * 用户登录响应封包
 */
@Data
@NoArgsConstructor
public class LoginResponsePacket extends Packet {
    private boolean success;

    private String reason;

    public LoginResponsePacket(boolean success, String reason) {
        this.success = success;
        this.reason = reason;
    }

    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
