package polymarket.bot.rest.interceptor;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import polymarket.bot.rest.context.FoodicsContext;

@Slf4j
public class AuthTokenInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();

        FoodicsContext context = FoodicsContext.safeGet();
        Request authenticatedRequest = originalRequest.newBuilder()
                .header("Authorization", "Bearer " + context.getAccessToken())
                .build();

        return chain.proceed(authenticatedRequest);
    }
}
