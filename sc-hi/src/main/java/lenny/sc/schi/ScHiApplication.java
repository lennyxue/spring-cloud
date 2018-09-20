package lenny.sc.schi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class ScHiApplication {

     @Autowired
     RedisTemplate redisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ScHiApplication.class, args);

//save object into redis
        ScHiApplication scHiApplication = new ScHiApplication();
    }


    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name) {
        return "Hi, This is " + name + " of port " + port;

    }
    @RequestMapping("/redis")
    public String redis(@RequestParam String name) {
        redisTemplate.opsForHash().put(name, name, System.currentTimeMillis());
        return "Hi, This is redis value " + redisTemplate.opsForHash().get(name, name);

    }

}
