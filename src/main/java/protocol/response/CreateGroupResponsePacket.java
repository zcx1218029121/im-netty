package protocol.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import protocol.Packet;
import protocol.command.Command;

import java.util.List;

/**
 * @ProjectName: zcx-im
 * @Package: protocol.response
 * @ClassName: CreateGroupResponsePacket
 * @Author: loafer
 * @Description: 响应
 * @Date: 2020/6/1 11:30
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
public class CreateGroupResponsePacket extends Packet {
    /**
     * 是否登入成功
     */
    private boolean success;
    /**
     * 聊天室id
     */
    private String groupId;
    /**
     *用户名列表
     */
    private List<String> userNameList;

    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_RESPONSE;
    }
}
