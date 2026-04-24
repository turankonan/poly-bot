package polymarket.bot.model;

public interface DBConstants {

    interface BASE {
        String CREATE_DATE = "createDate";
        String UPDATE_DATE = "updateDate";
        String CREATE_USER = "createUser";
        String UPDATE_USER = "updateUser";
        String EXTERNAL_ID = "externalId";
        String SOURCE = "source";
        String STATUS = "status";
        String AR_SA = "arSA";
        String EN_US = "enUS";
    }

    interface EVENT {
        String COLLECTION_NAME = "event";
        String ESTIMATED_RESULT = "estimatedResult";
        String TICKER = "ticker";
        String SLUG = "slug";
        String UP_TOKEN_ID = "upTokenId";
        String DOWN_TOKEN_ID = "downTokenId";
        String TITLE = "title";
        String START_DATE = "startDate";
        String CREATION_DATE = "creationDate";
        String END_DATE = "endDate";
        String ACTIVE = "active";
        String CLOSED = "closed";
        String ARCHIVED = "archived";
        String IS_NEW = "new";
    }

    interface EVENT_ORDER_BOOK {
        String COLLECTION_NAME = "eventOrderBook";
        String SLUG = "slug";
        String UP_BIDS = "upBids";
        String DOWN_BIDS = "downBids";
        String UP_ASKS = "upAsks";
        String DOWN_ASKS = "downAsks";

        interface PRICE {
            String PRICE = "price";
            String SIZE = "size";
        }
    }

    interface EVENT_MARKET_PRICE {
        String COLLECTION_NAME = "eventMarketPrice";
        String SLUG = "slug";
        String TOKEN_ID = "tokenId";
        String SELL_PRICE = "sellPrice";
        String BUY_PRICE = "buyPrice";
        String SIDE = "side";
    }

}
