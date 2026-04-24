package polymarket.bot.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
public class Chat {

    @Field(DBConstants.CHAT.ID)
    private String id;

    @Field(DBConstants.CHAT.CHANNEL_ID)
    private String channelId;

    @Field(DBConstants.CHAT.CHANNEL_NAME)
    private String channelName;

    @Field(DBConstants.CHAT.CHANNEL_IMAGE)
    private String channelImage;

    @Field(DBConstants.CHAT.LIVE)
    private Boolean live;

    @Field(DBConstants.CHAT.START_TIME)
    private LocalDateTime startTime;

    @Field(DBConstants.CHAT.END_TIME)
    private LocalDateTime endTime;

}
