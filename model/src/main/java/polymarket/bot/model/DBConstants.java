package polymarket.bot.model;

public interface DBConstants {

    interface BASE {
        String CREATE_DATE = "createDate";
        String UPDATE_DATE = "updateDate";
        String CREATE_USER = "createUser";
        String UPDATE_USER = "updateUser";
        String EXTERNAL_ID = "externalId";
        String SOURCE = "source";
        String STATUS = "status";
        String AR_SA = "arSA";
        String EN_US = "enUS";
    }

    interface EVENT {
        String COLLECTION_NAME = "event";
        String TICKER = "ticker";
        String SLUG = "slug";
        String UP_TOKEN_ID = "upTokenId";
        String DOWN_TOKEN_ID = "downTokenId";
        String TITLE = "title";
        String SUBTITLE = "subtitle";
        String DESCRIPTION = "description";
        String RESOLUTION_SOURCE = "resolutionSource";
        String START_DATE = "startDate";
        String CREATION_DATE = "creationDate";
        String END_DATE = "endDate";
        String IMAGE = "image";
        String ICON = "icon";
        String ACTIVE = "active";
        String CLOSED = "closed";
        String ARCHIVED = "archived";
        String IS_NEW = "new";
        String FEATURED = "featured";
        String RESTRICTED = "restricted";
        String LIQUIDITY = "liquidity";
        String VOLUME = "volume";
        String OPEN_INTEREST = "openInterest";
        String SORT_BY = "sortBy";
        String CATEGORY = "category";
        String SUBCATEGORY = "subcategory";
        String IS_TEMPLATE = "isTemplate";
        String TEMPLATE_VARIABLES = "templateVariables";
        String PUBLISHED_AT = "published_at";
        String COMMENTS_ENABLED = "commentsEnabled";
        String COMPETITIVE = "competitive";
        String VOLUME_24HR = "volume24hr";
        String VOLUME_1WK = "volume1wk";
        String VOLUME_1MO = "volume1mo";
        String VOLUME_1YR = "volume1yr";
        String FEATURED_IMAGE = "featuredImage";
        String DISQUS_THREAD = "disqusThread";
        String PARENT_EVENT = "parentEvent";
        String ENABLE_ORDER_BOOK = "enableOrderBook";
        String LIQUIDITY_AMM = "liquidityAmm";
        String LIQUIDITY_CLOB = "liquidityClob";
        String NEG_RISK = "negRisk";
        String NEG_RISK_MARKET_ID = "negRiskMarketID";
        String NEG_RISK_FEE_BIPS = "negRiskFeeBips";
        String COMMENT_COUNT = "commentCount";
        String SUB_EVENTS = "subEvents";
        String CYOM = "cyom";
        String CLOSED_TIME = "closedTime";
        String SHOW_ALL_OUTCOMES = "showAllOutcomes";
        String SHOW_MARKET_IMAGES = "showMarketImages";
        String AUTOMATICALLY_RESOLVED = "automaticallyResolved";
        String ENABLE_NEG_RISK = "enableNegRisk";
        String AUTOMATICALLY_ACTIVE = "automaticallyActive";
        String EVENT_DATE = "eventDate";
        String START_TIME = "startTime";
        String EVENT_WEEK = "eventWeek";
        String SERIES_SLUG = "seriesSlug";
        String SCORE = "score";
        String ELAPSED = "elapsed";
        String PERIOD = "period";
        String LIVE = "live";
        String ENDED = "ended";
        String FINISHED_TIMESTAMP = "finishedTimestamp";
        String GMP_CHART_MODE = "gmpChartMode";
        String TWEET_COUNT = "tweetCount";
        String FEATURED_ORDER = "featuredOrder";
        String ESTIMATE_VALUE = "estimateValue";
        String CANT_ESTIMATE = "cantEstimate";
        String ESTIMATED_VALUE = "estimatedValue";
        String SPREADS_MAIN_LINE = "spreadsMainLine";
        String TOTALS_MAIN_LINE = "totalsMainLine";
        String CAROUSEL_MAP = "carouselMap";
        String PENDING_DEPLOYMENT = "pendingDeployment";
        String DEPLOYING = "deploying";
        String DEPLOYING_TIMESTAMP = "deployingTimestamp";
        String SCHEDULED_DEPLOYMENT_TIMESTAMP = "scheduledDeploymentTimestamp";
        String GAME_STATUS = "gameStatus";
        String IMAGE_OPTIMIZED = "imageOptimized";
        String ICON_OPTIMIZED = "iconOptimized";
        String FEATURED_IMAGE_OPTIMIZED = "featuredImageOptimized";
        String MARKETS = "markets";
        String SERIES = "series";
        String CATEGORIES = "categories";
        String COLLECTIONS = "collections";
        String TAGS = "tags";
        String EVENT_CREATORS = "eventCreators";
        String CHATS = "chats";
        String TEMPLATES = "templates";
    }

    interface IMAGE_OPTIMIZED {
        String IMAGE_URL_SOURCE = "imageUrlSource";
        String IMAGE_URL_OPTIMIZED = "imageUrlOptimized";
        String IMAGE_SIZE_KB_SOURCE = "imageSizeKbSource";
        String IMAGE_SIZE_KB_OPTIMIZED = "imageSizeKbOptimized";
        String IMAGE_OPTIMIZED_COMPLETE = "imageOptimizedComplete";
        String IMAGE_OPTIMIZED_LAST_UPDATED = "imageOptimizedLastUpdated";
        String REL_ID = "relID";
        String FIELD = "field";
        String RELNAME = "relname";
    }

    interface EVENT_MARKET_PRICE {
        String COLLECTION_NAME = "eventMarketPrice";
        String SLUG = "slug";
        String TOKEN_ID = "tokenId";
        String SELL_PRICE = "sellPrice";
        String BUY_PRICE = "buyPrice";
        String SIDE = "side";
    }

    interface CATEGORY {
        String ID = "id";
        String LABEL = "label";
        String PARENT_CATEGORY = "parentCategory";
        String SLUG = "slug";
        String PUBLISHED_AT = "publishedAt";
        String CREATED_BY = "createdBy";
        String UPDATED_BY = "updatedBy";
        String CREATED_AT = "createdAt";
        String UPDATED_AT = "updatedAt";
    }

    interface CHAT {
        String ID = "id";
        String CHANNEL_ID = "channelId";
        String CHANNEL_NAME = "channelName";
        String CHANNEL_IMAGE = "channelImage";
        String LIVE = "live";
        String START_TIME = "startTime";
        String END_TIME = "endTime";
    }

    interface EVENT_COLLECTION {
        String ID = "id";
        String TICKER = "ticker";
        String SLUG = "slug";
        String TITLE = "title";
        String SUBTITLE = "subtitle";
        String COLLECTION_TYPE = "collectionType";
        String DESCRIPTION = "description";
        String TAGS = "tags";
        String IMAGE = "image";
        String ICON = "icon";
        String HEADER_IMAGE = "headerImage";
        String LAYOUT = "layout";
        String ACTIVE = "active";
        String CLOSED = "closed";
        String ARCHIVED = "archived";
        String IS_NEW = "new";
        String FEATURED = "featured";
        String RESTRICTED = "restricted";
        String IS_TEMPLATE = "isTemplate";
        String TEMPLATE_VARIABLES = "templateVariables";
        String PUBLISHED_AT = "publishedAt";
        String CREATED_BY = "createdBy";
        String UPDATED_BY = "updatedBy";
        String CREATED_AT = "createdAt";
        String UPDATED_AT = "updatedAt";
        String COMMENTS_ENABLED = "commentsEnabled";
        String IMAGE_OPTIMIZED = "imageOptimized";
        String ICON_OPTIMIZED = "iconOptimized";
        String HEADER_IMAGE_OPTIMIZED = "headerImageOptimized";
    }

    interface EVENT_CREATOR {
        String ID = "id";
        String CREATOR_NAME = "creatorName";
        String CREATOR_HANDLE = "creatorHandle";
        String CREATOR_URL = "creatorUrl";
        String CREATOR_IMAGE = "creatorImage";
        String CREATED_AT = "createdAt";
        String UPDATED_AT = "updatedAt";
    }

    interface SERIES {
        String ID = "id";
        String TICKER = "ticker";
        String SLUG = "slug";
        String TITLE = "title";
        String SUBTITLE = "subtitle";
        String SERIES_TYPE = "seriesType";
        String RECURRENCE = "recurrence";
        String DESCRIPTION = "description";
        String IMAGE = "image";
        String ICON = "icon";
        String LAYOUT = "layout";
        String ACTIVE = "active";
        String CLOSED = "closed";
        String ARCHIVED = "archived";
        String IS_NEW = "new";
        String FEATURED = "featured";
        String RESTRICTED = "restricted";
        String IS_TEMPLATE = "isTemplate";
        String TEMPLATE_VARIABLES = "templateVariables";
        String PUBLISHED_AT = "publishedAt";
        String CREATED_BY = "createdBy";
        String UPDATED_BY = "updatedBy";
        String CREATED_AT = "createdAt";
        String UPDATED_AT = "updatedAt";
        String COMMENTS_ENABLED = "commentsEnabled";
        String COMPETITIVE = "competitive";
        String VOLUME_24HR = "volume24hr";
        String VOLUME = "volume";
        String LIQUIDITY = "liquidity";
        String START_DATE = "startDate";
        String PYTH_TOKEN_ID = "pythTokenID";
        String CG_ASSET_NAME = "cgAssetName";
        String SCORE = "score";
        String COMMENT_COUNT = "commentCount";
        String EVENTS = "events";
        String COLLECTIONS = "collections";
        String CATEGORIES = "categories";
        String TAGS = "tags";
        String CHATS = "chats";
    }

    interface TAG {
        String ID = "id";
        String LABEL = "label";
        String SLUG = "slug";
        String FORCE_SHOW = "forceShow";
        String PUBLISHED_AT = "publishedAt";
        String CREATED_BY = "createdBy";
        String UPDATED_BY = "updatedBy";
        String CREATED_AT = "createdAt";
        String UPDATED_AT = "updatedAt";
        String FORCE_HIDE = "forceHide";
        String IS_CAROUSEL = "isCarousel";
    }

    interface TEMPLATE {
        String ID = "id";
        String EVENT_TITLE = "eventTitle";
        String EVENT_SLUG = "eventSlug";
        String EVENT_IMAGE = "eventImage";
        String MARKET_TITLE = "marketTitle";
        String DESCRIPTION = "description";
        String RESOLUTION_SOURCE = "resolutionSource";
        String NEG_RISK = "negRisk";
        String SORT_BY = "sortBy";
        String SHOW_MARKET_IMAGES = "showMarketImages";
        String SERIES_SLUG = "seriesSlug";
        String OUTCOMES = "outcomes";
    }

    interface FEE_SCHEDULE {
        String EXPONENT = "exponent";
        String RATE = "rate";
        String TAKER_ONLY = "takerOnly";
        String REBATE_RATE = "rebateRate";
    }

    interface MARKET {
        String ID = "id";
        String QUESTION = "question";
        String CONDITION_ID = "conditionId";
        String SLUG = "slug";
        String UP_TOKEN_ID = "upTokenId";
        String DOWN_TOKEN_ID = "downTokenId";
        String TWITTER_CARD_IMAGE = "twitterCardImage";
        String RESOLUTION_SOURCE = "resolutionSource";
        String END_DATE = "endDate";
        String CATEGORY = "category";
        String AMM_TYPE = "ammType";
        String LIQUIDITY = "liquidity";
        String SPONSOR_NAME = "sponsorName";
        String SPONSOR_IMAGE = "sponsorImage";
        String START_DATE = "startDate";
        String X_AXIS_VALUE = "xAxisValue";
        String Y_AXIS_VALUE = "yAxisValue";
        String DENOMINATION_TOKEN = "denominationToken";
        String FEE = "fee";
        String IMAGE = "image";
        String ICON = "icon";
        String LOWER_BOUND = "lowerBound";
        String UPPER_BOUND = "upperBound";
        String DESCRIPTION = "description";
        String OUTCOMES = "outcomes";
        String OUTCOME_PRICES = "outcomePrices";
        String VOLUME = "volume";
        String ACTIVE = "active";
        String MARKET_TYPE = "marketType";
        String FORMAT_TYPE = "formatType";
        String LOWER_BOUND_DATE = "lowerBoundDate";
        String UPPER_BOUND_DATE = "upperBoundDate";
        String CLOSED = "closed";
        String MARKET_MAKER_ADDRESS = "marketMakerAddress";
        String CREATED_BY = "createdBy";
        String UPDATED_BY = "updatedBy";
        String CREATED_AT = "createdAt";
        String UPDATED_AT = "updatedAt";
        String CLOSED_TIME = "closedTime";
        String WIDE_FORMAT = "wideFormat";
        String IS_NEW = "new";
        String MAILCHIMP_TAG = "mailchimpTag";
        String FEATURED = "featured";
        String ARCHIVED = "archived";
        String RESOLVED_BY = "resolvedBy";
        String RESTRICTED = "restricted";
        String MARKET_GROUP = "marketGroup";
        String GROUP_ITEM_TITLE = "groupItemTitle";
        String GROUP_ITEM_THRESHOLD = "groupItemThreshold";
        String QUESTION_ID = "questionID";
        String UMA_END_DATE = "umaEndDate";
        String ENABLE_ORDER_BOOK = "enableOrderBook";
        String ORDER_PRICE_MIN_TICK_SIZE = "orderPriceMinTickSize";
        String ORDER_MIN_SIZE = "orderMinSize";
        String UMA_RESOLUTION_STATUS = "umaResolutionStatus";
        String CURATION_ORDER = "curationOrder";
        String VOLUME_NUM = "volumeNum";
        String LIQUIDITY_NUM = "liquidityNum";
        String END_DATE_ISO = "endDateIso";
        String START_DATE_ISO = "startDateIso";
        String UMA_END_DATE_ISO = "umaEndDateIso";
        String HAS_REVIEWED_DATES = "hasReviewedDates";
        String READY_FOR_CRON = "readyForCron";
        String COMMENTS_ENABLED = "commentsEnabled";
        String VOLUME_24HR = "volume24hr";
        String VOLUME_1WK = "volume1wk";
        String VOLUME_1MO = "volume1mo";
        String VOLUME_1YR = "volume1yr";
        String GAME_START_TIME = "gameStartTime";
        String SECONDS_DELAY = "secondsDelay";
        String CLOB_TOKEN_IDS = "clobTokenIds";
        String DISQUS_THREAD = "disqusThread";
        String SHORT_OUTCOMES = "shortOutcomes";
        String TEAM_A_ID = "teamAID";
        String TEAM_B_ID = "teamBID";
        String UMA_BOND = "umaBond";
        String UMA_REWARD = "umaReward";
        String FPMM_LIVE = "fpmmLive";
        String VOLUME_24HR_AMM = "volume24hrAmm";
        String VOLUME_1WK_AMM = "volume1wkAmm";
        String VOLUME_1MO_AMM = "volume1moAmm";
        String VOLUME_1YR_AMM = "volume1yrAmm";
        String VOLUME_24HR_CLOB = "volume24hrClob";
        String VOLUME_1WK_CLOB = "volume1wkClob";
        String VOLUME_1MO_CLOB = "volume1moClob";
        String VOLUME_1YR_CLOB = "volume1yrClob";
        String VOLUME_AMM = "volumeAmm";
        String VOLUME_CLOB = "volumeClob";
        String LIQUIDITY_AMM = "liquidityAmm";
        String LIQUIDITY_CLOB = "liquidityClob";
        String MAKER_BASE_FEE = "makerBaseFee";
        String TAKER_BASE_FEE = "takerBaseFee";
        String CUSTOM_LIVENESS = "customLiveness";
        String ACCEPTING_ORDERS = "acceptingOrders";
        String NOTIFICATIONS_ENABLED = "notificationsEnabled";
        String SCORE = "score";
        String IMAGE_OPTIMIZED = "imageOptimized";
        String ICON_OPTIMIZED = "iconOptimized";
        String EVENTS = "events";
        String CATEGORIES = "categories";
        String TAGS = "tags";
        String CREATOR = "creator";
        String READY = "ready";
        String FUNDED = "funded";
        String PAST_SLUGS = "pastSlugs";
        String READY_TIMESTAMP = "readyTimestamp";
        String FUNDED_TIMESTAMP = "fundedTimestamp";
        String ACCEPTING_ORDERS_TIMESTAMP = "acceptingOrdersTimestamp";
        String COMPETITIVE = "competitive";
        String REWARDS_MIN_SIZE = "rewardsMinSize";
        String REWARDS_MAX_SPREAD = "rewardsMaxSpread";
        String SPREAD = "spread";
        String AUTOMATICALLY_RESOLVED = "automaticallyResolved";
        String ONE_DAY_PRICE_CHANGE = "oneDayPriceChange";
        String ONE_HOUR_PRICE_CHANGE = "oneHourPriceChange";
        String ONE_WEEK_PRICE_CHANGE = "oneWeekPriceChange";
        String ONE_MONTH_PRICE_CHANGE = "oneMonthPriceChange";
        String ONE_YEAR_PRICE_CHANGE = "oneYearPriceChange";
        String LAST_TRADE_PRICE = "lastTradePrice";
        String BEST_BID = "bestBid";
        String BEST_ASK = "bestAsk";
        String AUTOMATICALLY_ACTIVE = "automaticallyActive";
        String CLEAR_BOOK_ON_START = "clearBookOnStart";
        String CHART_COLOR = "chartColor";
        String SERIES_COLOR = "seriesColor";
        String SHOW_GMP_SERIES = "showGmpSeries";
        String SHOW_GMP_OUTCOME = "showGmpOutcome";
        String MANUAL_ACTIVATION = "manualActivation";
        String NEG_RISK_OTHER = "negRiskOther";
        String GAME_ID = "gameId";
        String GROUP_ITEM_RANGE = "groupItemRange";
        String SPORTS_MARKET_TYPE = "sportsMarketType";
        String LINE = "line";
        String UMA_RESOLUTION_STATUSES = "umaResolutionStatuses";
        String PENDING_DEPLOYMENT = "pendingDeployment";
        String DEPLOYING = "deploying";
        String DEPLOYING_TIMESTAMP = "deployingTimestamp";
        String SCHEDULED_DEPLOYMENT_TIMESTAMP = "scheduledDeploymentTimestamp";
        String RFQ_ENABLED = "rfqEnabled";
        String EVENT_START_TIME = "eventStartTime";
        String FEES_ENABLED = "feesEnabled";
        String FEE_SCHEDULE = "feeSchedule";
    }

}
