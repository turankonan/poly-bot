package polymarket.bot.common.interceptor;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

@Slf4j
public class BaseNetworkLoggingInterceptor implements Interceptor {

    private static final Charset UTF8 = StandardCharsets.UTF_8;

    @Override
    public Response intercept(Chain chain) throws IOException {
        long startTime = System.currentTimeMillis();
        Request request = chain.request();

        Map<String, String> headerMap = new HashMap<>();
        Headers headers = request.headers();
        for (String name : headers.names()) {
            headerMap.put(name, headers.get(name));
        }

        String url = request.url().toString();

        Charset charset = UTF8;

        Buffer buffer = new Buffer();
        String requestBodyString = "";
        RequestBody requestBody = request.body();
        if (requestBody != null) {
            requestBody.writeTo(buffer);
            requestBodyString = buffer.readString(charset);
        }

        Date startDate = new Date();
        try {
            Response response = chain.proceed(request);
            Date endDate = new Date();

            Map<String, String> responseHeaderMap = new HashMap<>();
            Headers responseHeaders = response.headers();
            for (String name : responseHeaders.names()) {
                responseHeaderMap.put(name, responseHeaders.get(name));
            }

            ResponseBody responseBody = response.body();
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            buffer = source.buffer();
            String responseBodyString = buffer.clone().readString(charset);

            logRequest(requestBodyString, responseBodyString, url, response.code(), headerMap, responseHeaderMap, startDate, endDate);

            long endTime = System.currentTimeMillis();
            log.info("That took {} milliseconds for {}", (endTime - startTime), url);
            return response;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    private void logRequest(String requestBody, String responseBody, String url, int statusCode, Map<String, String> headerMap, Map<String, String> responseHeaderMap, Date startDate, Date endDate) {
//        headerMap.forEach((key, val) -> log.info("Request Header Name:{}, Value:{}", key, val));
        String path;
        try {
            URL parsedUrl = new URL(url);
            path = parsedUrl.getPath();
        } catch (MalformedURLException e) {
            log.warn("Invalid url format", e);
            path = url;
        }

//        log.debug("Request URL : {}, Post Body : {}, Response Status Code : {}, Response Body : {}", url, requestBody, statusCode, responseBody);
        if (statusCode == 200) {
            log.debug("Request URL : {}, Response Status Code : {}", url, statusCode);
        } else {
            log.debug("Request URL : {}, Post Body : {}, Response Status Code : {}, Response Body : {}", url, requestBody, statusCode, responseBody);
        }

//        responseHeaderMap.forEach((key, val) -> log.info("Response Header Name:{}, Value:{}", key, val));
    }
}
