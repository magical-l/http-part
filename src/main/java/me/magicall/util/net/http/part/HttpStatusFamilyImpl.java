package me.magicall.util.net.http.part;

import java.util.Objects;

import com.google.common.collect.Range;

/**
 * HttpStatusFamily接口的实现类。
 * 首推使用HttpStatusFamilies枚举，如果枚举不够用，可以用本类来扩展。
 *
 * @author Liang Wenjian
 */
public class HttpStatusFamilyImpl implements HttpStatusFamily {

    private final Range<Integer> range;

    public HttpStatusFamilyImpl(final Range<Integer> range) {
        super();
        this.range = range;
    }

    @Override
    public Range<Integer> getRange() {
        return range;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + hashCode() + ":{" +
                "range:" + range +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HttpStatusFamily)) {
            return false;
        }
        final HttpStatusFamily that = (HttpStatusFamily) o;
        return Objects.equals(getRange(), that.getRange());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRange());
    }
}
