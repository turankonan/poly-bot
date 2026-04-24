package polymarket.bot.model;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
public class Template {

    @Field(DBConstants.TEMPLATE.ID)
    private String id;

    @Field(DBConstants.TEMPLATE.EVENT_TITLE)
    private String eventTitle;

    @Field(DBConstants.TEMPLATE.EVENT_SLUG)
    private String eventSlug;

    @Field(DBConstants.TEMPLATE.EVENT_IMAGE)
    private String eventImage;

    @Field(DBConstants.TEMPLATE.MARKET_TITLE)
    private String marketTitle;

    @Field(DBConstants.TEMPLATE.DESCRIPTION)
    private String description;

    @Field(DBConstants.TEMPLATE.RESOLUTION_SOURCE)
    private String resolutionSource;

    @Field(DBConstants.TEMPLATE.NEG_RISK)
    private Boolean negRisk;

    @Field(DBConstants.TEMPLATE.SORT_BY)
    private String sortBy;

    @Field(DBConstants.TEMPLATE.SHOW_MARKET_IMAGES)
    private Boolean showMarketImages;

    @Field(DBConstants.TEMPLATE.SERIES_SLUG)
    private String seriesSlug;

    @Field(DBConstants.TEMPLATE.OUTCOMES)
    private String outcomes;

}
