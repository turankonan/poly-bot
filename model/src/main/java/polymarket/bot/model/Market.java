package polymarket.bot.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
public class Market {

    @Field(DBConstants.MARKET.ID)
    private String id;

    @Field(DBConstants.MARKET.QUESTION)
    private String question;

    @Field(DBConstants.MARKET.CONDITION_ID)
    private String conditionId;

    @Field(DBConstants.MARKET.SLUG)
    private String slug;

    @Field(DBConstants.MARKET.TWITTER_CARD_IMAGE)
    private String twitterCardImage;

    @Field(DBConstants.MARKET.RESOLUTION_SOURCE)
    private String resolutionSource;

    @Field(DBConstants.MARKET.END_DATE)
    private LocalDateTime endDate;

    @Field(DBConstants.MARKET.CATEGORY)
    private String category;

    @Field(DBConstants.MARKET.AMM_TYPE)
    private String ammType;

    @Field(DBConstants.MARKET.LIQUIDITY)
    private String liquidity;

    @Field(DBConstants.MARKET.SPONSOR_NAME)
    private String sponsorName;

    @Field(DBConstants.MARKET.SPONSOR_IMAGE)
    private String sponsorImage;

    @Field(DBConstants.MARKET.START_DATE)
    private LocalDateTime startDate;

    @Field(DBConstants.MARKET.X_AXIS_VALUE)
    private String xAxisValue;

    @Field(DBConstants.MARKET.Y_AXIS_VALUE)
    private String yAxisValue;

    @Field(DBConstants.MARKET.DENOMINATION_TOKEN)
    private String denominationToken;

    @Field(DBConstants.MARKET.FEE)
    private String fee;

    @Field(DBConstants.MARKET.IMAGE)
    private String image;

    @Field(DBConstants.MARKET.ICON)
    private String icon;

    @Field(DBConstants.MARKET.LOWER_BOUND)
    private String lowerBound;

    @Field(DBConstants.MARKET.UPPER_BOUND)
    private String upperBound;

    @Field(DBConstants.MARKET.DESCRIPTION)
    private String description;

    @Field(DBConstants.MARKET.OUTCOMES)
    private String outcomes;

    @Field(DBConstants.MARKET.OUTCOME_PRICES)
    private String outcomePrices;

    @Field(DBConstants.MARKET.VOLUME)
    private String volume;

    @Field(DBConstants.MARKET.ACTIVE)
    private Boolean active;

    @Field(DBConstants.MARKET.MARKET_TYPE)
    private String marketType;

    @Field(DBConstants.MARKET.FORMAT_TYPE)
    private String formatType;

    @Field(DBConstants.MARKET.LOWER_BOUND_DATE)
    private String lowerBoundDate;

    @Field(DBConstants.MARKET.UPPER_BOUND_DATE)
    private String upperBoundDate;

    @Field(DBConstants.MARKET.CLOSED)
    private Boolean closed;

    @Field(DBConstants.MARKET.MARKET_MAKER_ADDRESS)
    private String marketMakerAddress;

    @Field(DBConstants.MARKET.CREATED_BY)
    private BigDecimal createdBy;

    @Field(DBConstants.MARKET.UPDATED_BY)
    private BigDecimal updatedBy;

    @Field(DBConstants.MARKET.CREATED_AT)
    private LocalDateTime createdAt;

    @Field(DBConstants.MARKET.UPDATED_AT)
    private LocalDateTime updatedAt;

    @Field(DBConstants.MARKET.CLOSED_TIME)
    private String closedTime;

    @Field(DBConstants.MARKET.WIDE_FORMAT)
    private Boolean wideFormat;

    @Field(DBConstants.MARKET.IS_NEW)
    private Boolean isNew;

    @Field(DBConstants.MARKET.MAILCHIMP_TAG)
    private String mailchimpTag;

    @Field(DBConstants.MARKET.FEATURED)
    private Boolean featured;

    @Field(DBConstants.MARKET.ARCHIVED)
    private Boolean archived;

    @Field(DBConstants.MARKET.RESOLVED_BY)
    private String resolvedBy;

    @Field(DBConstants.MARKET.RESTRICTED)
    private Boolean restricted;

    @Field(DBConstants.MARKET.MARKET_GROUP)
    private BigDecimal marketGroup;

    @Field(DBConstants.MARKET.GROUP_ITEM_TITLE)
    private String groupItemTitle;

    @Field(DBConstants.MARKET.GROUP_ITEM_THRESHOLD)
    private String groupItemThreshold;

    @Field(DBConstants.MARKET.QUESTION_ID)
    private String questionID;

    @Field(DBConstants.MARKET.UMA_END_DATE)
    private String umaEndDate;

    @Field(DBConstants.MARKET.ENABLE_ORDER_BOOK)
    private Boolean enableOrderBook;

    @Field(DBConstants.MARKET.ORDER_PRICE_MIN_TICK_SIZE)
    private BigDecimal orderPriceMinTickSize;

    @Field(DBConstants.MARKET.ORDER_MIN_SIZE)
    private BigDecimal orderMinSize;

    @Field(DBConstants.MARKET.UMA_RESOLUTION_STATUS)
    private String umaResolutionStatus;

    @Field(DBConstants.MARKET.CURATION_ORDER)
    private BigDecimal curationOrder;

    @Field(DBConstants.MARKET.VOLUME_NUM)
    private BigDecimal volumeNum;

    @Field(DBConstants.MARKET.LIQUIDITY_NUM)
    private BigDecimal liquidityNum;

    @Field(DBConstants.MARKET.END_DATE_ISO)
    private String endDateIso;

    @Field(DBConstants.MARKET.START_DATE_ISO)
    private String startDateIso;

    @Field(DBConstants.MARKET.UMA_END_DATE_ISO)
    private String umaEndDateIso;

    @Field(DBConstants.MARKET.HAS_REVIEWED_DATES)
    private Boolean hasReviewedDates;

    @Field(DBConstants.MARKET.READY_FOR_CRON)
    private Boolean readyForCron;

    @Field(DBConstants.MARKET.COMMENTS_ENABLED)
    private Boolean commentsEnabled;

    @Field(DBConstants.MARKET.VOLUME_24HR)
    private BigDecimal volume24hr;

    @Field(DBConstants.MARKET.VOLUME_1WK)
    private BigDecimal volume1wk;

    @Field(DBConstants.MARKET.VOLUME_1MO)
    private BigDecimal volume1mo;

    @Field(DBConstants.MARKET.VOLUME_1YR)
    private BigDecimal volume1yr;

    @Field(DBConstants.MARKET.GAME_START_TIME)
    private String gameStartTime;

    @Field(DBConstants.MARKET.SECONDS_DELAY)
    private BigDecimal secondsDelay;

    @Field(DBConstants.MARKET.CLOB_TOKEN_IDS)
    private String clobTokenIds;

    @Field(DBConstants.MARKET.DISQUS_THREAD)
    private String disqusThread;

    @Field(DBConstants.MARKET.SHORT_OUTCOMES)
    private String shortOutcomes;

    @Field(DBConstants.MARKET.TEAM_A_ID)
    private String teamAID;

    @Field(DBConstants.MARKET.TEAM_B_ID)
    private String teamBID;

    @Field(DBConstants.MARKET.UMA_BOND)
    private String umaBond;

    @Field(DBConstants.MARKET.UMA_REWARD)
    private String umaReward;

    @Field(DBConstants.MARKET.FPMM_LIVE)
    private Boolean fpmmLive;

    @Field(DBConstants.MARKET.VOLUME_24HR_AMM)
    private BigDecimal volume24hrAmm;

    @Field(DBConstants.MARKET.VOLUME_1WK_AMM)
    private BigDecimal volume1wkAmm;

    @Field(DBConstants.MARKET.VOLUME_1MO_AMM)
    private BigDecimal volume1moAmm;

    @Field(DBConstants.MARKET.VOLUME_1YR_AMM)
    private BigDecimal volume1yrAmm;

    @Field(DBConstants.MARKET.VOLUME_24HR_CLOB)
    private BigDecimal volume24hrClob;

    @Field(DBConstants.MARKET.VOLUME_1WK_CLOB)
    private BigDecimal volume1wkClob;

    @Field(DBConstants.MARKET.VOLUME_1MO_CLOB)
    private BigDecimal volume1moClob;

    @Field(DBConstants.MARKET.VOLUME_1YR_CLOB)
    private BigDecimal volume1yrClob;

    @Field(DBConstants.MARKET.VOLUME_AMM)
    private BigDecimal volumeAmm;

    @Field(DBConstants.MARKET.VOLUME_CLOB)
    private BigDecimal volumeClob;

    @Field(DBConstants.MARKET.LIQUIDITY_AMM)
    private BigDecimal liquidityAmm;

    @Field(DBConstants.MARKET.LIQUIDITY_CLOB)
    private BigDecimal liquidityClob;

    @Field(DBConstants.MARKET.MAKER_BASE_FEE)
    private BigDecimal makerBaseFee;

    @Field(DBConstants.MARKET.TAKER_BASE_FEE)
    private BigDecimal takerBaseFee;

    @Field(DBConstants.MARKET.CUSTOM_LIVENESS)
    private BigDecimal customLiveness;

    @Field(DBConstants.MARKET.ACCEPTING_ORDERS)
    private Boolean acceptingOrders;

    @Field(DBConstants.MARKET.NOTIFICATIONS_ENABLED)
    private Boolean notificationsEnabled;

    @Field(DBConstants.MARKET.SCORE)
    private BigDecimal score;

    @Field(DBConstants.MARKET.IMAGE_OPTIMIZED)
    private ImageOptimized imageOptimized;

    @Field(DBConstants.MARKET.ICON_OPTIMIZED)
    private ImageOptimized iconOptimized;

    @Field(DBConstants.MARKET.EVENTS)
    private List<Object> events;

    @Field(DBConstants.MARKET.CATEGORIES)
    private List<Category> categories;

    @Field(DBConstants.MARKET.TAGS)
    private List<Tag> tags;

    @Field(DBConstants.MARKET.CREATOR)
    private String creator;

    @Field(DBConstants.MARKET.READY)
    private Boolean ready;

    @Field(DBConstants.MARKET.FUNDED)
    private Boolean funded;

    @Field(DBConstants.MARKET.PAST_SLUGS)
    private String pastSlugs;

    @Field(DBConstants.MARKET.READY_TIMESTAMP)
    private LocalDateTime readyTimestamp;

    @Field(DBConstants.MARKET.FUNDED_TIMESTAMP)
    private LocalDateTime fundedTimestamp;

    @Field(DBConstants.MARKET.ACCEPTING_ORDERS_TIMESTAMP)
    private LocalDateTime acceptingOrdersTimestamp;

    @Field(DBConstants.MARKET.COMPETITIVE)
    private BigDecimal competitive;

    @Field(DBConstants.MARKET.REWARDS_MIN_SIZE)
    private BigDecimal rewardsMinSize;

    @Field(DBConstants.MARKET.REWARDS_MAX_SPREAD)
    private BigDecimal rewardsMaxSpread;

    @Field(DBConstants.MARKET.SPREAD)
    private BigDecimal spread;

    @Field(DBConstants.MARKET.AUTOMATICALLY_RESOLVED)
    private Boolean automaticallyResolved;

    @Field(DBConstants.MARKET.ONE_DAY_PRICE_CHANGE)
    private BigDecimal oneDayPriceChange;

    @Field(DBConstants.MARKET.ONE_HOUR_PRICE_CHANGE)
    private BigDecimal oneHourPriceChange;

    @Field(DBConstants.MARKET.ONE_WEEK_PRICE_CHANGE)
    private BigDecimal oneWeekPriceChange;

    @Field(DBConstants.MARKET.ONE_MONTH_PRICE_CHANGE)
    private BigDecimal oneMonthPriceChange;

    @Field(DBConstants.MARKET.ONE_YEAR_PRICE_CHANGE)
    private BigDecimal oneYearPriceChange;

    @Field(DBConstants.MARKET.LAST_TRADE_PRICE)
    private BigDecimal lastTradePrice;

    @Field(DBConstants.MARKET.BEST_BID)
    private BigDecimal bestBid;

    @Field(DBConstants.MARKET.BEST_ASK)
    private BigDecimal bestAsk;

    @Field(DBConstants.MARKET.AUTOMATICALLY_ACTIVE)
    private Boolean automaticallyActive;

    @Field(DBConstants.MARKET.CLEAR_BOOK_ON_START)
    private Boolean clearBookOnStart;

    @Field(DBConstants.MARKET.CHART_COLOR)
    private String chartColor;

    @Field(DBConstants.MARKET.SERIES_COLOR)
    private String seriesColor;

    @Field(DBConstants.MARKET.SHOW_GMP_SERIES)
    private Boolean showGmpSeries;

    @Field(DBConstants.MARKET.SHOW_GMP_OUTCOME)
    private Boolean showGmpOutcome;

    @Field(DBConstants.MARKET.MANUAL_ACTIVATION)
    private Boolean manualActivation;

    @Field(DBConstants.MARKET.NEG_RISK_OTHER)
    private Boolean negRiskOther;

    @Field(DBConstants.MARKET.GAME_ID)
    private String gameId;

    @Field(DBConstants.MARKET.GROUP_ITEM_RANGE)
    private String groupItemRange;

    @Field(DBConstants.MARKET.SPORTS_MARKET_TYPE)
    private String sportsMarketType;

    @Field(DBConstants.MARKET.LINE)
    private BigDecimal line;

    @Field(DBConstants.MARKET.UMA_RESOLUTION_STATUSES)
    private String umaResolutionStatuses;

    @Field(DBConstants.MARKET.PENDING_DEPLOYMENT)
    private Boolean pendingDeployment;

    @Field(DBConstants.MARKET.DEPLOYING)
    private Boolean deploying;

    @Field(DBConstants.MARKET.DEPLOYING_TIMESTAMP)
    private LocalDateTime deployingTimestamp;

    @Field(DBConstants.MARKET.SCHEDULED_DEPLOYMENT_TIMESTAMP)
    private LocalDateTime scheduledDeploymentTimestamp;

    @Field(DBConstants.MARKET.RFQ_ENABLED)
    private Boolean rfqEnabled;

    @Field(DBConstants.MARKET.EVENT_START_TIME)
    private LocalDateTime eventStartTime;

    @Field(DBConstants.MARKET.FEES_ENABLED)
    private Boolean feesEnabled;

    @Field(DBConstants.MARKET.FEE_SCHEDULE)
    private FeeSchedule feeSchedule;

}
