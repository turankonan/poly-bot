package polymarket.bot.model;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
public class EventOrderBookPrice {

    @Field(DBConstants.EVENT_ORDER_BOOK.PRICE.PRICE)
    private Double price;

    @Field(DBConstants.EVENT_ORDER_BOOK.PRICE.SIZE)
    private Double size;

}
