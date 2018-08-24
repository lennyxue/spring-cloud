package lenny.sc.scconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ScConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScConfigApplication.class, args);
	}
}
