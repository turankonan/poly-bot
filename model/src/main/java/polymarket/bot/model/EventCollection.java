package polymarket.bot.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
public class EventCollection {

    @Field(DBConstants.EVENT_COLLECTION.ID)
    private String id;

    @Field(DBConstants.EVENT_COLLECTION.TICKER)
    private String ticker;

    @Field(DBConstants.EVENT_COLLECTION.SLUG)
    private String slug;

    @Field(DBConstants.EVENT_COLLECTION.TITLE)
    private String title;

    @Field(DBConstants.EVENT_COLLECTION.SUBTITLE)
    private String subtitle;

    @Field(DBConstants.EVENT_COLLECTION.COLLECTION_TYPE)
    private String collectionType;

    @Field(DBConstants.EVENT_COLLECTION.DESCRIPTION)
    private String description;

    @Field(DBConstants.EVENT_COLLECTION.TAGS)
    private String tags;

    @Field(DBConstants.EVENT_COLLECTION.IMAGE)
    private String image;

    @Field(DBConstants.EVENT_COLLECTION.ICON)
    private String icon;

    @Field(DBConstants.EVENT_COLLECTION.HEADER_IMAGE)
    private String headerImage;

    @Field(DBConstants.EVENT_COLLECTION.LAYOUT)
    private String layout;

    @Field(DBConstants.EVENT_COLLECTION.ACTIVE)
    private Boolean active;

    @Field(DBConstants.EVENT_COLLECTION.CLOSED)
    private Boolean closed;

    @Field(DBConstants.EVENT_COLLECTION.ARCHIVED)
    private Boolean archived;

    @Field(DBConstants.EVENT_COLLECTION.IS_NEW)
    private Boolean isNew;

    @Field(DBConstants.EVENT_COLLECTION.FEATURED)
    private Boolean featured;

    @Field(DBConstants.EVENT_COLLECTION.RESTRICTED)
    private Boolean restricted;

    @Field(DBConstants.EVENT_COLLECTION.IS_TEMPLATE)
    private Boolean isTemplate;

    @Field(DBConstants.EVENT_COLLECTION.TEMPLATE_VARIABLES)
    private String templateVariables;

    @Field(DBConstants.EVENT_COLLECTION.PUBLISHED_AT)
    private String publishedAt;

    @Field(DBConstants.EVENT_COLLECTION.CREATED_BY)
    private String createdBy;

    @Field(DBConstants.EVENT_COLLECTION.UPDATED_BY)
    private String updatedBy;

    @Field(DBConstants.EVENT_COLLECTION.CREATED_AT)
    private LocalDateTime createdAt;

    @Field(DBConstants.EVENT_COLLECTION.UPDATED_AT)
    private LocalDateTime updatedAt;

    @Field(DBConstants.EVENT_COLLECTION.COMMENTS_ENABLED)
    private Boolean commentsEnabled;

    @Field(DBConstants.EVENT_COLLECTION.IMAGE_OPTIMIZED)
    private ImageOptimized imageOptimized;

    @Field(DBConstants.EVENT_COLLECTION.ICON_OPTIMIZED)
    private ImageOptimized iconOptimized;

    @Field(DBConstants.EVENT_COLLECTION.HEADER_IMAGE_OPTIMIZED)
    private ImageOptimized headerImageOptimized;

}
