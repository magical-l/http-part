package me.magicall.util.net.http.part;

import java.util.Objects;

/**
 * @author Liang Wenjian
 */
public class HttpHeaderValueImpl implements HttpHeaderValue {

    private final Object value;

    public HttpHeaderValueImpl(final Object value) {
        this.value = value;
    }

    @Override
    public Object getValue() {
        return value;
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
        if (!(o instanceof HttpHeaderValue)) {
            return false;
        }
        final HttpHeaderValue that = (HttpHeaderValue) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
