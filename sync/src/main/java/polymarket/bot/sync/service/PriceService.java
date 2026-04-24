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
        if (eventsConfig.isEnabled("btc", "5m")) {
            syncPrices(SlugUtil.current5mSlug(SlugUtil.BTC_SLUG_PREFIX));
            syncPrices(SlugUtil.next5mSlug(SlugUtil.BTC_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncBtc15mPrices() {
        if (eventsConfig.isEnabled("btc", "15m")) {
            syncPrices(SlugUtil.current15mSlug(SlugUtil.BTC_SLUG_PREFIX));
            syncPrices(SlugUtil.next15mSlug(SlugUtil.BTC_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncBtc1hPrices() {
        if (eventsConfig.isEnabled("btc", "1h")) {
            syncPrices(SlugUtil.current1hSlug(SlugUtil.BTC_SLUG_PREFIX));
            syncPrices(SlugUtil.next1hSlug(SlugUtil.BTC_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncBtc4hPrices() {
        if (eventsConfig.isEnabled("btc", "4h")) {
            syncPrices(SlugUtil.current4hSlug(SlugUtil.BTC_SLUG_PREFIX));
            syncPrices(SlugUtil.next4hSlug(SlugUtil.BTC_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncBtcDailyPrices() {
        if (eventsConfig.isEnabled("btc", "1d")) {
            syncPrices(SlugUtil.currentDailySlug(SlugUtil.BTC_SLUG_PREFIX));
            syncPrices(SlugUtil.nextDailySlug(SlugUtil.BTC_SLUG_PREFIX));
        }
    }

    // ETH
    @Scheduled(fixedDelay = 1000)
    public void syncEth5mPrices() {
        if (eventsConfig.isEnabled("eth", "5m")) {
            syncPrices(SlugUtil.current5mSlug(SlugUtil.ETH_SLUG_PREFIX));
            syncPrices(SlugUtil.next5mSlug(SlugUtil.ETH_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncEth15mPrices() {
        if (eventsConfig.isEnabled("eth", "15m")) {
            syncPrices(SlugUtil.current15mSlug(SlugUtil.ETH_SLUG_PREFIX));
            syncPrices(SlugUtil.next15mSlug(SlugUtil.ETH_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncEth1hPrices() {
        if (eventsConfig.isEnabled("eth", "1h")) {
            syncPrices(SlugUtil.current1hSlug(SlugUtil.ETH_SLUG_PREFIX));
            syncPrices(SlugUtil.next1hSlug(SlugUtil.ETH_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncEth4hPrices() {
        if (eventsConfig.isEnabled("eth", "4h")) {
            syncPrices(SlugUtil.current4hSlug(SlugUtil.ETH_SLUG_PREFIX));
            syncPrices(SlugUtil.next4hSlug(SlugUtil.ETH_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncEthDailyPrices() {
        if (eventsConfig.isEnabled("eth", "1d")) {
            syncPrices(SlugUtil.currentDailySlug(SlugUtil.ETH_SLUG_PREFIX));
            syncPrices(SlugUtil.nextDailySlug(SlugUtil.ETH_SLUG_PREFIX));
        }
    }

    // SOL
    @Scheduled(fixedDelay = 1000)
    public void syncSol5mPrices() {
        if (eventsConfig.isEnabled("sol", "5m")) {
            syncPrices(SlugUtil.current5mSlug(SlugUtil.SOL_SLUG_PREFIX));
            syncPrices(SlugUtil.next5mSlug(SlugUtil.SOL_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncSol15mPrices() {
        if (eventsConfig.isEnabled("sol", "15m")) {
            syncPrices(SlugUtil.current15mSlug(SlugUtil.SOL_SLUG_PREFIX));
            syncPrices(SlugUtil.next15mSlug(SlugUtil.SOL_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncSol1hPrices() {
        if (eventsConfig.isEnabled("sol", "1h")) {
            syncPrices(SlugUtil.current1hSlug(SlugUtil.SOL_SLUG_PREFIX));
            syncPrices(SlugUtil.next1hSlug(SlugUtil.SOL_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncSol4hPrices() {
        if (eventsConfig.isEnabled("sol", "4h")) {
            syncPrices(SlugUtil.current4hSlug(SlugUtil.SOL_SLUG_PREFIX));
            syncPrices(SlugUtil.next4hSlug(SlugUtil.SOL_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncSolDailyPrices() {
        if (eventsConfig.isEnabled("sol", "1d")) {
            syncPrices(SlugUtil.currentDailySlug(SlugUtil.SOL_SLUG_PREFIX));
            syncPrices(SlugUtil.nextDailySlug(SlugUtil.SOL_SLUG_PREFIX));
        }
    }

    // DOGE
    @Scheduled(fixedDelay = 1000)
    public void syncDoge5mPrices() {
        if (eventsConfig.isEnabled("doge", "5m")) {
            syncPrices(SlugUtil.current5mSlug(SlugUtil.DOGE_SLUG_PREFIX));
            syncPrices(SlugUtil.next5mSlug(SlugUtil.DOGE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncDoge15mPrices() {
        if (eventsConfig.isEnabled("doge", "15m")) {
            syncPrices(SlugUtil.current15mSlug(SlugUtil.DOGE_SLUG_PREFIX));
            syncPrices(SlugUtil.next15mSlug(SlugUtil.DOGE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncDoge1hPrices() {
        if (eventsConfig.isEnabled("doge", "1h")) {
            syncPrices(SlugUtil.current1hSlug(SlugUtil.DOGE_SLUG_PREFIX));
            syncPrices(SlugUtil.next1hSlug(SlugUtil.DOGE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncDoge4hPrices() {
        if (eventsConfig.isEnabled("doge", "4h")) {
            syncPrices(SlugUtil.current4hSlug(SlugUtil.DOGE_SLUG_PREFIX));
            syncPrices(SlugUtil.next4hSlug(SlugUtil.DOGE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncDogeDailyPrices() {
        if (eventsConfig.isEnabled("doge", "1d")) {
            syncPrices(SlugUtil.currentDailySlug(SlugUtil.DOGE_SLUG_PREFIX));
            syncPrices(SlugUtil.nextDailySlug(SlugUtil.DOGE_SLUG_PREFIX));
        }
    }

    // HYPE
    @Scheduled(fixedDelay = 1000)
    public void syncHype5mPrices() {
        if (eventsConfig.isEnabled("hype", "5m")) {
            syncPrices(SlugUtil.current5mSlug(SlugUtil.HYPE_SLUG_PREFIX));
            syncPrices(SlugUtil.next5mSlug(SlugUtil.HYPE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncHype15mPrices() {
        if (eventsConfig.isEnabled("hype", "15m")) {
            syncPrices(SlugUtil.current15mSlug(SlugUtil.HYPE_SLUG_PREFIX));
            syncPrices(SlugUtil.next15mSlug(SlugUtil.HYPE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncHype1hPrices() {
        if (eventsConfig.isEnabled("hype", "1h")) {
            syncPrices(SlugUtil.current1hSlug(SlugUtil.HYPE_SLUG_PREFIX));
            syncPrices(SlugUtil.next1hSlug(SlugUtil.HYPE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncHype4hPrices() {
        if (eventsConfig.isEnabled("hype", "4h")) {
            syncPrices(SlugUtil.current4hSlug(SlugUtil.HYPE_SLUG_PREFIX));
            syncPrices(SlugUtil.next4hSlug(SlugUtil.HYPE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncHypeDailyPrices() {
        if (eventsConfig.isEnabled("hype", "1d")) {
            syncPrices(SlugUtil.currentDailySlug(SlugUtil.HYPE_SLUG_PREFIX));
            syncPrices(SlugUtil.nextDailySlug(SlugUtil.HYPE_SLUG_PREFIX));
        }
    }

    // XRP
    @Scheduled(fixedDelay = 1000)
    public void syncXrp5mPrices() {
        if (eventsConfig.isEnabled("xrp", "5m")) {
            syncPrices(SlugUtil.current5mSlug(SlugUtil.XRP_SLUG_PREFIX));
            syncPrices(SlugUtil.next5mSlug(SlugUtil.XRP_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncXrp15mPrices() {
        if (eventsConfig.isEnabled("xrp", "15m")) {
            syncPrices(SlugUtil.current15mSlug(SlugUtil.XRP_SLUG_PREFIX));
            syncPrices(SlugUtil.next15mSlug(SlugUtil.XRP_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncXrp1hPrices() {
        if (eventsConfig.isEnabled("xrp", "1h")) {
            syncPrices(SlugUtil.current1hSlug(SlugUtil.XRP_SLUG_PREFIX));
            syncPrices(SlugUtil.next1hSlug(SlugUtil.XRP_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncXrp4hPrices() {
        if (eventsConfig.isEnabled("xrp", "4h")) {
            syncPrices(SlugUtil.current4hSlug(SlugUtil.XRP_SLUG_PREFIX));
            syncPrices(SlugUtil.next4hSlug(SlugUtil.XRP_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncXrpDailyPrices() {
        if (eventsConfig.isEnabled("xrp", "1d")) {
            syncPrices(SlugUtil.currentDailySlug(SlugUtil.XRP_SLUG_PREFIX));
            syncPrices(SlugUtil.nextDailySlug(SlugUtil.XRP_SLUG_PREFIX));
        }
    }

    // BNB
    @Scheduled(fixedDelay = 1000)
    public void syncBnb5mPrices() {
        if (eventsConfig.isEnabled("bnb", "5m")) {
            syncPrices(SlugUtil.current5mSlug(SlugUtil.BNB_SLUG_PREFIX));
            syncPrices(SlugUtil.next5mSlug(SlugUtil.BNB_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncBnb15mPrices() {
        if (eventsConfig.isEnabled("bnb", "15m")) {
            syncPrices(SlugUtil.current15mSlug(SlugUtil.BNB_SLUG_PREFIX));
            syncPrices(SlugUtil.next15mSlug(SlugUtil.BNB_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncBnb1hPrices() {
        if (eventsConfig.isEnabled("bnb", "1h")) {
            syncPrices(SlugUtil.current1hSlug(SlugUtil.BNB_SLUG_PREFIX));
            syncPrices(SlugUtil.next1hSlug(SlugUtil.BNB_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncBnb4hPrices() {
        if (eventsConfig.isEnabled("bnb", "4h")) {
            syncPrices(SlugUtil.current4hSlug(SlugUtil.BNB_SLUG_PREFIX));
            syncPrices(SlugUtil.next4hSlug(SlugUtil.BNB_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void syncBnbDailyPrices() {
        if (eventsConfig.isEnabled("bnb", "1d")) {
            syncPrices(SlugUtil.currentDailySlug(SlugUtil.BNB_SLUG_PREFIX));
            syncPrices(SlugUtil.nextDailySlug(SlugUtil.BNB_SLUG_PREFIX));
        }
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
