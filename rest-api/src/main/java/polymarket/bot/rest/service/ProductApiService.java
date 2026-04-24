package polymarket.bot.rest.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import polymarket.bot.rest.FoodicsNetworkApi;
import polymarket.bot.rest.api.ProductApi;
import polymarket.bot.rest.api.model.BProductDetailResponseDTO;
import polymarket.bot.rest.api.model.BProductListResponseDTO;

@Slf4j
@Service("foodicsProductApiService")
public class ProductApiService extends BaseService<ProductApi> {

    @Override
    protected ProductApi serviceApi() {
        return FoodicsNetworkApi.instance(serviceUrl, connectTimeout, readTimeout).getProductApi();
    }

    public BProductListResponseDTO list(String sort, Integer page) {
        return getResponse(serviceApi().productList(sort, page));
    }

    public BProductDetailResponseDTO detail(String productId) {
        return getResponse(serviceApi().productDetail(productId));
    }

}
