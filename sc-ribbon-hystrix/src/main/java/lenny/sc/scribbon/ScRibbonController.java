package lenny.sc.scribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ScRibbonController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/hi")
    @HystrixCommand(fallbackMethod = "fallbackHi", commandProperties = {
            @HystrixProperty(name="execution.isolation.strategy", value="THREAD")
    })
    public String hi(@RequestParam String name){
        System.out.println("Ribbon is invoked " + name);
        return restTemplate.getForObject("http://SC-HI/hi?name="+name, String.class);
    }

    public String fallbackHi(String name){
        System.out.println("Hystrix, something goes wrong");
        return "Hystrix, something goes wrong";
    }
}
