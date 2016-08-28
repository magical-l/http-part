# http-part

一个HTTP请求字符串大致如下：
```
GET /path?queryString=x HTTP/1.1
Host: domain.name
Connection: keep-alive
User-Agent: user-agent-string
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
Accept-Encoding: gzip, deflate, sdch
```
一个HTTP响应字符串大致如下：
```
HTTP/1.1 200 OK
Content-Type: text/html; charset=utf-8
Content-Encoding: gzip
Vary: Accept-Encoding
Date: Sun, 28 Aug 2016 03:38:51 GMT

<html>
  <head></head>
  <body>Hello World!</body>
</html>
```

http-part就是一个用来生成上面两坨字符串的小工具包，不依赖任何servlet之类的api，仅依赖guava。
