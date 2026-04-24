package polymarket.bot.sync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan({"polymarket.bot.rest", "polymarket.bot.sync"})
@SpringBootApplication
@EnableMongoRepositories(basePackages = {"polymarket.bot.model.repository"})
@EnableMongoAuditing
@EnableScheduling
@EnableAsync
@EnableWebMvc
public class SyncApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SyncApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SyncApplication.class, args);
    }

}
