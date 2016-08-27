package me.magicall.util.net.http.part;

/**
 * 起始行。
 * 请求行（{@link HttpRequestLine}）和状态行（{@link HttpStatusLine}）的公共父接口
 * 参见https://tools.ietf.org/html/rfc2616#section-4
 *
 * @author Liang Wenjian
 */
public interface StartLine extends HttpPart {
    /**
     * 起始行各元素之间的分隔符（char）
     */
    char SEPARATE_CHAR = ' ';

    /**
     * 起始行各元素之间的分隔符（String）
     */
    String SEPARATOR = String.valueOf(SEPARATE_CHAR);

    /**
     * 获取协议版本。
     *
     * @return
     */
    HttpVersion getVersion();
}
