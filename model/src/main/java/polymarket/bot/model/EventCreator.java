package polymarket.bot.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
public class EventCreator {

    @Field(DBConstants.EVENT_CREATOR.ID)
    private String id;

    @Field(DBConstants.EVENT_CREATOR.CREATOR_NAME)
    private String creatorName;

    @Field(DBConstants.EVENT_CREATOR.CREATOR_HANDLE)
    private String creatorHandle;

    @Field(DBConstants.EVENT_CREATOR.CREATOR_URL)
    private String creatorUrl;

    @Field(DBConstants.EVENT_CREATOR.CREATOR_IMAGE)
    private String creatorImage;

    @Field(DBConstants.EVENT_CREATOR.CREATED_AT)
    private LocalDateTime createdAt;

    @Field(DBConstants.EVENT_CREATOR.UPDATED_AT)
    private LocalDateTime updatedAt;

}
