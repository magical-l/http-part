package me.magicall.util.net.http.part;

import java.net.URI;

import me.magicall.util.net.http.part.embeded.DefaultValues;
import me.magicall.util.net.http.part.embeded.HttpMethods;

/**
 * http请求起始行。
 * <pre>结构：
 *     请求方法（{@link HttpMethod}） URI http版本（{@link HttpVersion}）
 * </pre>
 *
 * @author Liang Wenjian
 */
public interface HttpRequestLine extends StartLine {
    /**
     * 获取请求方法。
     *
     * @return
     */
    HttpMethod getMethod();

    /**
     * 获取URI。
     *
     * @return
     */
    URI getURI();

    @Override
    default String asString() {
        return getMethod().asString() + SEPARATE_CHAR + getURI() + SEPARATE_CHAR + getVersion().asString() + CRLF;
    }

    //-------------------------------------------

    static HttpRequestLine of(final URI uri) {
        return of(HttpMethods.GET, uri);
    }

    static HttpRequestLine of(final HttpMethod method, final URI uri) {
        return of(method, uri, DefaultValues.HTTP_VERSION);
    }

    static HttpRequestLine of(final HttpMethod method, final URI uri, final HttpVersion version) {
        return new HttpRequestLineImpl(method, uri, version);
    }
}
