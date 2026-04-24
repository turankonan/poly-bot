package polymarket.bot.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
public class Category {

    @Field(DBConstants.CATEGORY.ID)
    private String id;

    @Field(DBConstants.CATEGORY.LABEL)
    private String label;

    @Field(DBConstants.CATEGORY.PARENT_CATEGORY)
    private String parentCategory;

    @Field(DBConstants.CATEGORY.SLUG)
    private String slug;

    @Field(DBConstants.CATEGORY.PUBLISHED_AT)
    private String publishedAt;

    @Field(DBConstants.CATEGORY.CREATED_BY)
    private String createdBy;

    @Field(DBConstants.CATEGORY.UPDATED_BY)
    private String updatedBy;

    @Field(DBConstants.CATEGORY.CREATED_AT)
    private LocalDateTime createdAt;

    @Field(DBConstants.CATEGORY.UPDATED_AT)
    private LocalDateTime updatedAt;

}
