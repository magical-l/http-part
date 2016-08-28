package me.magicall.util.net.http.part;

import java.util.Objects;

/**
 * 首推使用HttpMethods枚举，如果不够用，可以用本类来扩展http方法。
 *
 * @author Liang Wenjian
 */
public class HttpMethodImpl implements HttpMethod {

    private final String name;
    private final boolean idempotent;

    public HttpMethodImpl(final String name) {
        this(name, true);
    }

    public HttpMethodImpl(final String name, final boolean idempotent) {
        super();
        this.name = name;
        this.idempotent = idempotent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isIdempotent() {
        return idempotent;
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
        if (!(o instanceof HttpMethod)) {
            return false;
        }
        final HttpMethod that = (HttpMethod) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
