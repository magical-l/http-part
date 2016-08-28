package me.magicall.util.net.http.part.embeded;

import me.magicall.util.net.http.part.HttpVersion;

/**
 * HTTP协议版本。
 *
 * @author Liang Wenjian
 */
public enum HttpVersions implements HttpVersion {
    HTTP_0_9(0, 9),
    HTTP_1_0(1, 0),
    HTTP_1_1(1, 1);

    private final int major;
    private final int minor;

    HttpVersions(final int major, final int minor) {
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

}
