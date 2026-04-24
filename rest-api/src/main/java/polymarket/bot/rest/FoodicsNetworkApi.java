package polymarket.bot.rest;

import java.util.concurrent.TimeUnit;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import polymarket.bot.common.interceptor.BaseNetworkLoggingInterceptor;
import polymarket.bot.common.util.GsonUtil;
import polymarket.bot.rest.interceptor.AuthTokenInterceptor;
import retrofit2.converter.gson.GsonConverterFactory;

@Data
@Slf4j
public class FoodicsNetworkApi {

    private static FoodicsNetworkApi instance;

    private ProductApi productApi;
    private CategoryApi categoryApi;
    private MenuDisplayApi menuDisplayApi;
    private SettingsApi settingsApi;
    private ModifierApi modifierApi;
    private ModifierOptionApi modifierOptionApi;
    private AllergenApi allergenApi;

    public static FoodicsNetworkApi instance(String serviceUrl, Integer connectTimeout, Integer readTimeout) {
        if (instance == null) {
            instance = new FoodicsNetworkApi();
            instance.init(serviceUrl, connectTimeout, readTimeout);
        }

        return instance;
    }

    public void init(String backendServiceUrl, Integer connectTimeout, Integer readTimeout) {
        ApiClient apiClient = prepareApiClient(backendServiceUrl, connectTimeout, readTimeout);

        categoryApi = apiClient.createService(CategoryApi.class);
        productApi = apiClient.createService(ProductApi.class);
        menuDisplayApi = apiClient.createService(MenuDisplayApi.class);
        settingsApi = apiClient.createService(SettingsApi.class);
        modifierApi = apiClient.createService(ModifierApi.class);
        modifierOptionApi = apiClient.createService(ModifierOptionApi.class);
        allergenApi = apiClient.createService(AllergenApi.class);
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
                .addInterceptor(new AuthTokenInterceptor())
                .addInterceptor(new BaseNetworkLoggingInterceptor());

        return apiClient;
    }

}
