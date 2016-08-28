package me.magicall.util.net.http.part;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 头信息列表。
 * <pre>结构：
 *     请求头1（{@link HttpHeader}）
 *     请求头2
 *     ……
 * </pre>
 *
 * @author Liang Wenjian
 */
public interface HttpHeaders extends List<HttpHeader<?>>, HttpPart {

    String HEADER_SEPARATOR = CRLF;

    @Override
    default String asString() {
        if (isEmpty()) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        for (final HttpHeader<?> header : this) {
            sb.append(header.asString()).append(HEADER_SEPARATOR);
        }
        return sb.toString();
    }

    default List<HttpHeader<?>> findByName(final String name) {
        return stream().filter(e -> e.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    static HttpHeaders empty() {
        return new HttpHeadersImpl();
    }
}
