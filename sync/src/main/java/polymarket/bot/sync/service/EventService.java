package polymarket.bot.sync.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.annotation.Resource;

import org.json.JSONArray;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import polymarket.bot.model.*;
import polymarket.bot.model.repository.EventRepository;
import polymarket.bot.rest.gamma.api.model.*;
import polymarket.bot.rest.gamma.service.EventApiService;
import polymarket.bot.sync.config.EventsConfig;
import polymarket.bot.sync.util.SlugUtil;

import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

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
        event.setSubtitle(dto.getSubtitle());
        event.setDescription(dto.getDescription());
        event.setResolutionSource(dto.getResolutionSource());
        event.setStartDate(dto.getStartDate());
        event.setCreationDate(dto.getCreationDate());
        event.setEndDate(dto.getEndDate());
        event.setImage(dto.getImage());
        event.setIcon(dto.getIcon());
        event.setActive(dto.getActive());
        event.setClosed(dto.getClosed());
        event.setArchived(dto.getArchived());
        event.setIsNew(dto.getNew());
        event.setFeatured(dto.getFeatured());
        event.setRestricted(dto.getRestricted());
        event.setLiquidity(dto.getLiquidity());
        event.setVolume(dto.getVolume());
        event.setOpenInterest(dto.getOpenInterest());
        event.setSortBy(dto.getSortBy());
        event.setCategory(dto.getCategory());
        event.setSubcategory(dto.getSubcategory());
        event.setIsTemplate(dto.getIsTemplate());
        event.setTemplateVariables(dto.getTemplateVariables());
        event.setPublishedAt(dto.getPublishedAt());
        event.setCommentsEnabled(dto.getCommentsEnabled());
        event.setCompetitive(dto.getCompetitive());
        event.setVolume24hr(dto.getVolume24hr());
        event.setVolume1wk(dto.getVolume1wk());
        event.setVolume1mo(dto.getVolume1mo());
        event.setVolume1yr(dto.getVolume1yr());
        event.setFeaturedImage(dto.getFeaturedImage());
        event.setDisqusThread(dto.getDisqusThread());
        event.setParentEvent(dto.getParentEvent());
        event.setEnableOrderBook(dto.getEnableOrderBook());
        event.setLiquidityAmm(dto.getLiquidityAmm());
        event.setLiquidityClob(dto.getLiquidityClob());
        event.setNegRisk(dto.getNegRisk());
        event.setNegRiskMarketID(dto.getNegRiskMarketID());
        event.setNegRiskFeeBips(dto.getNegRiskFeeBips());
        event.setCommentCount(dto.getCommentCount());
        event.setSubEvents(dto.getSubEvents());
        event.setCyom(dto.getCyom());
        event.setClosedTime(dto.getClosedTime());
        event.setShowAllOutcomes(dto.getShowAllOutcomes());
        event.setShowMarketImages(dto.getShowMarketImages());
        event.setAutomaticallyResolved(dto.getAutomaticallyResolved());
        event.setEnableNegRisk(dto.getEnableNegRisk());
        event.setAutomaticallyActive(dto.getAutomaticallyActive());
        event.setEventDate(dto.getEventDate());
        event.setStartTime(dto.getStartTime());
        event.setEventWeek(dto.getEventWeek());
        event.setSeriesSlug(dto.getSeriesSlug());
        event.setScore(dto.getScore());
        event.setElapsed(dto.getElapsed());
        event.setPeriod(dto.getPeriod());
        event.setLive(dto.getLive());
        event.setEnded(dto.getEnded());
        event.setFinishedTimestamp(dto.getFinishedTimestamp());
        event.setGmpChartMode(dto.getGmpChartMode());
        event.setTweetCount(dto.getTweetCount());
        event.setFeaturedOrder(dto.getFeaturedOrder());
        event.setEstimateValue(dto.getEstimateValue());
        event.setCantEstimate(dto.getCantEstimate());
        event.setEstimatedValue(dto.getEstimatedValue());
        event.setSpreadsMainLine(dto.getSpreadsMainLine());
        event.setTotalsMainLine(dto.getTotalsMainLine());
        event.setCarouselMap(dto.getCarouselMap());
        event.setPendingDeployment(dto.getPendingDeployment());
        event.setDeploying(dto.getDeploying());
        event.setDeployingTimestamp(dto.getDeployingTimestamp());
        event.setScheduledDeploymentTimestamp(dto.getScheduledDeploymentTimestamp());
        event.setGameStatus(dto.getGameStatus());
        event.setImageOptimized(toImageOptimized(dto.getImageOptimized()));
        event.setIconOptimized(toImageOptimized(dto.getIconOptimized()));
        event.setFeaturedImageOptimized(toImageOptimized(dto.getFeaturedImageOptimized()));
        event.setMarkets(toMarkets(dto.getMarkets()));
        event.setSeries(toSeriesList(dto.getSeries()));
        event.setCategories(toCategories(dto.getCategories()));
        event.setCollections(toCollections(dto.getCollections()));
        event.setTags(toTags(dto.getTags()));
        event.setEventCreators(toEventCreators(dto.getEventCreators()));
        event.setChats(toChats(dto.getChats()));
        event.setTemplates(toTemplates(dto.getTemplates()));

        if (!CollectionUtils.isEmpty(event.getMarkets())) {
            for (Market market : event.getMarkets()) {
                event.setUpTokenId(market.getUpTokenId());
                event.setDownTokenId(market.getDownTokenId());
            }
        }

        return event;
    }

    private ImageOptimized toImageOptimized(BImageOptimizedDTO dto) {
        if (dto == null)
            return null;
        ImageOptimized img = new ImageOptimized();
        img.setImageUrlSource(dto.getImageUrlSource());
        img.setImageUrlOptimized(dto.getImageUrlOptimized());
        img.setImageSizeKbSource(dto.getImageSizeKbSource());
        img.setImageSizeKbOptimized(dto.getImageSizeKbOptimized());
        img.setImageOptimizedComplete(dto.getImageOptimizedComplete());
        img.setImageOptimizedLastUpdated(dto.getImageOptimizedLastUpdated());
        img.setRelID(dto.getRelID());
        img.setField(dto.getField());
        img.setRelname(dto.getRelname());
        return img;
    }

    private Category toCategory(BCategoryDTO dto) {
        if (dto == null)
            return null;
        Category cat = new Category();
        cat.setId(dto.getId());
        cat.setLabel(dto.getLabel());
        cat.setParentCategory(dto.getParentCategory());
        cat.setSlug(dto.getSlug());
        cat.setPublishedAt(dto.getPublishedAt());
        cat.setCreatedBy(dto.getCreatedBy());
        cat.setUpdatedBy(dto.getUpdatedBy());
        cat.setCreatedAt(dto.getCreatedAt());
        cat.setUpdatedAt(dto.getUpdatedAt());
        return cat;
    }

    private Chat toChat(BChatDTO dto) {
        if (dto == null)
            return null;
        Chat chat = new Chat();
        chat.setId(dto.getId());
        chat.setChannelId(dto.getChannelId());
        chat.setChannelName(dto.getChannelName());
        chat.setChannelImage(dto.getChannelImage());
        chat.setLive(dto.getLive());
        chat.setStartTime(dto.getStartTime());
        chat.setEndTime(dto.getEndTime());
        return chat;
    }

    private EventCollection toCollection(BCollectionDTO dto) {
        if (dto == null)
            return null;
        EventCollection col = new EventCollection();
        col.setId(dto.getId());
        col.setTicker(dto.getTicker());
        col.setSlug(dto.getSlug());
        col.setTitle(dto.getTitle());
        col.setSubtitle(dto.getSubtitle());
        col.setCollectionType(dto.getCollectionType());
        col.setDescription(dto.getDescription());
        col.setTags(dto.getTags());
        col.setImage(dto.getImage());
        col.setIcon(dto.getIcon());
        col.setHeaderImage(dto.getHeaderImage());
        col.setLayout(dto.getLayout());
        col.setActive(dto.getActive());
        col.setClosed(dto.getClosed());
        col.setArchived(dto.getArchived());
        col.setIsNew(dto.getNew());
        col.setFeatured(dto.getFeatured());
        col.setRestricted(dto.getRestricted());
        col.setIsTemplate(dto.getIsTemplate());
        col.setTemplateVariables(dto.getTemplateVariables());
        col.setPublishedAt(dto.getPublishedAt());
        col.setCreatedBy(dto.getCreatedBy());
        col.setUpdatedBy(dto.getUpdatedBy());
        col.setCreatedAt(dto.getCreatedAt());
        col.setUpdatedAt(dto.getUpdatedAt());
        col.setCommentsEnabled(dto.getCommentsEnabled());
        col.setImageOptimized(toImageOptimized(dto.getImageOptimized()));
        col.setIconOptimized(toImageOptimized(dto.getIconOptimized()));
        col.setHeaderImageOptimized(toImageOptimized(dto.getHeaderImageOptimized()));
        return col;
    }

    private EventCreator toEventCreator(BEventCreatorDTO dto) {
        if (dto == null)
            return null;
        EventCreator ec = new EventCreator();
        ec.setId(dto.getId());
        ec.setCreatorName(dto.getCreatorName());
        ec.setCreatorHandle(dto.getCreatorHandle());
        ec.setCreatorUrl(dto.getCreatorUrl());
        ec.setCreatorImage(dto.getCreatorImage());
        ec.setCreatedAt(dto.getCreatedAt());
        ec.setUpdatedAt(dto.getUpdatedAt());
        return ec;
    }

    private Tag toTag(BTagDTO dto) {
        if (dto == null)
            return null;
        Tag tag = new Tag();
        tag.setId(dto.getId());
        tag.setLabel(dto.getLabel());
        tag.setSlug(dto.getSlug());
        tag.setForceShow(dto.getForceShow());
        tag.setPublishedAt(dto.getPublishedAt());
        tag.setCreatedBy(dto.getCreatedBy());
        tag.setUpdatedBy(dto.getUpdatedBy());
        tag.setCreatedAt(dto.getCreatedAt());
        tag.setUpdatedAt(dto.getUpdatedAt());
        tag.setForceHide(dto.getForceHide());
        tag.setIsCarousel(dto.getIsCarousel());
        return tag;
    }

    private Template toTemplate(BTemplateDTO dto) {
        if (dto == null)
            return null;
        Template tmpl = new Template();
        tmpl.setId(dto.getId());
        tmpl.setEventTitle(dto.getEventTitle());
        tmpl.setEventSlug(dto.getEventSlug());
        tmpl.setEventImage(dto.getEventImage());
        tmpl.setMarketTitle(dto.getMarketTitle());
        tmpl.setDescription(dto.getDescription());
        tmpl.setResolutionSource(dto.getResolutionSource());
        tmpl.setNegRisk(dto.getNegRisk());
        tmpl.setSortBy(dto.getSortBy());
        tmpl.setShowMarketImages(dto.getShowMarketImages());
        tmpl.setSeriesSlug(dto.getSeriesSlug());
        tmpl.setOutcomes(dto.getOutcomes());
        return tmpl;
    }

    private FeeSchedule toFeeSchedule(BFeeScheduleDTO dto) {
        if (dto == null)
            return null;
        FeeSchedule fs = new FeeSchedule();
        fs.setExponent(dto.getExponent());
        fs.setRate(dto.getRate());
        fs.setTakerOnly(dto.getTakerOnly());
        fs.setRebateRate(dto.getRebateRate());
        return fs;
    }

    private Market toMarket(BMarketDTO dto) {
        if (dto == null)
            return null;
        Market m = new Market();
        m.setId(dto.getId());
        m.setQuestion(dto.getQuestion());
        m.setConditionId(dto.getConditionId());
        m.setSlug(dto.getSlug());
        m.setTwitterCardImage(dto.getTwitterCardImage());
        m.setResolutionSource(dto.getResolutionSource());
        m.setEndDate(dto.getEndDate());
        m.setCategory(dto.getCategory());
        m.setAmmType(dto.getAmmType());
        m.setLiquidity(dto.getLiquidity());
        m.setSponsorName(dto.getSponsorName());
        m.setSponsorImage(dto.getSponsorImage());
        m.setStartDate(dto.getStartDate());
        m.setXAxisValue(dto.getxAxisValue());
        m.setYAxisValue(dto.getyAxisValue());
        m.setDenominationToken(dto.getDenominationToken());
        m.setFee(dto.getFee());
        m.setImage(dto.getImage());
        m.setIcon(dto.getIcon());
        m.setLowerBound(dto.getLowerBound());
        m.setUpperBound(dto.getUpperBound());
        m.setDescription(dto.getDescription());
        m.setOutcomes(dto.getOutcomes());
        m.setOutcomePrices(dto.getOutcomePrices());
        m.setVolume(dto.getVolume());
        m.setActive(dto.getActive());
        m.setMarketType(dto.getMarketType());
        m.setFormatType(dto.getFormatType());
        m.setLowerBoundDate(dto.getLowerBoundDate());
        m.setUpperBoundDate(dto.getUpperBoundDate());
        m.setClosed(dto.getClosed());
        m.setMarketMakerAddress(dto.getMarketMakerAddress());
        m.setCreatedBy(dto.getCreatedBy());
        m.setUpdatedBy(dto.getUpdatedBy());
        m.setCreatedAt(dto.getCreatedAt());
        m.setUpdatedAt(dto.getUpdatedAt());
        m.setClosedTime(dto.getClosedTime());
        m.setWideFormat(dto.getWideFormat());
        m.setIsNew(dto.getNew());
        m.setMailchimpTag(dto.getMailchimpTag());
        m.setFeatured(dto.getFeatured());
        m.setArchived(dto.getArchived());
        m.setResolvedBy(dto.getResolvedBy());
        m.setRestricted(dto.getRestricted());
        m.setMarketGroup(dto.getMarketGroup());
        m.setGroupItemTitle(dto.getGroupItemTitle());
        m.setGroupItemThreshold(dto.getGroupItemThreshold());
        m.setQuestionID(dto.getQuestionID());
        m.setUmaEndDate(dto.getUmaEndDate());
        m.setEnableOrderBook(dto.getEnableOrderBook());
        m.setOrderPriceMinTickSize(dto.getOrderPriceMinTickSize());
        m.setOrderMinSize(dto.getOrderMinSize());
        m.setUmaResolutionStatus(dto.getUmaResolutionStatus());
        m.setCurationOrder(dto.getCurationOrder());
        m.setVolumeNum(dto.getVolumeNum());
        m.setLiquidityNum(dto.getLiquidityNum());
        m.setEndDateIso(dto.getEndDateIso());
        m.setStartDateIso(dto.getStartDateIso());
        m.setUmaEndDateIso(dto.getUmaEndDateIso());
        m.setHasReviewedDates(dto.getHasReviewedDates());
        m.setReadyForCron(dto.getReadyForCron());
        m.setCommentsEnabled(dto.getCommentsEnabled());
        m.setVolume24hr(dto.getVolume24hr());
        m.setVolume1wk(dto.getVolume1wk());
        m.setVolume1mo(dto.getVolume1mo());
        m.setVolume1yr(dto.getVolume1yr());
        m.setGameStartTime(dto.getGameStartTime());
        m.setSecondsDelay(dto.getSecondsDelay());
        m.setClobTokenIds(dto.getClobTokenIds());
        m.setDisqusThread(dto.getDisqusThread());
        m.setShortOutcomes(dto.getShortOutcomes());
        m.setTeamAID(dto.getTeamAID());
        m.setTeamBID(dto.getTeamBID());
        m.setUmaBond(dto.getUmaBond());
        m.setUmaReward(dto.getUmaReward());
        m.setFpmmLive(dto.getFpmmLive());
        m.setVolume24hrAmm(dto.getVolume24hrAmm());
        m.setVolume1wkAmm(dto.getVolume1wkAmm());
        m.setVolume1moAmm(dto.getVolume1moAmm());
        m.setVolume1yrAmm(dto.getVolume1yrAmm());
        m.setVolume24hrClob(dto.getVolume24hrClob());
        m.setVolume1wkClob(dto.getVolume1wkClob());
        m.setVolume1moClob(dto.getVolume1moClob());
        m.setVolume1yrClob(dto.getVolume1yrClob());
        m.setVolumeAmm(dto.getVolumeAmm());
        m.setVolumeClob(dto.getVolumeClob());
        m.setLiquidityAmm(dto.getLiquidityAmm());
        m.setLiquidityClob(dto.getLiquidityClob());
        m.setMakerBaseFee(dto.getMakerBaseFee());
        m.setTakerBaseFee(dto.getTakerBaseFee());
        m.setCustomLiveness(dto.getCustomLiveness());
        m.setAcceptingOrders(dto.getAcceptingOrders());
        m.setNotificationsEnabled(dto.getNotificationsEnabled());
        m.setScore(dto.getScore());
        m.setImageOptimized(toImageOptimized(dto.getImageOptimized()));
        m.setIconOptimized(toImageOptimized(dto.getIconOptimized()));
        m.setCategories(toCategories(dto.getCategories()));
        m.setTags(toTags(dto.getTags()));
        m.setCreator(dto.getCreator());
        m.setReady(dto.getReady());
        m.setFunded(dto.getFunded());
        m.setPastSlugs(dto.getPastSlugs());
        m.setReadyTimestamp(dto.getReadyTimestamp());
        m.setFundedTimestamp(dto.getFundedTimestamp());
        m.setAcceptingOrdersTimestamp(dto.getAcceptingOrdersTimestamp());
        m.setCompetitive(dto.getCompetitive());
        m.setRewardsMinSize(dto.getRewardsMinSize());
        m.setRewardsMaxSpread(dto.getRewardsMaxSpread());
        m.setSpread(dto.getSpread());
        m.setAutomaticallyResolved(dto.getAutomaticallyResolved());
        m.setOneDayPriceChange(dto.getOneDayPriceChange());
        m.setOneHourPriceChange(dto.getOneHourPriceChange());
        m.setOneWeekPriceChange(dto.getOneWeekPriceChange());
        m.setOneMonthPriceChange(dto.getOneMonthPriceChange());
        m.setOneYearPriceChange(dto.getOneYearPriceChange());
        m.setLastTradePrice(dto.getLastTradePrice());
        m.setBestBid(dto.getBestBid());
        m.setBestAsk(dto.getBestAsk());
        m.setAutomaticallyActive(dto.getAutomaticallyActive());
        m.setClearBookOnStart(dto.getClearBookOnStart());
        m.setChartColor(dto.getChartColor());
        m.setSeriesColor(dto.getSeriesColor());
        m.setShowGmpSeries(dto.getShowGmpSeries());
        m.setShowGmpOutcome(dto.getShowGmpOutcome());
        m.setManualActivation(dto.getManualActivation());
        m.setNegRiskOther(dto.getNegRiskOther());
        m.setGameId(dto.getGameId());
        m.setGroupItemRange(dto.getGroupItemRange());
        m.setSportsMarketType(dto.getSportsMarketType());
        m.setLine(dto.getLine());
        m.setUmaResolutionStatuses(dto.getUmaResolutionStatuses());
        m.setPendingDeployment(dto.getPendingDeployment());
        m.setDeploying(dto.getDeploying());
        m.setDeployingTimestamp(dto.getDeployingTimestamp());
        m.setScheduledDeploymentTimestamp(dto.getScheduledDeploymentTimestamp());
        m.setRfqEnabled(dto.getRfqEnabled());
        m.setEventStartTime(dto.getEventStartTime());
        m.setFeesEnabled(dto.getFeesEnabled());
        m.setFeeSchedule(toFeeSchedule(dto.getFeeSchedule()));

        if (StringUtils.isNotBlank(m.getClobTokenIds())) {
            try {
                JSONArray clobTokenIds = new JSONArray(m.getClobTokenIds());
                String upTokenId = clobTokenIds.getString(0);
                String downTokenId = clobTokenIds.getString(1);

                m.setUpTokenId(upTokenId);
                m.setDownTokenId(downTokenId);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }

        return m;
    }

    private Series toSeries(BSeriesDTO dto) {
        if (dto == null)
            return null;
        Series s = new Series();
        s.setId(dto.getId());
        s.setTicker(dto.getTicker());
        s.setSlug(dto.getSlug());
        s.setTitle(dto.getTitle());
        s.setSubtitle(dto.getSubtitle());
        s.setSeriesType(dto.getSeriesType());
        s.setRecurrence(dto.getRecurrence());
        s.setDescription(dto.getDescription());
        s.setImage(dto.getImage());
        s.setIcon(dto.getIcon());
        s.setLayout(dto.getLayout());
        s.setActive(dto.getActive());
        s.setClosed(dto.getClosed());
        s.setArchived(dto.getArchived());
        s.setIsNew(dto.getNew());
        s.setFeatured(dto.getFeatured());
        s.setRestricted(dto.getRestricted());
        s.setIsTemplate(dto.getIsTemplate());
        s.setTemplateVariables(dto.getTemplateVariables());
        s.setPublishedAt(dto.getPublishedAt());
        s.setCreatedBy(dto.getCreatedBy());
        s.setUpdatedBy(dto.getUpdatedBy());
        s.setCreatedAt(dto.getCreatedAt());
        s.setUpdatedAt(dto.getUpdatedAt());
        s.setCommentsEnabled(dto.getCommentsEnabled());
        s.setCompetitive(dto.getCompetitive());
        s.setVolume24hr(dto.getVolume24hr());
        s.setVolume(dto.getVolume());
        s.setLiquidity(dto.getLiquidity());
        s.setStartDate(dto.getStartDate());
        s.setPythTokenID(dto.getPythTokenID());
        s.setCgAssetName(dto.getCgAssetName());
        s.setScore(dto.getScore());
        s.setCommentCount(dto.getCommentCount());
        s.setCollections(toCollections(dto.getCollections()));
        s.setCategories(toCategories(dto.getCategories()));
        s.setTags(toTags(dto.getTags()));
        s.setChats(toChats(dto.getChats()));
        return s;
    }

    private List<Market> toMarkets(List<BMarketDTO> dtos) {
        if (dtos == null)
            return null;
        return dtos.stream().map(this::toMarket).collect(Collectors.toList());
    }

    private List<Series> toSeriesList(List<BSeriesDTO> dtos) {
        if (dtos == null)
            return null;
        return dtos.stream().map(this::toSeries).collect(Collectors.toList());
    }

    private List<Category> toCategories(List<BCategoryDTO> dtos) {
        if (dtos == null)
            return null;
        return dtos.stream().map(this::toCategory).collect(Collectors.toList());
    }

    private List<EventCollection> toCollections(List<BCollectionDTO> dtos) {
        if (dtos == null)
            return null;
        return dtos.stream().map(this::toCollection).collect(Collectors.toList());
    }

    private List<Tag> toTags(List<BTagDTO> dtos) {
        if (dtos == null)
            return null;
        return dtos.stream().map(this::toTag).collect(Collectors.toList());
    }

    private List<EventCreator> toEventCreators(List<BEventCreatorDTO> dtos) {
        if (dtos == null)
            return null;
        return dtos.stream().map(this::toEventCreator).collect(Collectors.toList());
    }

    private List<Chat> toChats(List<BChatDTO> dtos) {
        if (dtos == null)
            return null;
        return dtos.stream().map(this::toChat).collect(Collectors.toList());
    }

    private List<Template> toTemplates(List<BTemplateDTO> dtos) {
        if (dtos == null)
            return null;
        return dtos.stream().map(this::toTemplate).collect(Collectors.toList());
    }

}
