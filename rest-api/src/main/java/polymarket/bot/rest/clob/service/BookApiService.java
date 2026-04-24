package polymarket.bot.rest.clob.service;

import java.util.List;

import org.springframework.stereotype.Service;

import polymarket.bot.rest.clob.NetworkApi;
import polymarket.bot.rest.clob.api.BookApi;
import polymarket.bot.rest.clob.api.model.BBookDetailDTO;
import polymarket.bot.rest.clob.api.model.BBookDetailRequestDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("bookApiService")
public class BookApiService extends BaseService<BookApi> {

    @Override
    protected BookApi serviceApi() {
        return NetworkApi.instance(serviceUrl, connectTimeout, readTimeout).getBookApi();
    }

    public List<BBookDetailDTO> detail(List<BBookDetailRequestDTO> bookDetailsRequest) {
        return getResponse(serviceApi().bookDetail(bookDetailsRequest));
    }

}
