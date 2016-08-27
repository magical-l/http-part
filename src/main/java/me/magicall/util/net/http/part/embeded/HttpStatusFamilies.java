package me.magicall.util.net.http.part.embeded;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;
import me.magicall.util.net.http.part.HttpStatusFamily;

/**
 * 部分代码源于javax.ws.rs.core.Response.Status.Family。
 *
 * @author Liang Wenjian
 */
public enum HttpStatusFamilies implements HttpStatusFamily {

    /**
     * {@code 1xx} HTTP status codes.
     */
    INFORMATIONAL(1),
    /**
     * {@code 2xx} HTTP status codes.
     */
    SUCCESSFUL(2),
    /**
     * {@code 3xx} HTTP status codes.
     */
    REDIRECTION(3),
    /**
     * {@code 4xx} HTTP status codes.
     */
    CLIENT_ERROR(4),
    /**
     * {@code 5xx} HTTP status codes.
     */
    SERVER_ERROR(5);

    private final Range<Integer> range;

    HttpStatusFamilies(final int i) {
        final int lower = i * 100;
        range = Range.range(lower, BoundType.CLOSED, lower + 99, BoundType.CLOSED);
    }

    @Override
    public Range<Integer> getRange() {
        return range;
    }

    /**
     * Get the response status family for the status code.
     *
     * @param statusCode response status code to get the family for.
     * @return family of the response status code.
     */
    public static HttpStatusFamilies of(final int statusCode) {
        switch (statusCode / 100) {
            case 1:
                return INFORMATIONAL;
            case 2:
                return SUCCESSFUL;
            case 3:
                return REDIRECTION;
            case 4:
                return CLIENT_ERROR;
            case 5:
                return SERVER_ERROR;
            default:
                return null;
        }
    }
}
