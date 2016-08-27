package me.magicall.util.net.http.part;

import java.util.Objects;

/**
 * @author Liang Wenjian
 */
public class HttpStatusLineImpl implements HttpStatusLine {

    private HttpVersion version;
    private HttpStatus status;

    public HttpStatusLineImpl(final HttpVersion version, final HttpStatus status) {
        this.version = version;
        this.status = status;
    }

    public HttpStatusLineImpl() {
        super();
    }

    public void setVersion(final HttpVersion version) {
        this.version = version;
    }

    public void setStatus(final HttpStatus status) {
        this.status = status;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
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
        if (!(o instanceof HttpStatusLine)) {
            return false;
        }
        final HttpStatusLine that = (HttpStatusLine) o;
        return Objects.equals(getVersion(), that.getVersion()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVersion(), getStatus());
    }
}
