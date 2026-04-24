package polymarket.bot.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(DBConstants.EVENT.COLLECTION_NAME)
public class Event extends BaseObject {

    @Field(DBConstants.EVENT.TICKER)
    private String ticker;

    @Field(DBConstants.EVENT.SLUG)
    private String slug;

    @Field(DBConstants.EVENT.TITLE)
    private String title;

    @Field(DBConstants.EVENT.SUBTITLE)
    private String subtitle;

    @Field(DBConstants.EVENT.DESCRIPTION)
    private String description;

    @Field(DBConstants.EVENT.RESOLUTION_SOURCE)
    private String resolutionSource;

    @Field(DBConstants.EVENT.START_DATE)
    private LocalDateTime startDate;

    @Field(DBConstants.EVENT.CREATION_DATE)
    private LocalDateTime creationDate;

    @Field(DBConstants.EVENT.END_DATE)
    private LocalDateTime endDate;

    @Field(DBConstants.EVENT.IMAGE)
    private String image;

    @Field(DBConstants.EVENT.ICON)
    private String icon;

    @Field(DBConstants.EVENT.ACTIVE)
    private Boolean active;

    @Field(DBConstants.EVENT.CLOSED)
    private Boolean closed;

    @Field(DBConstants.EVENT.ARCHIVED)
    private Boolean archived;

    @Field(DBConstants.EVENT.IS_NEW)
    private Boolean isNew;

    @Field(DBConstants.EVENT.FEATURED)
    private Boolean featured;

    @Field(DBConstants.EVENT.RESTRICTED)
    private Boolean restricted;

    @Field(DBConstants.EVENT.LIQUIDITY)
    private BigDecimal liquidity;

    @Field(DBConstants.EVENT.VOLUME)
    private BigDecimal volume;

    @Field(DBConstants.EVENT.OPEN_INTEREST)
    private BigDecimal openInterest;

    @Field(DBConstants.EVENT.SORT_BY)
    private String sortBy;

    @Field(DBConstants.EVENT.CATEGORY)
    private String category;

    @Field(DBConstants.EVENT.SUBCATEGORY)
    private String subcategory;

    @Field(DBConstants.EVENT.IS_TEMPLATE)
    private Boolean isTemplate;

    @Field(DBConstants.EVENT.TEMPLATE_VARIABLES)
    private String templateVariables;

    @Field(DBConstants.EVENT.PUBLISHED_AT)
    private String publishedAt;

    @Field(DBConstants.EVENT.COMMENTS_ENABLED)
    private Boolean commentsEnabled;

    @Field(DBConstants.EVENT.COMPETITIVE)
    private BigDecimal competitive;

    @Field(DBConstants.EVENT.VOLUME_24HR)
    private BigDecimal volume24hr;

    @Field(DBConstants.EVENT.VOLUME_1WK)
    private BigDecimal volume1wk;

    @Field(DBConstants.EVENT.VOLUME_1MO)
    private BigDecimal volume1mo;

    @Field(DBConstants.EVENT.VOLUME_1YR)
    private BigDecimal volume1yr;

    @Field(DBConstants.EVENT.FEATURED_IMAGE)
    private String featuredImage;

    @Field(DBConstants.EVENT.DISQUS_THREAD)
    private String disqusThread;

    @Field(DBConstants.EVENT.PARENT_EVENT)
    private String parentEvent;

    @Field(DBConstants.EVENT.ENABLE_ORDER_BOOK)
    private Boolean enableOrderBook;

    @Field(DBConstants.EVENT.LIQUIDITY_AMM)
    private BigDecimal liquidityAmm;

    @Field(DBConstants.EVENT.LIQUIDITY_CLOB)
    private BigDecimal liquidityClob;

    @Field(DBConstants.EVENT.NEG_RISK)
    private Boolean negRisk;

    @Field(DBConstants.EVENT.NEG_RISK_MARKET_ID)
    private String negRiskMarketID;

    @Field(DBConstants.EVENT.NEG_RISK_FEE_BIPS)
    private BigDecimal negRiskFeeBips;

    @Field(DBConstants.EVENT.COMMENT_COUNT)
    private BigDecimal commentCount;

    @Field(DBConstants.EVENT.SUB_EVENTS)
    private List<String> subEvents;

    @Field(DBConstants.EVENT.CYOM)
    private Boolean cyom;

    @Field(DBConstants.EVENT.CLOSED_TIME)
    private LocalDateTime closedTime;

    @Field(DBConstants.EVENT.SHOW_ALL_OUTCOMES)
    private Boolean showAllOutcomes;

    @Field(DBConstants.EVENT.SHOW_MARKET_IMAGES)
    private Boolean showMarketImages;

    @Field(DBConstants.EVENT.AUTOMATICALLY_RESOLVED)
    private Boolean automaticallyResolved;

    @Field(DBConstants.EVENT.ENABLE_NEG_RISK)
    private Boolean enableNegRisk;

    @Field(DBConstants.EVENT.AUTOMATICALLY_ACTIVE)
    private Boolean automaticallyActive;

    @Field(DBConstants.EVENT.EVENT_DATE)
    private String eventDate;

    @Field(DBConstants.EVENT.START_TIME)
    private LocalDateTime startTime;

    @Field(DBConstants.EVENT.EVENT_WEEK)
    private BigDecimal eventWeek;

    @Field(DBConstants.EVENT.SERIES_SLUG)
    private String seriesSlug;

    @Field(DBConstants.EVENT.SCORE)
    private String score;

    @Field(DBConstants.EVENT.ELAPSED)
    private String elapsed;

    @Field(DBConstants.EVENT.PERIOD)
    private String period;

    @Field(DBConstants.EVENT.LIVE)
    private Boolean live;

    @Field(DBConstants.EVENT.ENDED)
    private Boolean ended;

    @Field(DBConstants.EVENT.FINISHED_TIMESTAMP)
    private LocalDateTime finishedTimestamp;

    @Field(DBConstants.EVENT.GMP_CHART_MODE)
    private String gmpChartMode;

    @Field(DBConstants.EVENT.TWEET_COUNT)
    private BigDecimal tweetCount;

    @Field(DBConstants.EVENT.FEATURED_ORDER)
    private BigDecimal featuredOrder;

    @Field(DBConstants.EVENT.ESTIMATE_VALUE)
    private Boolean estimateValue;

    @Field(DBConstants.EVENT.CANT_ESTIMATE)
    private Boolean cantEstimate;

    @Field(DBConstants.EVENT.ESTIMATED_VALUE)
    private String estimatedValue;

    @Field(DBConstants.EVENT.SPREADS_MAIN_LINE)
    private BigDecimal spreadsMainLine;

    @Field(DBConstants.EVENT.TOTALS_MAIN_LINE)
    private BigDecimal totalsMainLine;

    @Field(DBConstants.EVENT.CAROUSEL_MAP)
    private String carouselMap;

    @Field(DBConstants.EVENT.PENDING_DEPLOYMENT)
    private Boolean pendingDeployment;

    @Field(DBConstants.EVENT.DEPLOYING)
    private Boolean deploying;

    @Field(DBConstants.EVENT.DEPLOYING_TIMESTAMP)
    private LocalDateTime deployingTimestamp;

    @Field(DBConstants.EVENT.SCHEDULED_DEPLOYMENT_TIMESTAMP)
    private LocalDateTime scheduledDeploymentTimestamp;

    @Field(DBConstants.EVENT.GAME_STATUS)
    private String gameStatus;

    @Field(DBConstants.EVENT.IMAGE_OPTIMIZED)
    private ImageOptimized imageOptimized;

    @Field(DBConstants.EVENT.ICON_OPTIMIZED)
    private ImageOptimized iconOptimized;

    @Field(DBConstants.EVENT.FEATURED_IMAGE_OPTIMIZED)
    private ImageOptimized featuredImageOptimized;

    @Field(DBConstants.EVENT.MARKETS)
    private List<Market> markets;

    @Field(DBConstants.EVENT.SERIES)
    private List<Series> series;

    @Field(DBConstants.EVENT.CATEGORIES)
    private List<Category> categories;

    @Field(DBConstants.EVENT.COLLECTIONS)
    private List<EventCollection> collections;

    @Field(DBConstants.EVENT.TAGS)
    private List<Tag> tags;

    @Field(DBConstants.EVENT.EVENT_CREATORS)
    private List<EventCreator> eventCreators;

    @Field(DBConstants.EVENT.CHATS)
    private List<Chat> chats;

    @Field(DBConstants.EVENT.TEMPLATES)
    private List<Template> templates;

}
