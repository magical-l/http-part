package me.magicall.util.net.http.part;

import java.util.Objects;

/**
 * HttpHeader的抽象实现。
 *
 * @author Liang Wenjian
 */
public abstract class AbsHttpHeader<T extends HttpHeaderValue> implements HttpHeader<T> {

    protected HttpHeaderValues<T> values;

    public AbsHttpHeader(final HttpHeaderValues<T> values) {
        this.values = values;
    }

    public AbsHttpHeader() {
        values = HttpHeaderValues.empty();
    }

    @Override
    public HttpHeaderValues<T> getValues() {
        return values;
    }

    public void setValue(final HttpHeaderValues<T> values) {
        this.values = values;
    }

    @Override
    public HttpHeader<T> addValue(final T value) {
        values.add(value);
        return this;
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
        if (!(o instanceof AbsHttpHeader)) {
            return false;
        }
        final HttpHeader<?> that = (HttpHeader<?>) o;
        return Objects.equals(getValues(), that.getValues());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValues());
    }
}
