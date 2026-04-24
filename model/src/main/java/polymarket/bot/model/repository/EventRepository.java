package polymarket.bot.model.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import polymarket.bot.model.Event;

public interface EventRepository extends MongoRepository<Event, String> {

    Optional<Event> findBySlug(String slug);

}
