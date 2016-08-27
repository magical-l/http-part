package me.magicall.util.net.http.part.embeded;

import me.magicall.util.net.http.part.HttpMethod;

/**
 * 规范中声明的、被广泛使用的http方法，作为内置的请求方法。
 *
 * @author Liang Wenjian
 */
public enum HttpMethods implements HttpMethod {
    GET,
    POST {
        @Override
        public boolean isIdempotent() {
            return false;
        }
    },
    PUT,
    DELETE,
    HEAD,
    OPTIONS,
    CONNECT,
    TRACE,
    PATCH;

    @Override
    public String getName() {
        return name();
    }
}
