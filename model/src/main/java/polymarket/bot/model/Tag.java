package polymarket.bot.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
public class Tag {

    @Field(DBConstants.TAG.ID)
    private String id;

    @Field(DBConstants.TAG.LABEL)
    private String label;

    @Field(DBConstants.TAG.SLUG)
    private String slug;

    @Field(DBConstants.TAG.FORCE_SHOW)
    private Boolean forceShow;

    @Field(DBConstants.TAG.PUBLISHED_AT)
    private String publishedAt;

    @Field(DBConstants.TAG.CREATED_BY)
    private BigDecimal createdBy;

    @Field(DBConstants.TAG.UPDATED_BY)
    private BigDecimal updatedBy;

    @Field(DBConstants.TAG.CREATED_AT)
    private LocalDateTime createdAt;

    @Field(DBConstants.TAG.UPDATED_AT)
    private LocalDateTime updatedAt;

    @Field(DBConstants.TAG.FORCE_HIDE)
    private Boolean forceHide;

    @Field(DBConstants.TAG.IS_CAROUSEL)
    private Boolean isCarousel;

}
