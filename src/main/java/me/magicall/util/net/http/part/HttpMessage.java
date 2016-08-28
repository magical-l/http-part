package me.magicall.util.net.http.part;

/**
 * http消息。http请求和http响应分别是两种不同的http消息。
 *
 * @author Liang Wenjian
 */
public interface HttpMessage extends HttpPart {

    /**
     * 获取头区域。
     *
     * @return
     */
    HttpHeaderArea getHeaderArea();

    default StartLine getStartLine(){
        return getHeaderArea().getStartLine();
    }

    default HttpHeaders getHeaders(){
        return getHeaderArea().getHeaders();
    }

    /**
     * 获取体。
     *
     * @return
     */
    HttpBody getBody();

    @Override
    default String asString() {
        final String head = getHeaderArea().asString();
        final StringBuilder sb = new StringBuilder(head);
        if (head.endsWith(CRLF)) {
            if (!head.endsWith(CRLF + CRLF)) {
                sb.append(CRLF);
            }
        } else {
            sb.append(CRLF).append(CRLF);
        }
        return sb.append(getBody().asString()).toString();
    }
}
