package me.magicall.util.net.http.part;

import java.net.URI;
import java.util.Objects;

/**
 * @author Liang Wenjian
 */
public class HttpRequestHeaderAreaImpl implements HttpRequestHeaderArea {
    private HttpRequestLine startLine;
    private HttpHeaders headers;

    public HttpRequestHeaderAreaImpl() {
        super();
    }

    public HttpRequestHeaderAreaImpl(final HttpRequestLine startLine, final HttpHeaders headers) {
        this.startLine = startLine;
        this.headers = headers;
    }

    public HttpRequestHeaderAreaImpl(final HttpMethod method, final URI uri, final HttpVersion version,
                                     final HttpHeaders headers) {
        this(HttpRequestLine.of(method, uri, version), headers);
    }

    @Override
    public HttpRequestLine getStartLine() {
        return startLine;
    }

    @Override
    public HttpHeaders getHeaders() {
        return headers;
    }

    public void setStartLine(final HttpRequestLine startLine) {
        this.startLine = startLine;
    }

    public void setHeaders(final HttpHeaders headers) {
        this.headers = headers;
    }

    @Override
    public String toString() {
        return asString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HttpRequestHeaderArea)) {
            return false;
        }
        final HttpRequestHeaderArea that = (HttpRequestHeaderArea) o;
        return Objects.equals(getStartLine(), that.getStartLine()) && Objects.equals(getHeaders(), that.getHeaders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStartLine(), getHeaders());
    }
}
