package me.magicall.util.net.http.part.embeded;

import me.magicall.util.net.http.part.HttpHeaderValue;

/**
 * @author Liang Wenjian
 */
public interface ContentTypeValue extends HttpHeaderValue {

    char SEPARATE_CHAR = '/';
    String SEPARATOR = String.valueOf(SEPARATE_CHAR);

    /**
     * 获取主要类型。
     *
     * @return
     */
    String getMajor();

    /**
     * 获取次要类型。
     *
     * @return
     */
    String getMinor();

    @Override
    default Object getValue() {
        return getMajor() + SEPARATE_CHAR + getMinor();
    }
}
