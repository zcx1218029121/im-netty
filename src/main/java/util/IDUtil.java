package util;

import java.util.UUID;

/**
 * @ProjectName: zcx-im
 * @Package: util
 * @ClassName: IDUtil
 * @Author: loafer
 * @Description: id util 的实现
 * @Date: 2020/6/1 11:38
 * @Version: 1.0
 */
public class IDUtil {
    public static String randomId() {
        return UUID.randomUUID().toString().split("-")[0];
    }
}
