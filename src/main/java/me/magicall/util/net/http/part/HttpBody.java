package me.magicall.util.net.http.part;

/**
 * http体。
 *
 * @author Liang Wenjian
 */
@FunctionalInterface
public interface HttpBody extends HttpPart {

    //----------------------------------------

    static HttpBody empty() {
        return of("");
    }

    static HttpBody of(final String content) {
        return new HttpBodyImpl(content);
    }
}
