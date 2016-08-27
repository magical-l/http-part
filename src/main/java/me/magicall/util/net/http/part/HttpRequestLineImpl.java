package me.magicall.util.net.http.part;

import java.net.URI;
import java.util.Objects;

/**
 * @author Liang Wenjian
 */
public class HttpRequestLineImpl implements HttpRequestLine {

    private HttpMethod method;
    private URI uri;
    private HttpVersion version;

    public HttpRequestLineImpl(final HttpMethod method, final URI uri, final HttpVersion version) {
        this.method = method;
        this.uri = uri;
        this.version = version;
    }

    public HttpRequestLineImpl() {
        super();
    }

    @Override
    public HttpMethod getMethod() {
        return method;
    }

    @Override
    public URI getURI() {
        return uri;
    }

    @Override
    public HttpVersion getVersion() {
        return version;
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
        if (!(o instanceof HttpRequestLine)) {
            return false;
        }
        final HttpRequestLine that = (HttpRequestLine) o;
        return Objects.equals(getMethod(), that.getMethod()) &&
                Objects.equals(uri, that.getURI()) &&
                Objects.equals(getVersion(), that.getVersion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMethod(), getURI(), getVersion());
    }
}
