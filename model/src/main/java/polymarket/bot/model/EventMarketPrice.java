package polymarket.bot.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(DBConstants.EVENT_MARKET_PRICE.COLLECTION_NAME)
public class EventMarketPrice extends BaseObject {

    @Field(DBConstants.EVENT_MARKET_PRICE.SLUG)
    private String slug;

    @Field(DBConstants.EVENT_MARKET_PRICE.TOKEN_ID)
    private String tokenId;

    @Field(DBConstants.EVENT_MARKET_PRICE.BUY_PRICE)
    private Double buyPrice;

    @Field(DBConstants.EVENT_MARKET_PRICE.SELL_PRICE)
    private Double sellPrice;

    @Field(DBConstants.EVENT_MARKET_PRICE.SIDE)
    private Side side;

}
