package me.magicall.util.net.http.part;

/**
 * 一类型http头。
 * <pre>结构：
 *     头信息名字（{@link String}）: 头信息值1（{@link HttpHeaderValue}）, 头信息值2, ……
 * </pre>
 *
 * @author Liang Wenjian
 */
public interface HttpHeader<T extends HttpHeaderValue> extends HttpPart {

    /**
     * 头和值之间的分隔符（char）
     */
    char NAME_VALUE_SEPARATE_CHAR = ':';
    /**
     * 头和值之间的分隔符（String）
     */
    String NAME_VALUE_SEPARATOR = String.valueOf(NAME_VALUE_SEPARATE_CHAR);

    String getName();

    /**
     * 获取值列表。
     *
     * @return
     */
    HttpHeaderValues<T> getValues();

    /**
     * 加一个值。
     *
     * @param value
     */
    HttpHeader<T> addValue(T value);

    /**
     * 这种头是否允许多值。
     *
     * @return
     */
    default boolean allowMultiValue() {
        return true;
    }

    /**
     * 将头信息格式化为字符串。
     *
     * @return
     */
    @Override
    default String asString() {
        return getName() + NAME_VALUE_SEPARATE_CHAR + getValues().asString();
    }
}
