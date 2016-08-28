package me.magicall.util.net.http.part;

import me.magicall.util.net.http.part.embeded.HttpStatusFamilies;

/**
 * http响应状态。
 * <pre>结构：
 *     状态码（int） 原因短语（{@link String}）
 * </pre>
 * @author Liang Wenjian
 */
public interface HttpStatus extends HttpPart {

    char SEPARATE_CHAR = ' ';
    String SEPARATOR = String.valueOf(SEPARATE_CHAR);

    /**
     * 获取响应码。
     *
     * @return
     */
    int getStatusCode();

    /**
     * 获取状态短语。
     *
     * @return
     */
    String getReasonPhrase();

    /**
     * 获取响应状态家族。
     *
     * @return
     */
    default HttpStatusFamily getFamily() {
        return HttpStatusFamilies.of(getStatusCode());
    }

    @Override
    default String asString() {
        return getStatusCode() + SEPARATOR + getReasonPhrase();
    }
}
