package util;

/**
 * Created by infi on 2015/1/26.
 */
public class UUID {
    /**
     * 获取没有中线的uuid
     *
     * @return
     */
    public static String get() {
        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }
}
