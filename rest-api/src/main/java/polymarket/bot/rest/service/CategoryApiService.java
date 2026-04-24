package polymarket.bot.rest.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import polymarket.bot.rest.FoodicsNetworkApi;
import polymarket.bot.rest.api.CategoryApi;
import polymarket.bot.rest.api.model.BCategoryListResponseDTO;

@Slf4j
@Service("foodicsCategoryApiService")
public class CategoryApiService extends BaseService<CategoryApi> {

    @Override
    protected CategoryApi serviceApi() {
        return FoodicsNetworkApi.instance(serviceUrl, connectTimeout, readTimeout).getCategoryApi();
    }

    public BCategoryListResponseDTO list(String sort, Integer page) {
        return getResponse(serviceApi().categoryList(sort, page));
    }

}
