package me.magicall.util.net.http.part;

import java.net.HttpCookie;
import java.net.URI;
import java.util.Collection;

/**
 * http请求。
 * <pre>结构：
 *     请求头区域（{@link HttpRequestHeaderArea}）
 *     空行（CRLF）
 *     请求体（{@link HttpBody}）
 * </pre>
 *
 * @author Liang Wenjian
 */
public interface HttpRequest extends HttpMessage {

    /**
     * 获取请求头区域。
     *
     * @return
     */
    @Override
    HttpRequestHeaderArea getHeaderArea();

    /**
     * 获取开始行。
     *
     * @return
     */
    @Override
    default HttpRequestLine getStartLine() {
        return getHeaderArea().getStartLine();
    }

    /**
     * 获取请求方法。
     *
     * @return
     */
    default HttpMethod getMethod() {
        return getHeaderArea().getMethod();
    }

    /**
     * 获取请求uri。
     *
     * @return
     */
    default URI getURI() {
        return getHeaderArea().getURI();
    }

    /**
     * 获取协议版本。
     *
     * @return
     */
    default HttpVersion getVersion() {
        return getHeaderArea().getVersion();
    }

    default String getUserAgent() {
        return getHeaderArea().getUserAgent();
    }

    default String getReferer() {
        return getHeaderArea().getReferer();
    }

    default Collection<HttpCookie> getCookies() {
        return getHeaderArea().getCookies();
    }

    default String getSingleStringHeaderValue(final String headerName) {
        return getHeaderArea().getSingleStringHeaderValue(headerName);
    }

    //--------------------------------------------

    static HttpRequest of(final URI uri) {
        return of(HttpRequestHeaderArea.of(uri));
    }

    static HttpRequest of(final HttpMethod method, final URI uri) {
        return of(HttpRequestHeaderArea.of(method, uri));
    }

    static HttpRequest of(final HttpMethod method, final URI uri, final HttpVersion httpVersion) {
        return of(HttpRequestHeaderArea.of(method, uri, httpVersion));
    }

    static HttpRequest of(final HttpMethod method, final URI uri, final HttpVersion httpVersion, final HttpBody body) {
        return of(HttpRequestHeaderArea.of(method, uri, httpVersion), body);
    }

    static HttpRequest of(final HttpRequestHeaderArea headerArea) {
        return of(headerArea, HttpBody.empty());
    }

    static HttpRequest of(final HttpRequestHeaderArea headerArea, final HttpBody body) {
        return new HttpRequestImpl(headerArea, body);
    }

}
