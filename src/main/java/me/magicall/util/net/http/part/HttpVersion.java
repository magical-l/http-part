package me.magicall.util.net.http.part;

/**
 * HTTP协议版本。
 * <pre>结构：
 *     协议名/主版本号.次版本号
 * </pre>
 *
 * @author Liang Wenjian
 */
public interface HttpVersion {

    int getMajor();

    int getMinor();

    default String asString() {
        return "HTTP/" + getMajor() + '.' + getMinor();
    }
}
