package polymarket.bot.sync.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "coins")
public class EventsConfig {

    private Map<String, Map<String, Boolean>> events = new HashMap<>();

    public boolean isEnabled(String coin, String interval) {
        Map<String, Boolean> intervals = events.get(coin);
        if (intervals == null) return false;
        Boolean enabled = intervals.get(interval);
        return Boolean.TRUE.equals(enabled);
    }

}
