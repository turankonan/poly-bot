package polymarket.bot.rest.gamma.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;

import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;

@Slf4j
public abstract class BaseService<A> {

    @Value("${polymarket.api.url.gamma}")
    protected String serviceUrl;

    @Value("${polymarket.api.connectTimeout:30}")
    protected Integer connectTimeout;

    @Value("${polymarket.api.readTimeout:30}")
    protected Integer readTimeout;

    protected abstract A serviceApi();

    protected <T> T getResponse(Call<T> service) {
        try {
            Response<?> response = service.execute();

            if (response.isSuccessful()) {
                return (T) response.body();
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
