package polymarket.bot.sync.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import polymarket.bot.model.Event;
import polymarket.bot.model.EventOrderBook;
import polymarket.bot.model.EventOrderBookPrice;
import polymarket.bot.model.repository.EventOrderBookRepository;
import polymarket.bot.model.repository.EventRepository;
import polymarket.bot.rest.clob.api.model.BBookDetailDTO;
import polymarket.bot.rest.clob.api.model.BBookDetailRequestDTO;
import polymarket.bot.rest.clob.api.model.BBookPriceDTO;
import polymarket.bot.rest.clob.service.BookApiService;
import polymarket.bot.sync.config.EventsConfig;
import polymarket.bot.sync.util.SlugUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookService {

    @Resource
    private EventRepository eventRepository;

    @Resource
    private EventOrderBookRepository eventOrderBookRepository;

    @Resource
    private BookApiService bookApiService;

    @Resource
    private EventsConfig eventsConfig;

    // BTC
    @Scheduled(fixedDelay = 5000)
    public void syncBtc5mOrderBooks() {
        if (eventsConfig.isEnabled("btc", "5m")) {
            syncOrderBook(SlugUtil.current5mSlug(SlugUtil.BTC_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next5mSlug(SlugUtil.BTC_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncBtc15mOrderBooks() {
        if (eventsConfig.isEnabled("btc", "15m")) {
            syncOrderBook(SlugUtil.current15mSlug(SlugUtil.BTC_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next15mSlug(SlugUtil.BTC_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncBtc1hOrderBooks() {
        if (eventsConfig.isEnabled("btc", "1h")) {
            syncOrderBook(SlugUtil.current1hSlug(SlugUtil.BTC_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next1hSlug(SlugUtil.BTC_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncBtc4hOrderBooks() {
        if (eventsConfig.isEnabled("btc", "4h")) {
            syncOrderBook(SlugUtil.current4hSlug(SlugUtil.BTC_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next4hSlug(SlugUtil.BTC_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncBtcDailyOrderBooks() {
        if (eventsConfig.isEnabled("btc", "1d")) {
            syncOrderBook(SlugUtil.currentDailySlug(SlugUtil.BTC_SLUG_PREFIX));
            syncOrderBook(SlugUtil.nextDailySlug(SlugUtil.BTC_SLUG_PREFIX));
        }
    }

    // ETH
    @Scheduled(fixedDelay = 5000)
    public void syncEth5mOrderBooks() {
        if (eventsConfig.isEnabled("eth", "5m")) {
            syncOrderBook(SlugUtil.current5mSlug(SlugUtil.ETH_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next5mSlug(SlugUtil.ETH_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncEth15mOrderBooks() {
        if (eventsConfig.isEnabled("eth", "15m")) {
            syncOrderBook(SlugUtil.current15mSlug(SlugUtil.ETH_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next15mSlug(SlugUtil.ETH_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncEth1hOrderBooks() {
        if (eventsConfig.isEnabled("eth", "1h")) {
            syncOrderBook(SlugUtil.current1hSlug(SlugUtil.ETH_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next1hSlug(SlugUtil.ETH_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncEth4hOrderBooks() {
        if (eventsConfig.isEnabled("eth", "4h")) {
            syncOrderBook(SlugUtil.current4hSlug(SlugUtil.ETH_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next4hSlug(SlugUtil.ETH_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncEthDailyOrderBooks() {
        if (eventsConfig.isEnabled("eth", "1d")) {
            syncOrderBook(SlugUtil.currentDailySlug(SlugUtil.ETH_SLUG_PREFIX));
            syncOrderBook(SlugUtil.nextDailySlug(SlugUtil.ETH_SLUG_PREFIX));
        }
    }

    // SOL
    @Scheduled(fixedDelay = 5000)
    public void syncSol5mOrderBooks() {
        if (eventsConfig.isEnabled("sol", "5m")) {
            syncOrderBook(SlugUtil.current5mSlug(SlugUtil.SOL_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next5mSlug(SlugUtil.SOL_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncSol15mOrderBooks() {
        if (eventsConfig.isEnabled("sol", "15m")) {
            syncOrderBook(SlugUtil.current15mSlug(SlugUtil.SOL_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next15mSlug(SlugUtil.SOL_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncSol1hOrderBooks() {
        if (eventsConfig.isEnabled("sol", "1h")) {
            syncOrderBook(SlugUtil.current1hSlug(SlugUtil.SOL_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next1hSlug(SlugUtil.SOL_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncSol4hOrderBooks() {
        if (eventsConfig.isEnabled("sol", "4h")) {
            syncOrderBook(SlugUtil.current4hSlug(SlugUtil.SOL_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next4hSlug(SlugUtil.SOL_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncSolDailyOrderBooks() {
        if (eventsConfig.isEnabled("sol", "1d")) {
            syncOrderBook(SlugUtil.currentDailySlug(SlugUtil.SOL_SLUG_PREFIX));
            syncOrderBook(SlugUtil.nextDailySlug(SlugUtil.SOL_SLUG_PREFIX));
        }
    }

    // DOGE
    @Scheduled(fixedDelay = 5000)
    public void syncDoge5mOrderBooks() {
        if (eventsConfig.isEnabled("doge", "5m")) {
            syncOrderBook(SlugUtil.current5mSlug(SlugUtil.DOGE_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next5mSlug(SlugUtil.DOGE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncDoge15mOrderBooks() {
        if (eventsConfig.isEnabled("doge", "15m")) {
            syncOrderBook(SlugUtil.current15mSlug(SlugUtil.DOGE_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next15mSlug(SlugUtil.DOGE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncDoge1hOrderBooks() {
        if (eventsConfig.isEnabled("doge", "1h")) {
            syncOrderBook(SlugUtil.current1hSlug(SlugUtil.DOGE_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next1hSlug(SlugUtil.DOGE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncDoge4hOrderBooks() {
        if (eventsConfig.isEnabled("doge", "4h")) {
            syncOrderBook(SlugUtil.current4hSlug(SlugUtil.DOGE_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next4hSlug(SlugUtil.DOGE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncDogeDailyOrderBooks() {
        if (eventsConfig.isEnabled("doge", "1d")) {
            syncOrderBook(SlugUtil.currentDailySlug(SlugUtil.DOGE_SLUG_PREFIX));
            syncOrderBook(SlugUtil.nextDailySlug(SlugUtil.DOGE_SLUG_PREFIX));
        }
    }

    // HYPE
    @Scheduled(fixedDelay = 5000)
    public void syncHype5mOrderBooks() {
        if (eventsConfig.isEnabled("hype", "5m")) {
            syncOrderBook(SlugUtil.current5mSlug(SlugUtil.HYPE_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next5mSlug(SlugUtil.HYPE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncHype15mOrderBooks() {
        if (eventsConfig.isEnabled("hype", "15m")) {
            syncOrderBook(SlugUtil.current15mSlug(SlugUtil.HYPE_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next15mSlug(SlugUtil.HYPE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncHype1hOrderBooks() {
        if (eventsConfig.isEnabled("hype", "1h")) {
            syncOrderBook(SlugUtil.current1hSlug(SlugUtil.HYPE_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next1hSlug(SlugUtil.HYPE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncHype4hOrderBooks() {
        if (eventsConfig.isEnabled("hype", "4h")) {
            syncOrderBook(SlugUtil.current4hSlug(SlugUtil.HYPE_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next4hSlug(SlugUtil.HYPE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncHypeDailyOrderBooks() {
        if (eventsConfig.isEnabled("hype", "1d")) {
            syncOrderBook(SlugUtil.currentDailySlug(SlugUtil.HYPE_SLUG_PREFIX));
            syncOrderBook(SlugUtil.nextDailySlug(SlugUtil.HYPE_SLUG_PREFIX));
        }
    }

    // XRP
    @Scheduled(fixedDelay = 5000)
    public void syncXrp5mOrderBooks() {
        if (eventsConfig.isEnabled("xrp", "5m")) {
            syncOrderBook(SlugUtil.current5mSlug(SlugUtil.XRP_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next5mSlug(SlugUtil.XRP_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncXrp15mOrderBooks() {
        if (eventsConfig.isEnabled("xrp", "15m")) {
            syncOrderBook(SlugUtil.current15mSlug(SlugUtil.XRP_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next15mSlug(SlugUtil.XRP_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncXrp1hOrderBooks() {
        if (eventsConfig.isEnabled("xrp", "1h")) {
            syncOrderBook(SlugUtil.current1hSlug(SlugUtil.XRP_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next1hSlug(SlugUtil.XRP_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncXrp4hOrderBooks() {
        if (eventsConfig.isEnabled("xrp", "4h")) {
            syncOrderBook(SlugUtil.current4hSlug(SlugUtil.XRP_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next4hSlug(SlugUtil.XRP_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncXrpDailyOrderBooks() {
        if (eventsConfig.isEnabled("xrp", "1d")) {
            syncOrderBook(SlugUtil.currentDailySlug(SlugUtil.XRP_SLUG_PREFIX));
            syncOrderBook(SlugUtil.nextDailySlug(SlugUtil.XRP_SLUG_PREFIX));
        }
    }

    // BNB
    @Scheduled(fixedDelay = 5000)
    public void syncBnb5mOrderBooks() {
        if (eventsConfig.isEnabled("bnb", "5m")) {
            syncOrderBook(SlugUtil.current5mSlug(SlugUtil.BNB_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next5mSlug(SlugUtil.BNB_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncBnb15mOrderBooks() {
        if (eventsConfig.isEnabled("bnb", "15m")) {
            syncOrderBook(SlugUtil.current15mSlug(SlugUtil.BNB_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next15mSlug(SlugUtil.BNB_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncBnb1hOrderBooks() {
        if (eventsConfig.isEnabled("bnb", "1h")) {
            syncOrderBook(SlugUtil.current1hSlug(SlugUtil.BNB_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next1hSlug(SlugUtil.BNB_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncBnb4hOrderBooks() {
        if (eventsConfig.isEnabled("bnb", "4h")) {
            syncOrderBook(SlugUtil.current4hSlug(SlugUtil.BNB_SLUG_PREFIX));
            syncOrderBook(SlugUtil.next4hSlug(SlugUtil.BNB_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void syncBnbDailyOrderBooks() {
        if (eventsConfig.isEnabled("bnb", "1d")) {
            syncOrderBook(SlugUtil.currentDailySlug(SlugUtil.BNB_SLUG_PREFIX));
            syncOrderBook(SlugUtil.nextDailySlug(SlugUtil.BNB_SLUG_PREFIX));
        }
    }

    private void syncOrderBook(String slug) {
        try {
            Event event = eventRepository.findBySlug(slug);
            if (event == null) {
                // TODO: warning mesajı ekle
                return;
            }

            String upTokenId = event.getUpTokenId();
            String downTokenId = event.getDownTokenId();

            List<BBookDetailRequestDTO> request = new ArrayList<BBookDetailRequestDTO>();
            request.add(new BBookDetailRequestDTO().tokenId(upTokenId));
            request.add(new BBookDetailRequestDTO().tokenId(downTokenId));

            EventOrderBook eventOrderBook = new EventOrderBook();
            eventOrderBook.setCreateDate(LocalDateTime.now());
            eventOrderBook.setSlug(slug);

            List<BBookDetailDTO> books = bookApiService.detail(request);
            if (!CollectionUtils.isEmpty(books)) {
                for (BBookDetailDTO bookDetail : books) {

                    if (upTokenId.equals(bookDetail.getAssetId())) {
                        List<BBookPriceDTO> asks = bookDetail.getAsks();
                        List<EventOrderBookPrice> upAsks = new ArrayList<>();

                        if (!CollectionUtils.isEmpty(asks)) {
                            for (BBookPriceDTO bookPrice : asks) {
                                EventOrderBookPrice eventOrderBookPrice = new EventOrderBookPrice();
                                eventOrderBookPrice.setPrice(Double.valueOf(bookPrice.getPrice()));
                                eventOrderBookPrice.setSize(Double.valueOf(bookPrice.getSize()));
                                upAsks.add(eventOrderBookPrice);
                            }
                        }
                        eventOrderBook.setUpAsks(upAsks);

                        List<BBookPriceDTO> bids = bookDetail.getBids();
                        List<EventOrderBookPrice> upBids = new ArrayList<>();

                        if (!CollectionUtils.isEmpty(bids)) {
                            for (BBookPriceDTO bookPrice : bids) {
                                EventOrderBookPrice eventOrderBookPrice = new EventOrderBookPrice();
                                eventOrderBookPrice.setPrice(Double.valueOf(bookPrice.getPrice()));
                                eventOrderBookPrice.setSize(Double.valueOf(bookPrice.getSize()));
                                upBids.add(eventOrderBookPrice);
                            }
                        }
                        eventOrderBook.setUpBids(upBids);
                    }

                    if (downTokenId.equals(bookDetail.getAssetId())) {
                        List<BBookPriceDTO> asks = bookDetail.getAsks();
                        List<EventOrderBookPrice> downAsks = new ArrayList<>();

                        if (!CollectionUtils.isEmpty(asks)) {
                            for (BBookPriceDTO bookPrice : asks) {
                                EventOrderBookPrice eventOrderBookPrice = new EventOrderBookPrice();
                                eventOrderBookPrice.setPrice(Double.valueOf(bookPrice.getPrice()));
                                eventOrderBookPrice.setSize(Double.valueOf(bookPrice.getSize()));
                                downAsks.add(eventOrderBookPrice);
                            }
                        }
                        eventOrderBook.setDownAsks(downAsks);

                        List<BBookPriceDTO> bids = bookDetail.getBids();
                        List<EventOrderBookPrice> downBids = new ArrayList<>();

                        if (!CollectionUtils.isEmpty(bids)) {
                            for (BBookPriceDTO bookPrice : bids) {
                                EventOrderBookPrice eventOrderBookPrice = new EventOrderBookPrice();
                                eventOrderBookPrice.setPrice(Double.valueOf(bookPrice.getPrice()));
                                eventOrderBookPrice.setSize(Double.valueOf(bookPrice.getSize()));
                                downBids.add(eventOrderBookPrice);
                            }
                        }
                        eventOrderBook.setDownBids(downBids);
                    }

                }
            }

            eventOrderBookRepository.save(eventOrderBook);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}
