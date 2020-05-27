package protocol.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import protocol.Packet;
import protocol.command.Command;
import protocol.response.MessageResponsePacket;

@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {
    private String message;

    private String toUserId;

    public MessageRequestPacket(String message) {
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }


}
