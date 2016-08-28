package me.magicall.util.net.http.part;

import java.net.HttpCookie;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import me.magicall.util.net.http.part.embeded.CookieValue;
import me.magicall.util.net.http.part.embeded.DefaultValues;

/**
 * http请求的头区域。包括以下部分
 * <pre>结构：
 *     请求行（{@link HttpRequestLine}）
 *     请求头列表（{@link HttpHeaders}）
 * </pre>
 * 参见https://tools.ietf.org/html/rfc2616#section-4
 *
 * @author Liang Wenjian
 */
public interface HttpRequestHeaderArea extends HttpHeaderArea {

    @Override
    HttpRequestLine getStartLine();

    /**
     * 简便方法：获取请求方法。等同于getStartLine().getMethod()。
     *
     * @return
     */
    default HttpMethod getMethod() {
        return getStartLine().getMethod();
    }

    /**
     * 简便方法：获取URI。等同于getStartLine().getURI()
     *
     * @return
     */
    default URI getURI() {
        return getStartLine().getURI();
    }

    /**
     * 简便方法：获取协议版本。等同于getStartLine().getVersion()。
     *
     * @return
     */
    default HttpVersion getVersion() {
        return getStartLine().getVersion();
    }

    /**
     * 简便方法：获取cookie（做为HttpCookie的列表）。
     *
     * @return
     */
    default Collection<HttpCookie> getCookies() {
        getHeaders().stream()//
                .filter(header -> "Cookie".equals(header.getName()))//
                .forEach(header -> header.getValues().stream()//
                        .map(e -> ((CookieValue) e).unwrap())//
                        .collect(Collectors.toList()));
        return Collections.emptyList();
    }

    /**
     * 简便方法：获取User-Agent头信息的值。
     *
     * @return
     */
    default String getUserAgent() {
        return getSingleStringHeaderValue("User-Agent");
    }

    /**
     * 简便方法：获取Referer头信息的值。
     *
     * @return
     */
    default String getReferer() {
        return getSingleStringHeaderValue("Referer");
    }

    //------------------------------------------------

    /**
     * 代表对指定的uri，使用1.1版本的http协议，使用GET的请求。
     *
     * @param uri
     * @return
     */
    static HttpRequestHeaderArea of(final URI uri) {
        return of(DefaultValues.HTTP_METHOD, uri);
    }

    /**
     * 代表对指定的uri，使用1.1版本的http协议，使用指定方法的请求。
     *
     * @param method
     * @param uri
     * @return
     */
    static HttpRequestHeaderArea of(final HttpMethod method, final URI uri) {
        return of(method, uri, DefaultValues.HTTP_VERSION);
    }

    /**
     * 代表对指定的uri，使用指定版本的http协议，使用指定方法的请求。
     *
     * @param method
     * @param uri
     * @param version
     * @return
     */
    static HttpRequestHeaderArea of(final HttpMethod method, final URI uri, final HttpVersion version) {
        return of(method, uri, version, HttpHeaders.empty());
    }

    /**
     * 代表对指定的uri，使用指定版本的http协议，使用指定方法的请求，带有指定的请求头。
     *
     * @param method
     * @param uri
     * @param version
     * @param headers
     * @return
     */
    static HttpRequestHeaderArea of(final HttpMethod method, final URI uri, final HttpVersion version,
                                    final HttpHeaders headers) {
        return new HttpRequestHeaderAreaImpl(method, uri, version, headers);
    }
}
