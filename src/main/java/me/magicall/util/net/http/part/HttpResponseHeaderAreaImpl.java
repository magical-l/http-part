package me.magicall.util.net.http.part;

import java.util.Objects;

/**
 * @author Liang Wenjian
 */
public class HttpResponseHeaderAreaImpl implements HttpResponseHeaderArea {
    private HttpStatusLine startLine;
    private HttpHeaders headers;

    public HttpResponseHeaderAreaImpl() {
        super();
    }

    public HttpResponseHeaderAreaImpl(final HttpStatusLine startLine, final HttpHeaders headers) {
        this.startLine = startLine;
        this.headers = headers;
    }

    @Override
    public HttpStatusLine getStartLine() {
        return startLine;
    }

    @Override
    public HttpHeaders getHeaders() {
        return headers;
    }

    public void setStartLine(final HttpStatusLine startLine) {
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
        if (!(o instanceof HttpResponseHeaderArea)) {
            return false;
        }
        final HttpResponseHeaderArea that = (HttpResponseHeaderArea) o;
        return Objects.equals(getStartLine(), that.getStartLine()) && Objects.equals(getHeaders(), that.getHeaders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStartLine(), getHeaders());
    }
}
