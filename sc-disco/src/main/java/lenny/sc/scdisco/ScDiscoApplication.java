package lenny.sc.scdisco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ScDiscoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScDiscoApplication.class, args);
	}
}
