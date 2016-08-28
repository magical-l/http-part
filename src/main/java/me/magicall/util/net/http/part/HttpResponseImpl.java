package me.magicall.util.net.http.part;

import java.util.Objects;

/**
 * @author Liang Wenjian
 */
public class HttpResponseImpl implements HttpResponse {

    private HttpResponseHeaderArea headerArea;
    private HttpBody body;

    public HttpResponseImpl(final HttpResponseHeaderArea headerArea, final HttpBody body) {
        this.headerArea = headerArea;
        this.body = body;
    }

    public HttpResponseImpl() {
        super();
    }

    @Override
    public HttpResponseHeaderArea getHeaderArea() {
        return headerArea;
    }

    @Override
    public HttpBody getBody() {
        return body;
    }

    public void setHeaderArea(final HttpResponseHeaderArea headerArea) {
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
        if (!(o instanceof HttpResponse)) {
            return false;
        }
        final HttpResponse that = (HttpResponse) o;
        return Objects.equals(getHeaderArea(), that.getHeaderArea()) && Objects.equals(getBody(), that.getBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeaderArea(), getBody());
    }
}
