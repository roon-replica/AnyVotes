package roon.practice.be.config.persistence;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "roon.practice.be.domain")
public class MongoDataSourceConfig {

	@Value("${spring.data.mongodb.uri}")
	private String connectionUri;

	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(new SimpleMongoClientDatabaseFactory(connectionUri));
	}
}