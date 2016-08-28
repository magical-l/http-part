package me.magicall.util.net.http.part;

import java.util.Objects;

/**
 * HttpVersion的实现类。首推HttpVersions枚举，如果枚举值不够用，可以用本类扩展。
 *
 * @author Liang Wenjian
 */
public class HttpVersionImpl implements HttpVersion {

    private final int major;
    private final int minor;

    public HttpVersionImpl(final int major, final int minor) {
        this.major = major;
        this.minor = minor;
    }

    @Override
    public int getMajor() {
        return major;
    }

    @Override
    public int getMinor() {
        return minor;
    }

    public String toString() {
        return asString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HttpVersion)) {
            return false;
        }
        final HttpVersion that = (HttpVersion) o;
        return Objects.equals(getMajor(), that.getMajor()) && Objects.equals(getMinor(), that.getMinor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMajor(), getMinor());
    }
}
