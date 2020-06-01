package protocol.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import protocol.Packet;
import protocol.command.Command;

/**
 * @ProjectName: zcx-im
 * @Package: protocol.response
 * @ClassName: GroupMessageResponsePacket
 * @Author: loafer
 * @Description:
 * @Date: 2020/6/1 16:36
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
public class GroupMessageResponsePacket extends Packet {
    /**
     * 来自用户名
     */
    private String fromUserName;

    /**
     * 来自用户id
     */
    private String userNameId;
    /**
     * content
     */
    private String content;


    @Override
    public Byte getCommand() {
        return Command.MESSAGE_GROUP_RESPONSE;
    }
}
