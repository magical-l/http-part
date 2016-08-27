package me.magicall.util.net.http.part.embeded;

import me.magicall.util.net.http.part.AbsHttpHeader;

/**
 * @author Liang Wenjian
 */
public class CookieHeader extends AbsHttpHeader<CookieValue> {
    public CookieHeader() {
        super();
    }

    @Override
    public String getName() {
        return "Cookie";
    }
}
