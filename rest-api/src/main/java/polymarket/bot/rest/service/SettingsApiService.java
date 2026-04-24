package polymarket.bot.rest.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import polymarket.bot.rest.FoodicsNetworkApi;
import polymarket.bot.rest.api.SettingsApi;
import polymarket.bot.rest.api.model.BSettingsResponseDTO;

@Slf4j
@Service("foodicsSettingsApiService")
public class SettingsApiService extends BaseService<SettingsApi> {

    @Override
    protected SettingsApi serviceApi() {
        return FoodicsNetworkApi.instance(serviceUrl, connectTimeout, readTimeout).getSettingsApi();
    }

    public BSettingsResponseDTO settings() {
        return getResponse(serviceApi().settings());
    }

}
