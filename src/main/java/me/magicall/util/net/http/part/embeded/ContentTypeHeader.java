package me.magicall.util.net.http.part.embeded;

import me.magicall.util.net.http.part.AbsHttpHeader;

/**
 * @author Liang Wenjian
 */
public class ContentTypeHeader extends AbsHttpHeader<ContentTypeValue> {
    public ContentTypeHeader() {
        super();
    }

    @Override
    public String getName() {
        return "Content-Type";
    }
}
