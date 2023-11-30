package demo.springdatajpapostgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories //Bu paket altındaki Jpa'ları instance edip initialize edecek.
public class SpringDataJpaPostgreSqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaPostgreSqlApplication.class, args);
    }

}
