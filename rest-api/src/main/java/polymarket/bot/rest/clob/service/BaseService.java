package polymarket.bot.rest.clob.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;

import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;

@Slf4j
public abstract class BaseService<A> {

    @Value("${polymarket.clob.api.url}")
    protected String serviceUrl;

    @Value("${polymarket.clob.api.connectTimeout:30}")
    protected Integer connectTimeout;

    @Value("${polymarket.clob.api.readTimeout:30}")
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
