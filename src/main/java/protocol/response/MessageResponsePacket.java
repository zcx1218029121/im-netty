package protocol.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import protocol.Packet;
import protocol.command.Command;

@Data
@NoArgsConstructor
public class MessageResponsePacket extends Packet {

    private String message;

    public MessageResponsePacket(String message) {
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
