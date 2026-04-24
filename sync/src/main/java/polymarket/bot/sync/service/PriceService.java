package polymarket.bot.sync.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import polymarket.bot.model.Event;
import polymarket.bot.model.EventMarketPrice;
import polymarket.bot.model.Side;
import polymarket.bot.model.repository.EventMarketPriceRepository;
import polymarket.bot.model.repository.EventRepository;
import polymarket.bot.rest.clob.api.model.BPriceDetailRequestDTO;
import polymarket.bot.rest.clob.api.model.BPriceDetailRequestDTO.SideEnum;
import polymarket.bot.rest.clob.api.model.BTokenBestPriceDTO;
import polymarket.bot.rest.clob.service.PriceApiService;
import polymarket.bot.sync.config.EventsConfig;
import polymarket.bot.sync.util.SlugUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PriceService {

    @Resource
    private EventRepository eventRepository;

    @Resource
    private PriceApiService priceApiService;

    @Resource
    private EventMarketPriceRepository eventMarketPriceRepository;

    @Resource
    private EventsConfig eventsConfig;

    // BTC
    @Scheduled(fixedDelay = 1000)
    public void syncBtc5mPrices() {
        if (eventsConfig.isEnabled("btc", "5m"))
            syncPrices(SlugUtil.current5mSlug(SlugUtil.BTC_SLUG_PREFIX));
    }

    private void syncPrices(String slug) {
        try {
            Event event = eventRepository.findBySlug(slug);
            if (event == null) {
                // TODO: warning mesajı ekle
                return;
            }

            String upTokenId = event.getUpTokenId();
            String downTokenId = event.getDownTokenId();

            List<BPriceDetailRequestDTO> request = new ArrayList<BPriceDetailRequestDTO>();
            request.add(new BPriceDetailRequestDTO().side(SideEnum.BUY).tokenId(upTokenId));
            request.add(new BPriceDetailRequestDTO().side(SideEnum.SELL).tokenId(upTokenId));
            request.add(new BPriceDetailRequestDTO().side(SideEnum.BUY).tokenId(downTokenId));
            request.add(new BPriceDetailRequestDTO().side(SideEnum.SELL).tokenId(downTokenId));

            Map<String, BTokenBestPriceDTO> prices = priceApiService.prices(request);
            for (String tokenId : prices.keySet()) {
                BTokenBestPriceDTO tokenBestPrice = prices.get(tokenId);

                Side side = null;
                if (upTokenId.equals(tokenId)) {
                    side = Side.UP;
                } else if (downTokenId.equals(tokenId)) {
                    side = Side.DOWN;
                }

                EventMarketPrice marketPrice = new EventMarketPrice();
                marketPrice.setSlug(slug);
                marketPrice.setCreateDate(LocalDateTime.now());
                marketPrice.setTokenId(tokenId);
                marketPrice.setBuyPrice(tokenBestPrice.getBUY());
                marketPrice.setSellPrice(tokenBestPrice.getSELL());
                marketPrice.setSide(side);
                eventMarketPriceRepository.save(marketPrice);

            }

        } catch (Exception e) {
            log.error("Failed to sync event {}: {}", slug, e.getMessage(), e);
        }
    }

}
