package protocol.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import protocol.Packet;
import protocol.command.Command;

/**
 * @ProjectName: zcx-im
 * @Package: protocol.request
 * @ClassName: GroupMessageRequest
 * @Author: loafer
 * @Description:
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
public class GroupMessageRequestPacket extends Packet {
    /**
     * 来自用户名
     */
    private String fromUserName;
    /**
     * 短信内容
     */
    private String content;

    private String toGroupId;

    public GroupMessageRequestPacket(String fromUserName, String content, String toGroupId) {
        this.fromUserName = fromUserName;
        this.content = content;
        this.toGroupId = toGroupId;

    }

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_GROUP_REQUEST;
    }
}
