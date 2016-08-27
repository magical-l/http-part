package me.magicall.util.net.http.part;

import com.google.common.collect.Range;

/**
 * http响应状态的家族。
 *
 * @author Liang Wenjian
 */
@FunctionalInterface
public interface HttpStatusFamily {

    /**
     * 是否包含指定的http响应状态。
     *
     * @param status
     * @return
     */
    default boolean contains(final HttpStatus status) {
        return contains(status.getStatusCode());
    }

    /**
     * 是否包含指定的http响应状态。
     *
     * @param statusCode
     * @return
     */
    default boolean contains(final int statusCode) {
        return getRange().contains(statusCode);
    }

    /**
     * 获取范围。
     *
     * @return
     */
    Range<Integer> getRange();
}
