package me.magicall.util.net.http.part;

import java.util.Objects;

/**
 * @author Liang Wenjian
 */
public class HttpResponseProxy implements HttpResponse {

    private final HttpResponse raw;

    public HttpResponseProxy(final HttpResponse raw) {
        super();
        this.raw = raw;
    }

    @Override
    public HttpResponseHeaderArea getHeaderArea() {
        return raw.getHeaderArea();
    }

    @Override
    public HttpStatusLine getStartLine() {
        return raw.getStartLine();
    }

    @Override
    public HttpStatus getStatus() {
        return raw.getStatus();
    }

    @Override
    public HttpHeaders getHeaders() {
        return raw.getHeaders();
    }

    @Override
    public HttpBody getBody() {
        return raw.getBody();
    }

    @Override
    public String asString() {
        return raw.asString();
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
        return Objects.equals(asString(), that.asString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(asString());
    }
}
