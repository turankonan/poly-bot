package polymarket.bot.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import polymarket.bot.model.EventMarketPrice;

public interface EventMarketPriceRepository extends MongoRepository<EventMarketPrice, String> {

}
