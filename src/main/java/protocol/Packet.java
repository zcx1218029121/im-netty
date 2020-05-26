package protocol;

import lombok.Data;

/**
 * @author Administrator
 * 通讯协议的抽象
 */
@Data
public abstract class Packet {
    /**
     * 协议版本
     */
    private Byte version = 1;

    /**
     * 获取指令
     * @return 返回指令代码 本协议中用一个字节表示
     */
    public abstract Byte getCommand();
}
