package polymarket.bot.rest.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import polymarket.bot.rest.FoodicsNetworkApi;
import polymarket.bot.rest.api.ModifierApi;
import polymarket.bot.rest.api.model.BModifierDetailResponseDTO;
import polymarket.bot.rest.api.model.BModifierListResponseDTO;

@Slf4j
@Service("foodicsModifierApiService")
public class ModifierApiService extends BaseService<ModifierApi> {

    @Override
    protected ModifierApi serviceApi() {
        return FoodicsNetworkApi.instance(serviceUrl, connectTimeout, readTimeout).getModifierApi();
    }

    public BModifierListResponseDTO list(String sort, Integer page) {
        return getResponse(serviceApi().modifierList(sort, page));
    }

    public BModifierDetailResponseDTO detail(String productId) {
        return getResponse(serviceApi().modifierDetail(productId));
    }

}
