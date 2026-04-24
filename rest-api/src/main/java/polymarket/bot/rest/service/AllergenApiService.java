package polymarket.bot.rest.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import polymarket.bot.rest.FoodicsNetworkApi;
import polymarket.bot.rest.api.AllergenApi;
import polymarket.bot.rest.api.model.BAllergenListResponseDTO;

@Slf4j
@Service("foodicsAllergenApiService")
public class AllergenApiService extends BaseService<AllergenApi> {

    @Override
    protected AllergenApi serviceApi() {
        return FoodicsNetworkApi.instance(serviceUrl, connectTimeout, readTimeout).getAllergenApi();
    }

    public BAllergenListResponseDTO list(String sort, Integer page) {
        return getResponse(serviceApi().allergenList(sort, page));
    }

}
