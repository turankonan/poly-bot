package polymarket.bot.rest.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import polymarket.bot.rest.FoodicsNetworkApi;
import polymarket.bot.rest.api.MenuDisplayApi;
import polymarket.bot.rest.api.model.BMenuDisplayResponseDTO;

@Slf4j
@Service("foodicsMenuDisplayApiService")
public class MenuDisplayApiService extends BaseService<MenuDisplayApi> {

    @Override
    protected MenuDisplayApi serviceApi() {
        return FoodicsNetworkApi.instance(serviceUrl, connectTimeout, readTimeout).getMenuDisplayApi();
    }

    public BMenuDisplayResponseDTO display() {
        return getResponse(serviceApi().menuDisplayDisplay());
    }

}
