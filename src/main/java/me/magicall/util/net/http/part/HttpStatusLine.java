package me.magicall.util.net.http.part;

import me.magicall.util.net.http.part.embeded.DefaultValues;

/**
 * http响应的起始行。
 * 参见https://tools.ietf.org/html/rfc2616#page-39
 * <pre>结构：
 *     http版本（{@link HttpVersion}） 响应状态（{@link HttpStatus}）
 * </pre>
 *
 * @author Liang Wenjian
 */
public interface HttpStatusLine extends StartLine {

    /**
     * 获取响应码。
     *
     * @return
     */
    HttpStatus getStatus();

    /**
     * 获取原因短语。
     *
     * @return
     */
    default String getReasonPhrase() {
        return getStatus().getReasonPhrase();
    }

    @Override
    default String asString() {
        return getVersion().asString() + SEPARATE_CHAR + getStatus().asString() + CRLF;
    }

    //-------------------------------------

    static HttpStatusLine of(final HttpVersion version, final HttpStatus status) {
        return new HttpStatusLineImpl(version, status);
    }

    static HttpStatusLine of(final HttpStatus status) {
        return of(DefaultValues.HTTP_VERSION, status);
    }

    static HttpStatusLine of(final HttpVersion version) {
        return of(version, DefaultValues.HTTP_STATUS);
    }

    static HttpStatusLine of() {
        return of(DefaultValues.HTTP_STATUS);
    }
}
