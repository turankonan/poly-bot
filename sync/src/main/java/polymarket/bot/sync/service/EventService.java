package polymarket.bot.sync.service;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import polymarket.bot.model.Event;
import polymarket.bot.model.repository.EventRepository;
import polymarket.bot.rest.gamma.api.model.BEventDetailDTO;
import polymarket.bot.rest.gamma.service.EventApiService;
import polymarket.bot.sync.config.EventsConfig;
import polymarket.bot.sync.util.SlugUtil;

@Slf4j
@Service
public class EventService {

    @Resource
    private EventRepository eventRepository;

    @Resource
    private EventApiService eventApiService;
    
    @Resource
    private EventsConfig eventsConfig;
    
    // BTC
    @Scheduled(fixedDelay = 10000)
    public void syncBtc5mEvent() {
        if (eventsConfig.isEnabled("btc", "5m")) {
            syncEvent(SlugUtil.current5mSlug(SlugUtil.BTC_SLUG_PREFIX));
            syncEvent(SlugUtil.next5mSlug(SlugUtil.BTC_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncBtc15mEvent() {
        if (eventsConfig.isEnabled("btc", "15m")) {
            syncEvent(SlugUtil.current15mSlug(SlugUtil.BTC_SLUG_PREFIX));
            syncEvent(SlugUtil.next15mSlug(SlugUtil.BTC_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncBtc1hEvent() {
        if (eventsConfig.isEnabled("btc", "1h")) {
            syncEvent(SlugUtil.current1hSlug(SlugUtil.BTC_SLUG_PREFIX));
            syncEvent(SlugUtil.next1hSlug(SlugUtil.BTC_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncBtc4hEvent() {
        if (eventsConfig.isEnabled("btc", "4h")) {
            syncEvent(SlugUtil.current4hSlug(SlugUtil.BTC_SLUG_PREFIX));
            syncEvent(SlugUtil.next4hSlug(SlugUtil.BTC_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncBtcDailyEvent() {
        if (eventsConfig.isEnabled("btc", "1d")) {
            syncEvent(SlugUtil.currentDailySlug(SlugUtil.BTC_SLUG_PREFIX));
            syncEvent(SlugUtil.nextDailySlug(SlugUtil.BTC_SLUG_PREFIX));
        }
    }

    // ETH
    @Scheduled(fixedDelay = 10000)
    public void syncEth5mEvent() {
        if (eventsConfig.isEnabled("eth", "5m")) {
            syncEvent(SlugUtil.current5mSlug(SlugUtil.ETH_SLUG_PREFIX));
            syncEvent(SlugUtil.next5mSlug(SlugUtil.ETH_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncEth15mEvent() {
        if (eventsConfig.isEnabled("eth", "15m")) {
            syncEvent(SlugUtil.current15mSlug(SlugUtil.ETH_SLUG_PREFIX));
            syncEvent(SlugUtil.next15mSlug(SlugUtil.ETH_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncEth1hEvent() {
        if (eventsConfig.isEnabled("eth", "1h")) {
            syncEvent(SlugUtil.current1hSlug(SlugUtil.ETH_SLUG_PREFIX));
            syncEvent(SlugUtil.next1hSlug(SlugUtil.ETH_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncEth4hEvent() {
        if (eventsConfig.isEnabled("eth", "4h")) {
            syncEvent(SlugUtil.current4hSlug(SlugUtil.ETH_SLUG_PREFIX));
            syncEvent(SlugUtil.next4hSlug(SlugUtil.ETH_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncEthDailyEvent() {
        if (eventsConfig.isEnabled("eth", "1d")) {
            syncEvent(SlugUtil.currentDailySlug(SlugUtil.ETH_SLUG_PREFIX));
            syncEvent(SlugUtil.nextDailySlug(SlugUtil.ETH_SLUG_PREFIX));
        }
    }

    // SOL
    @Scheduled(fixedDelay = 10000)
    public void syncSol5mEvent() {
        if (eventsConfig.isEnabled("sol", "5m")) {
            syncEvent(SlugUtil.current5mSlug(SlugUtil.SOL_SLUG_PREFIX));
            syncEvent(SlugUtil.next5mSlug(SlugUtil.SOL_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncSol15mEvent() {
        if (eventsConfig.isEnabled("sol", "15m")) {
            syncEvent(SlugUtil.current15mSlug(SlugUtil.SOL_SLUG_PREFIX));
            syncEvent(SlugUtil.next15mSlug(SlugUtil.SOL_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncSol1hEvent() {
        if (eventsConfig.isEnabled("sol", "1h")) {
            syncEvent(SlugUtil.current1hSlug(SlugUtil.SOL_SLUG_PREFIX));
            syncEvent(SlugUtil.next1hSlug(SlugUtil.SOL_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncSol4hEvent() {
        if (eventsConfig.isEnabled("sol", "4h")) {
            syncEvent(SlugUtil.current4hSlug(SlugUtil.SOL_SLUG_PREFIX));
            syncEvent(SlugUtil.next4hSlug(SlugUtil.SOL_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncSolDailyEvent() {
        if (eventsConfig.isEnabled("sol", "1d")) {
            syncEvent(SlugUtil.currentDailySlug(SlugUtil.SOL_SLUG_PREFIX));
            syncEvent(SlugUtil.nextDailySlug(SlugUtil.SOL_SLUG_PREFIX));
        }
    }

    // DOGE
    @Scheduled(fixedDelay = 10000)
    public void syncDoge5mEvent() {
        if (eventsConfig.isEnabled("doge", "5m")) {
            syncEvent(SlugUtil.current5mSlug(SlugUtil.DOGE_SLUG_PREFIX));
            syncEvent(SlugUtil.next5mSlug(SlugUtil.DOGE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncDoge15mEvent() {
        if (eventsConfig.isEnabled("doge", "15m")) {
            syncEvent(SlugUtil.current15mSlug(SlugUtil.DOGE_SLUG_PREFIX));
            syncEvent(SlugUtil.next15mSlug(SlugUtil.DOGE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncDoge1hEvent() {
        if (eventsConfig.isEnabled("doge", "1h")) {
            syncEvent(SlugUtil.current1hSlug(SlugUtil.DOGE_SLUG_PREFIX));
            syncEvent(SlugUtil.next1hSlug(SlugUtil.DOGE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncDoge4hEvent() {
        if (eventsConfig.isEnabled("doge", "4h")) {
            syncEvent(SlugUtil.current4hSlug(SlugUtil.DOGE_SLUG_PREFIX));
            syncEvent(SlugUtil.next4hSlug(SlugUtil.DOGE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncDogeDailyEvent() {
        if (eventsConfig.isEnabled("doge", "1d")) {
            syncEvent(SlugUtil.currentDailySlug(SlugUtil.DOGE_SLUG_PREFIX));
            syncEvent(SlugUtil.nextDailySlug(SlugUtil.DOGE_SLUG_PREFIX));
        }
    }

    // HYPE
    @Scheduled(fixedDelay = 10000)
    public void syncHype5mEvent() {
        if (eventsConfig.isEnabled("hype", "5m")) {
            syncEvent(SlugUtil.current5mSlug(SlugUtil.HYPE_SLUG_PREFIX));
            syncEvent(SlugUtil.next5mSlug(SlugUtil.HYPE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncHype15mEvent() {
        if (eventsConfig.isEnabled("hype", "15m")) {
            syncEvent(SlugUtil.current15mSlug(SlugUtil.HYPE_SLUG_PREFIX));
            syncEvent(SlugUtil.next15mSlug(SlugUtil.HYPE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncHype1hEvent() {
        if (eventsConfig.isEnabled("hype", "1h")) {
            syncEvent(SlugUtil.current1hSlug(SlugUtil.HYPE_SLUG_PREFIX));
            syncEvent(SlugUtil.next1hSlug(SlugUtil.HYPE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncHype4hEvent() {
        if (eventsConfig.isEnabled("hype", "4h")) {
            syncEvent(SlugUtil.current4hSlug(SlugUtil.HYPE_SLUG_PREFIX));
            syncEvent(SlugUtil.next4hSlug(SlugUtil.HYPE_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncHypeDailyEvent() {
        if (eventsConfig.isEnabled("hype", "1d")) {
            syncEvent(SlugUtil.currentDailySlug(SlugUtil.HYPE_SLUG_PREFIX));
            syncEvent(SlugUtil.nextDailySlug(SlugUtil.HYPE_SLUG_PREFIX));
        }
    }

    // XRP
    @Scheduled(fixedDelay = 10000)
    public void syncXrp5mEvent() {
        if (eventsConfig.isEnabled("xrp", "5m")) {
            syncEvent(SlugUtil.current5mSlug(SlugUtil.XRP_SLUG_PREFIX));
            syncEvent(SlugUtil.next5mSlug(SlugUtil.XRP_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncXrp15mEvent() {
        if (eventsConfig.isEnabled("xrp", "15m")) {
            syncEvent(SlugUtil.current15mSlug(SlugUtil.XRP_SLUG_PREFIX));
            syncEvent(SlugUtil.next15mSlug(SlugUtil.XRP_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncXrp1hEvent() {
        if (eventsConfig.isEnabled("xrp", "1h")) {
            syncEvent(SlugUtil.current1hSlug(SlugUtil.XRP_SLUG_PREFIX));
            syncEvent(SlugUtil.next1hSlug(SlugUtil.XRP_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncXrp4hEvent() {
        if (eventsConfig.isEnabled("xrp", "4h")) {
            syncEvent(SlugUtil.current4hSlug(SlugUtil.XRP_SLUG_PREFIX));
            syncEvent(SlugUtil.next4hSlug(SlugUtil.XRP_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncXrpDailyEvent() {
        if (eventsConfig.isEnabled("xrp", "1d")) {
            syncEvent(SlugUtil.currentDailySlug(SlugUtil.XRP_SLUG_PREFIX));
            syncEvent(SlugUtil.nextDailySlug(SlugUtil.XRP_SLUG_PREFIX));
        }
    }

    // BNB
    @Scheduled(fixedDelay = 10000)
    public void syncBnb5mEvent() {
        if (eventsConfig.isEnabled("bnb", "5m")) {
            syncEvent(SlugUtil.current5mSlug(SlugUtil.BNB_SLUG_PREFIX));
            syncEvent(SlugUtil.next5mSlug(SlugUtil.BNB_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncBnb15mEvent() {
        if (eventsConfig.isEnabled("bnb", "15m")) {
            syncEvent(SlugUtil.current15mSlug(SlugUtil.BNB_SLUG_PREFIX));
            syncEvent(SlugUtil.next15mSlug(SlugUtil.BNB_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncBnb1hEvent() {
        if (eventsConfig.isEnabled("bnb", "1h")) {
            syncEvent(SlugUtil.current1hSlug(SlugUtil.BNB_SLUG_PREFIX));
            syncEvent(SlugUtil.next1hSlug(SlugUtil.BNB_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncBnb4hEvent() {
        if (eventsConfig.isEnabled("bnb", "4h")) {
            syncEvent(SlugUtil.current4hSlug(SlugUtil.BNB_SLUG_PREFIX));
            syncEvent(SlugUtil.next4hSlug(SlugUtil.BNB_SLUG_PREFIX));
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void syncBnbDailyEvent() {
        if (eventsConfig.isEnabled("bnb", "1d")) {
            syncEvent(SlugUtil.currentDailySlug(SlugUtil.BNB_SLUG_PREFIX));
            syncEvent(SlugUtil.nextDailySlug(SlugUtil.BNB_SLUG_PREFIX));
        }
    }

    private void syncEvent(String slug) {
        try {
            BEventDetailDTO dto = eventApiService.list(slug);
            if (dto == null) {
                log.warn("No event returned from API for slug: {}", slug);
                return;
            }

            Event event = eventRepository.findBySlug(slug);
            if (event == null) {
                event = new Event();
                event.setCreateDate(LocalDateTime.now());
            }

            eventRepository.save(toEvent(event, dto));

            log.info("Saved event: {}", slug);
        } catch (Exception e) {
            log.error("Failed to sync event {}: {}", slug, e.getMessage(), e);
        }
    }

    private Event toEvent(Event event, BEventDetailDTO dto) {
        event.setExternalId(dto.getId());
        event.setSlug(dto.getSlug());
        event.setTicker(dto.getTicker());
        event.setTitle(dto.getTitle());
        event.setStartDate(dto.getStartDate());
        event.setCreationDate(dto.getCreationDate());
        event.setEndDate(dto.getEndDate());
        event.setActive(dto.getActive());
        event.setClosed(dto.getClosed());
        event.setArchived(dto.getArchived());
        event.setIsNew(dto.getNew());

        return event;
    }

}
