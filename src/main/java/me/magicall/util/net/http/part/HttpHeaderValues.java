package me.magicall.util.net.http.part;

import java.util.List;

/**
 * http头信息的值。
 * <pre>
 * 头信息值1, 头信息值2, ……
 * </pre>
 *
 * @author Liang Wenjian
 */
public interface HttpHeaderValues<E extends HttpHeaderValue> extends List<E> {

    /**
     * 将头信息值格式化为字符串。
     *
     * @return
     */
    default String asString() {
        final StringBuilder sb = new StringBuilder();
        for (final HttpHeaderValue v : this) {
            sb.append(v.asString()).append(SEPARATE_CHAR);
        }
        return sb.toString();
    }

    //----------------------------------------------

    /**
     * 值和值之间的分隔符。
     */
    char SEPARATE_CHAR = ',';

    /**
     * 值和值之间的分隔符。
     */
    String SEPARATOR = String.valueOf(SEPARATE_CHAR);

    static <T extends HttpHeaderValue> HttpHeaderValues<T> empty() {
        return new HttpHeaderValuesImpl<>();
    }
}
