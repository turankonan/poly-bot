package polymarket.bot.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import polymarket.bot.model.Event;

public interface EventRepository extends MongoRepository<Event, String> {

    Event findBySlug(String slug);

}
