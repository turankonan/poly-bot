package polymarket.bot.rest.clob;

import java.util.concurrent.TimeUnit;

import polymarket.bot.common.interceptor.BaseNetworkLoggingInterceptor;
import polymarket.bot.common.util.GsonUtil;
import polymarket.bot.rest.clob.api.BookApi;
import polymarket.bot.rest.clob.api.PriceApi;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import retrofit2.converter.gson.GsonConverterFactory;

@Data
@Slf4j
public class NetworkApi {

    private static NetworkApi instance;

    private PriceApi priceApi;
    private BookApi bookApi;

    public static NetworkApi instance(String serviceUrl, Integer connectTimeout, Integer readTimeout) {
        if (instance == null) {
            instance = new NetworkApi();
            instance.init(serviceUrl, connectTimeout, readTimeout);
        }

        return instance;
    }

    public void init(String backendServiceUrl, Integer connectTimeout, Integer readTimeout) {
        ApiClient apiClient = prepareApiClient(backendServiceUrl, connectTimeout, readTimeout);

        priceApi = apiClient.createService(PriceApi.class);
        bookApi = apiClient.createService(BookApi.class);
    }

    private ApiClient prepareApiClient(String url, Integer connectTimeout, Integer readTimeout) {
        ApiClient apiClient = new ApiClient();

        apiClient.getAdapterBuilder().converterFactories().clear();

        apiClient.getOkBuilder()
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS);

        apiClient.getAdapterBuilder()
                .addConverterFactory(GsonConverterFactory.create(GsonUtil.getGson()))
                .baseUrl(url);

        apiClient.getOkBuilder()
                .addInterceptor(new BaseNetworkLoggingInterceptor());

        return apiClient;
    }

}
