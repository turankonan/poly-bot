package polymarket.bot.sync.config;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ApplicationStarter {

    @PostConstruct
    public void initialize() {
        try {

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}
