package me.magicall.util.net.http.part;

import java.util.Objects;

/**
 * @author Liang Wenjian
 */
public class HttpRequestImpl implements HttpRequest {

    private HttpRequestHeaderArea headerArea;
    private HttpBody body;

    public HttpRequestImpl(final HttpRequestHeaderArea headerArea, final HttpBody body) {
        this.headerArea = headerArea;
        this.body = body;
    }

    public HttpRequestImpl() {
        super();
    }

    @Override
    public HttpRequestHeaderArea getHeaderArea() {
        return headerArea;
    }

    @Override
    public HttpBody getBody() {
        return body;
    }

    public void setHeaderArea(final HttpRequestHeaderArea headerArea) {
        this.headerArea = headerArea;
    }

    public void setBody(final HttpBody body) {
        this.body = body;
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
        if (!(o instanceof HttpRequest)) {
            return false;
        }
        final HttpRequest that = (HttpRequest) o;
        return Objects.equals(getHeaderArea(), that.getHeaderArea()) && Objects.equals(getBody(), that.getBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeaderArea(), getBody());
    }
}
