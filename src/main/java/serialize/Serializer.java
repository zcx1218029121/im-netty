package serialize;

import serialize.impl.JSONSerializer;

/**
 * 协议 序列化接口
 *
 * @author loafer
 */
public interface Serializer {
    /**
     * 默认序列化算法
     */
    byte JSON_SERIALIZER = 1;
    /**
     * 默认序列化器
     */
    Serializer DEFAULT = new JSONSerializer();
    /**
     * 序列化算法
     * @return  序列化算法序号
     */
    byte getSerializerAlgorithm();

    /**
     * java 对象转换成二进制
     * @param object  序列化对象
     * @return  序列化后的字符串
     */
    byte[] serialize(Object object);

    /**
     * 二进制转换成 java 对象
     * @return 反序列化对象
     * @param clazz  clazz
     * @param bytes 比特
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
