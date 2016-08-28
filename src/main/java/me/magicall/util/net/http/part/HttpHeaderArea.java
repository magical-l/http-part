package me.magicall.util.net.http.part;

/**
 * http头区域。
 * <pre>结构：
 *     起始行（{@link StartLine}）
 *     头信息列表（{@link HttpHeaders}）
 * </pre>
 *
 * @author Liang Wenjian
 */
public interface HttpHeaderArea extends HttpPart {

    /**
     * 获取开始行。
     *
     * @return
     */
    StartLine getStartLine();

    /**
     * 获取头信息列表。
     *
     * @return
     */
    HttpHeaders getHeaders();

    @Override
    default String asString() {
        //第一部分：起始行
        final String startLine = getStartLine().asString();
        final StringBuilder sb = new StringBuilder(startLine);
        if (!startLine.endsWith(CRLF)) {
            sb.append(CRLF);
        }
        //第二部分：头
        final String header = getHeaders().asString();
        if (header != null && !header.trim().isEmpty()) {
            sb.append(header);
            if (!header.endsWith(CRLF)) {
                sb.append(CRLF);
            }
        }
        //第三部分：头和体之间的一行空行。这是算在头区域里的，参见rfc2616
        return sb.append(CRLF).toString();
    }

    default String getSingleStringHeaderValue(final String headerName) {
        final HttpHeaders headers = getHeaders();
        for (final HttpHeader<?> header : headers) {
            if (headerName.equals(header.getName())) {
                final HttpHeaderValues<? extends HttpHeaderValue> values = header.getValues();
                if (values == null || values.isEmpty()) {
                    return "";
                }
                return String.valueOf(values.get(0).getValue());
            }
        }
        return "";
    }
}
