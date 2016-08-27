package me.magicall.util.net.http.part;

import java.util.Objects;

/**
 * HttpBody接口的简易实现。
 *
 * @author Liang Wenjian
 */
public class HttpBodyImpl implements HttpBody {

    private String content;

    public HttpBodyImpl(final String content) {
        this.content = content;
    }

    public HttpBodyImpl() {
        super();
    }

    @Override
    public String asString() {
        return content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
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
        if (!(o instanceof HttpBody)) {
            return false;
        }
        final HttpBody httpBody = (HttpBody) o;
        return Objects.equals(asString(), httpBody.asString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContent());
    }
}
