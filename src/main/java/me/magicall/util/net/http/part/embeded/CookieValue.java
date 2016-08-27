package me.magicall.util.net.http.part.embeded;

import java.net.HttpCookie;
import java.util.Objects;

import me.magicall.util.net.http.part.HttpHeaderValue;

/**
 * 代码来自javax.ws.rs.core.Cookie
 *
 * @author Liang Wenjian
 */
public class CookieValue implements HttpHeaderValue{

    private final HttpCookie httpCookie;

    /**
     * Create a new instance.
     *
     * @param name the name of the cookie
     * @param cookieValue the value of the cookie
     * @throws IllegalArgumentException if name is null
     */
    public CookieValue(final String name, final String cookieValue) {
        httpCookie = new HttpCookie(name, cookieValue);
    }

    public CookieValue(final String name, final String value, final String domain, final String path,
                       final long maxAge) {
        httpCookie = new HttpCookie(name, value);
        httpCookie.setDomain(domain);
        httpCookie.setPath(path);
        httpCookie.setMaxAge(maxAge);
    }

    public CookieValue(final String name, final String value, final String domain, final String path, final long maxAge,
                       final boolean httpOnly, final boolean secure, final int version, final String comment,
                       final String portList, final boolean discard, final String commentURL) {
        httpCookie = new HttpCookie(name, value);
        httpCookie.setDomain(domain);
        httpCookie.setPath(path);
        httpCookie.setMaxAge(maxAge);
        httpCookie.setHttpOnly(httpOnly);
        httpCookie.setSecure(secure);
        httpCookie.setVersion(version);
        httpCookie.setComment(comment);
        httpCookie.setPortlist(portList);
        httpCookie.setDiscard(discard);
        httpCookie.setCommentURL(commentURL);
    }

    public CookieValue(final HttpCookie httpCookie) {
        this.httpCookie = httpCookie;
    }

    /**
     * Get the name of the cookie
     *
     * @return the name
     */
    public String getCookieName() {
        return httpCookie.getName();
    }

    public String getCookieValue() {
        return httpCookie.getValue();
    }

    /**
     * Get the value of the cookie
     *
     * @return the value
     */
    @Override
    public String getValue() {
        return getCookieName() + NAME_VALUE_SEPARATE_CHAR + getCookieValue();
    }

    /**
     * Generate a hashcode by hashing all of the cookies properties
     *
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        final String name = getCookieName();
        final String cookieValue = getCookieValue();
        int hash = 7;
        hash = 97 * hash + (name != null ? name.hashCode() : 0);
        hash = 97 * hash + (cookieValue != null ? cookieValue.hashCode() : 0);
        return hash;
    }

    /**
     * Compare for equality
     *
     * @param obj the object to compare to
     * @return true if the object is a {@code Cookie} with the same value for
     * all properties, false otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CookieValue other = (CookieValue) obj;
        return Objects.equals(getCookieName(), other.getCookieName()) && Objects
                .equals(getCookieValue(), other.getCookieValue());
    }

    public HttpCookie unwrap() {
        return httpCookie;
    }
}
