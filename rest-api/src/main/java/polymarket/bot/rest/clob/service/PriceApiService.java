package polymarket.bot.rest.clob.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import polymarket.bot.rest.clob.NetworkApi;
import polymarket.bot.rest.clob.api.PriceApi;
import polymarket.bot.rest.clob.api.model.BPriceDetailRequestDTO;
import polymarket.bot.rest.clob.api.model.BTokenBestPriceDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("priceApiService")
public class PriceApiService extends BaseService<PriceApi> {

    @Override
    protected PriceApi serviceApi() {
        return NetworkApi.instance(serviceUrl, connectTimeout, readTimeout).getPriceApi();
    }

    public Map<String, BTokenBestPriceDTO> prices(List<BPriceDetailRequestDTO> priceDetailsRequest) {
        return getResponse(serviceApi().priceDetail(priceDetailsRequest));
    }

}
