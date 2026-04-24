package polymarket.bot.rest.gamma.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import polymarket.bot.rest.gamma.NetworkApi;
import polymarket.bot.rest.gamma.api.EventApi;
import polymarket.bot.rest.gamma.api.model.BEventDetailDTO;

@Slf4j
@Service("eventApiService")
public class EventApiService extends BaseService<EventApi> {

    @Override
    protected EventApi serviceApi() {
        return NetworkApi.instance(serviceUrl, connectTimeout, readTimeout).getEventApi();
    }

    public BEventDetailDTO list(String slug) {
        return getResponse(serviceApi().eventDetail(slug));
    }

}
