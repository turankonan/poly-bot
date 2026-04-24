package polymarket.bot.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(DBConstants.EVENT.COLLECTION_NAME)
public class Event extends BaseObject {

    @Field(DBConstants.EVENT.ESTIMATED_RESULT)
    private String estimatedResult;

    @Field(DBConstants.EVENT.TICKER)
    private String ticker;

    @Field(DBConstants.EVENT.SLUG)
    private String slug;

    @Field(DBConstants.EVENT.UP_TOKEN_ID)
    private String upTokenId;

    @Field(DBConstants.EVENT.DOWN_TOKEN_ID)
    private String downTokenId;

    @Field(DBConstants.EVENT.TITLE)
    private String title;

    @Field(DBConstants.EVENT.START_DATE)
    private LocalDateTime startDate;

    @Field(DBConstants.EVENT.CREATION_DATE)
    private LocalDateTime creationDate;

    @Field(DBConstants.EVENT.END_DATE)
    private LocalDateTime endDate;

    @Field(DBConstants.EVENT.ACTIVE)
    private Boolean active;

    @Field(DBConstants.EVENT.CLOSED)
    private Boolean closed;

    @Field(DBConstants.EVENT.ARCHIVED)
    private Boolean archived;

    @Field(DBConstants.EVENT.IS_NEW)
    private Boolean isNew;

}
