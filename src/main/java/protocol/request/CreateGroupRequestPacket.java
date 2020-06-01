package protocol.request;

import lombok.Data;
import protocol.Packet;
import protocol.command.Command;

import java.util.List;

/**
 * @ProjectName: zcx-im
 * @Package: protocol.request
 * @ClassName: CreateGroupRequestPacket
 * @Author: loafer
 * @Description: 创建群聊的指令
 * @Date: 2020/6/1 9:46
 * @Version: 1.0
 */
@Data
public class CreateGroupRequestPacket extends Packet {
    private List<String> userIdList;
    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_REQUEST;
    }
}
