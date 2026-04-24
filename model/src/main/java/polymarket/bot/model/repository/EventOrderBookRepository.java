package polymarket.bot.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import polymarket.bot.model.EventOrderBook;

public interface EventOrderBookRepository extends MongoRepository<EventOrderBook, String> {

}
