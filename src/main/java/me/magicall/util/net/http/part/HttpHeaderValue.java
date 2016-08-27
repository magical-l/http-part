package me.magicall.util.net.http.part;

import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 头信息的一个值。
 * <pre>
 * 头信息值;属性1=属性值1;属性2=属性值2;……
 * </pre>
 *
 * @author Liang Wenjian
 */
@FunctionalInterface
public interface HttpHeaderValue extends HttpPart {

    /**
     * 获取值对象。
     *
     * @return
     */
    Object getValue();

    /**
     * 获取头信息值的属性值。
     *
     * @return
     */
    default Map<String, Object> getAttrs() {
        return Collections.emptyMap();
    }

    @Override
    default String asString() {
        final String value = formatValue(getValue());
        final Map<String, Object> attrs = getAttrs();
        if (attrs == null || attrs.isEmpty()) {
            return value;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(value).append(ATTR_SEPARATE_CHAR);
        for (final Entry<String, Object> entry : attrs.entrySet()) {
            sb.append(entry.getKey()).append(NAME_VALUE_SEPARATE_CHAR).append(formatValue(entry.getValue()));
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    //-------------------------------------------------

    /**
     * 头信息值也可以是一种映射（name=value）的形式，比如cookie。本字符即name和value间，以及属性值的name和value间的分隔符。
     */
    char NAME_VALUE_SEPARATE_CHAR = '=';
    /**
     * 头信息值也可以是一种映射（name=value）的形式，比如cookie。本字符即name和value间，以及属性值的name和value间的分隔符。
     */
    String NAME_VALUE_SEPARATOR = String.valueOf(NAME_VALUE_SEPARATE_CHAR);

    /**
     * 属性和属性间的分隔符。
     */
    char ATTR_SEPARATE_CHAR = ';';
    /**
     * 属性和属性间的分隔符。
     */
    String ATTR_SEPARATOR = String.valueOf(ATTR_SEPARATE_CHAR);

    static String formatValue(final Object o) {
        if (o == null) {
            return "";
        }
        if (o instanceof Date) {
            //TODO : 怎么处理date呢
        }
        return o.toString();
    }

    static HttpHeaderValue of(final Object value) {
        return new HttpHeaderValueImpl(value);
    }
}
