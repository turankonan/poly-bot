package polymarket.bot.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseObject {

    @Id
    private String id;

    @CreatedDate
    @Field(DBConstants.BASE.CREATE_DATE)
    private LocalDateTime createDate;

    @LastModifiedDate
    @Field(DBConstants.BASE.UPDATE_DATE)
    private LocalDateTime updateDate;

    @Field(DBConstants.BASE.CREATE_USER)
    private String createUser;

    @Field(DBConstants.BASE.UPDATE_USER)
    private String updateUser;

    @Indexed
    @Field(DBConstants.BASE.EXTERNAL_ID)
    private String externalId;

    @Field(DBConstants.BASE.SOURCE)
    private Source source;

    @Field(DBConstants.BASE.STATUS)
    private Status status;

    public enum Status {
        ACTIVE,
        PASSIVE
    }

    public enum Source {
        AIRTABLE,
        FOODICS
    }

}
