package me.magicall.util.net.http.part;

import java.util.Objects;

/**
 * HttpStatus的实现类。首推HttpStatuses枚举，如果枚举不够用，可以用本类扩展。
 *
 * @author Liang Wenjian
 */
public class HttpStatusImpl implements HttpStatus {

    private final int statusCode;
    private final String reasonPhrase;
    private final HttpStatusFamily family;

    public HttpStatusImpl(final int statusCode, final String reasonPhrase, final HttpStatusFamily family) {
        this.statusCode = statusCode;
        this.reasonPhrase = reasonPhrase;
        this.family = family;
    }

    @Override
    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String getReasonPhrase() {
        return reasonPhrase;
    }

    @Override
    public HttpStatusFamily getFamily() {
        return family;
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
        if (!(o instanceof HttpStatus)) {
            return false;
        }
        final HttpStatus that = (HttpStatus) o;
        return Objects.equals(getStatusCode(), that.getStatusCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatusCode());
    }
}
