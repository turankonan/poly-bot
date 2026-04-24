package polymarket.bot.rest.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import polymarket.bot.rest.FoodicsNetworkApi;
import polymarket.bot.rest.api.ModifierOptionApi;
import polymarket.bot.rest.api.model.BModifierOptionDetailResponseDTO;
import polymarket.bot.rest.api.model.BModifierOptionListResponseDTO;

@Slf4j
@Service("foodicsModifierOptionApiService")
public class ModifierOptionApiService extends BaseService<ModifierOptionApi> {

    @Override
    protected ModifierOptionApi serviceApi() {
        return FoodicsNetworkApi.instance(serviceUrl, connectTimeout, readTimeout).getModifierOptionApi();
    }

    public BModifierOptionListResponseDTO list(String sort, Integer page) {
        return getResponse(serviceApi().modifierOptionList(sort, page));
    }

    public BModifierOptionDetailResponseDTO detail(String productId) {
        return getResponse(serviceApi().modifierOptionDetail(productId));
    }

}
