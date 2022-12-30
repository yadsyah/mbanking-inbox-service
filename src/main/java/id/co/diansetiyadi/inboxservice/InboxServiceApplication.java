package id.co.diansetiyadi.inboxservice;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@EnableMongoAuditing
public class InboxServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InboxServiceApplication.class, args);
	}

	@Bean
	public Gson gson() {
		return new Gson();
	}
}
