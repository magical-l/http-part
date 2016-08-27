package me.magicall.util.net.http.part;

/**
 * http响应。
 * <pre>响应：
 *     响应头区域（{@link HttpResponseHeaderArea}）
 *     响应体（{@link HttpBody}）
 * </pre>
 * @author Liang Wenjian
 */
public interface HttpResponse extends HttpMessage {
    /**
     * 返回响应头区域。
     *
     * @return
     */
    @Override
    HttpResponseHeaderArea getHeaderArea();

    @Override
    default HttpStatusLine getStartLine() {
        return getHeaderArea().getStartLine();
    }

    default HttpStatus getStatus() {
        return getHeaderArea().getStatus();
    }

    //-----------------------------------------

    static HttpResponse of(final HttpStatus status) {
        return of(status, HttpBody.empty());
    }

    static HttpResponse of(final HttpStatus status, final String bodyContent) {
        return of(status, HttpBody.of(bodyContent));
    }

    static HttpResponse of(final HttpStatus status, final HttpBody body) {
        return of(HttpResponseHeaderArea.of(status), body);
    }

    static HttpResponse of(final HttpResponseHeaderArea headerArea) {
        return of(headerArea, HttpBody.empty());
    }

    static HttpResponse of(final HttpResponseHeaderArea headerArea, final HttpBody body) {
        return new HttpResponseImpl(headerArea, body);
    }
}
