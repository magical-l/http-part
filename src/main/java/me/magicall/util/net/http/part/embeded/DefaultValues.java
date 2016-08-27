package me.magicall.util.net.http.part.embeded;

import me.magicall.util.consts.Encodes;
import me.magicall.util.net.http.part.HttpMethod;
import me.magicall.util.net.http.part.HttpStatus;
import me.magicall.util.net.http.part.HttpVersion;

/**
 * 默认值集散地
 *
 * @author Liang Wenjian
 */
public interface DefaultValues {

    Encodes ENCODE = Encodes.UTF8;
    HttpVersion HTTP_VERSION = HttpVersions.HTTP_1_1;
    ContentTypeValues CONTENT_TYPE = ContentTypeValues.JSON;

    HttpMethod HTTP_METHOD = HttpMethods.GET;

    HttpStatus HTTP_STATUS = HttpStatuses.OK;
}
