package me.magicall.util.net.http.part;

/**
 * http请求方法。
 * <pre>结构：
 *     方法名（{@link String}）
 * </pre>
 *
 * @author Liang Wenjian
 */
@FunctionalInterface
public interface HttpMethod extends HttpPart {

    String getName();
    /**
     * 是否幂等。
     *
     * @return
     */
    default boolean isIdempotent() {
        return true;
    }

    @Override
    default String asString() {
        return getName();
    }
}
