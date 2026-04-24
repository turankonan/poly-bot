package polymarket.bot.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
public class Series {

    @Field(DBConstants.SERIES.ID)
    private String id;

    @Field(DBConstants.SERIES.TICKER)
    private String ticker;

    @Field(DBConstants.SERIES.SLUG)
    private String slug;

    @Field(DBConstants.SERIES.TITLE)
    private String title;

    @Field(DBConstants.SERIES.SUBTITLE)
    private String subtitle;

    @Field(DBConstants.SERIES.SERIES_TYPE)
    private String seriesType;

    @Field(DBConstants.SERIES.RECURRENCE)
    private String recurrence;

    @Field(DBConstants.SERIES.DESCRIPTION)
    private String description;

    @Field(DBConstants.SERIES.IMAGE)
    private String image;

    @Field(DBConstants.SERIES.ICON)
    private String icon;

    @Field(DBConstants.SERIES.LAYOUT)
    private String layout;

    @Field(DBConstants.SERIES.ACTIVE)
    private Boolean active;

    @Field(DBConstants.SERIES.CLOSED)
    private Boolean closed;

    @Field(DBConstants.SERIES.ARCHIVED)
    private Boolean archived;

    @Field(DBConstants.SERIES.IS_NEW)
    private Boolean isNew;

    @Field(DBConstants.SERIES.FEATURED)
    private Boolean featured;

    @Field(DBConstants.SERIES.RESTRICTED)
    private Boolean restricted;

    @Field(DBConstants.SERIES.IS_TEMPLATE)
    private Boolean isTemplate;

    @Field(DBConstants.SERIES.TEMPLATE_VARIABLES)
    private Boolean templateVariables;

    @Field(DBConstants.SERIES.PUBLISHED_AT)
    private String publishedAt;

    @Field(DBConstants.SERIES.CREATED_BY)
    private String createdBy;

    @Field(DBConstants.SERIES.UPDATED_BY)
    private String updatedBy;

    @Field(DBConstants.SERIES.CREATED_AT)
    private LocalDateTime createdAt;

    @Field(DBConstants.SERIES.UPDATED_AT)
    private LocalDateTime updatedAt;

    @Field(DBConstants.SERIES.COMMENTS_ENABLED)
    private Boolean commentsEnabled;

    @Field(DBConstants.SERIES.COMPETITIVE)
    private String competitive;

    @Field(DBConstants.SERIES.VOLUME_24HR)
    private BigDecimal volume24hr;

    @Field(DBConstants.SERIES.VOLUME)
    private BigDecimal volume;

    @Field(DBConstants.SERIES.LIQUIDITY)
    private BigDecimal liquidity;

    @Field(DBConstants.SERIES.START_DATE)
    private LocalDateTime startDate;

    @Field(DBConstants.SERIES.PYTH_TOKEN_ID)
    private String pythTokenID;

    @Field(DBConstants.SERIES.CG_ASSET_NAME)
    private String cgAssetName;

    @Field(DBConstants.SERIES.SCORE)
    private BigDecimal score;

    @Field(DBConstants.SERIES.COMMENT_COUNT)
    private BigDecimal commentCount;

    @Field(DBConstants.SERIES.EVENTS)
    private List<Object> events;

    @Field(DBConstants.SERIES.COLLECTIONS)
    private List<EventCollection> collections;

    @Field(DBConstants.SERIES.CATEGORIES)
    private List<Category> categories;

    @Field(DBConstants.SERIES.TAGS)
    private List<Tag> tags;

    @Field(DBConstants.SERIES.CHATS)
    private List<Chat> chats;

}
