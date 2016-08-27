package me.magicall.util.net.http.part;

import java.net.HttpCookie;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import me.magicall.util.net.http.part.embeded.CookieValue;

/**
 * 响应头区域。
 * <pre>结构：
 *     起始行（{@link StartLine}）
 *     响应头列表（{@link HttpHeaders}）
 * </pre>
 *
 * @author Liang Wenjian
 */
public interface HttpResponseHeaderArea extends HttpHeaderArea {

    @Override
    HttpStatusLine getStartLine();

    /**
     * 简便方法：获取响应状态。等同于getStartLine().getStatus()。
     *
     * @return
     */
    default HttpStatus getStatus() {
        return getStartLine().getStatus();
    }

    /**
     * 简便方法：获取状态码。等同于getStartLine().getStatus().getStatusCode()。
     *
     * @return
     */
    default int getStatusCode() {
        return getStatus().getStatusCode();
    }

    /**
     * 简便方法：获取Set-Cookie头的值（做为HttpCookie实例列表）。
     *
     * @return
     */
    default Collection<HttpCookie> getSetCookies() {
        getHeaders().stream()//
                .filter(header -> "Set-Cookie".equals(header.getName()))//
                .forEach(header -> header.getValues().stream()//
                        .map(e -> ((CookieValue) e).unwrap())//
                        .collect(Collectors.toList()));
        return Collections.emptyList();
    }

    //-----------------------------------

    static HttpResponseHeaderArea of(final HttpStatus httpStatus) {
        return of(httpStatus, new HttpHeadersImpl());
    }

    static HttpResponseHeaderArea of(final HttpStatus httpStatus, final HttpHeaders headers) {
        return of(HttpStatusLine.of(httpStatus), headers);
    }

    static HttpResponseHeaderArea of(final HttpStatusLine startLine, final HttpHeaders headers) {
        return new HttpResponseHeaderAreaImpl(startLine, headers);
    }
}
