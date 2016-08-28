package me.magicall.util.net.http.part;

/**
 * http信息的一部分。
 * 本接口仅指定asString方法。
 *
 * @author Liang Wenjian
 */
@FunctionalInterface
public interface HttpPart {

    String CRLF = "\r\n";

    /**
     * 格式化为在http传输过程中合适的字符串。
     *
     * @return
     */
    String asString();
}
