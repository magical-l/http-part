package me.magicall.util.net.http.part.embeded;

/**
 * @author Liang Wenjian
 */
public enum ContentTypeValues implements ContentTypeValue {
    TEXT("text", "plain"),
    XML("application", "xml"),
    JSON("application", "json"),
    ;

    private final String major;
    private final String minor;

    ContentTypeValues(final String major, final String minor) {
        this.major = major;
        this.minor = minor;
    }

    @Override
    public String getMajor() {
        return major;
    }

    @Override
    public String getMinor() {
        return minor;
    }
}
