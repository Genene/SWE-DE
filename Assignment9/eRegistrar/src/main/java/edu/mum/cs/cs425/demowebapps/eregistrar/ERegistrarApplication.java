package edu.mum.cs.cs425.demowebapps.eregistrar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ERegistrarApplication {

    public static void main(String[] args) {
        SpringApplication.run(ERegistrarApplication.class, args);
    }

}
