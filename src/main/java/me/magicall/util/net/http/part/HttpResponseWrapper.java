package me.magicall.util.net.http.part;

import java.util.Objects;

/**
 * @author Liang Wenjian
 */
public class HttpResponseWrapper implements HttpResponse {

    private final HttpResponse raw;

    public HttpResponseWrapper(final HttpResponse raw) {
        super();
        this.raw = raw;
    }

    @Override
    public HttpResponseHeaderArea getHeaderArea() {
        return raw.getHeaderArea();
    }

    @Override
    public HttpBody getBody() {
        return raw.getBody();
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
        return Objects.equals(asString(),that.asString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(asString());
    }
}
