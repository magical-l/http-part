package me.magicall.util.net.http.part.embeded;

import me.magicall.util.net.http.part.AbsHttpHeader;

/**
 * @author Liang Wenjian
 */
public class AcceptLanguageHeader extends AbsHttpHeader<AcceptLanguageValue> {
    public AcceptLanguageHeader() {
        super();
    }

    @Override
    public String getName() {
        return "Accept-Language";
    }
}
