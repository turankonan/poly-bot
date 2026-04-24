package polymarket.bot.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(DBConstants.EVENT_ORDER_BOOK.COLLECTION_NAME)
public class EventOrderBook extends BaseObject {

    @Field(DBConstants.EVENT_ORDER_BOOK.SLUG)
    private String slug;

    @Field(DBConstants.EVENT_ORDER_BOOK.UP_BIDS)
    private List<EventOrderBookPrice> upBids;

    @Field(DBConstants.EVENT_ORDER_BOOK.UP_ASKS)
    private List<EventOrderBookPrice> upAsks;

    @Field(DBConstants.EVENT_ORDER_BOOK.DOWN_BIDS)
    private List<EventOrderBookPrice> downBids;

    @Field(DBConstants.EVENT_ORDER_BOOK.DOWN_ASKS)
    private List<EventOrderBookPrice> downAsks;

}
