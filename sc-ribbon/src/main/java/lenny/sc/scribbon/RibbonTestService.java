package lenny.sc.scribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonTestService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    public String hiService(String name){
        return restTemplate.getForObject("http://SC-HI/hi?name="+name, String.class);
    }

    public String error(String name){
        return "Hystrix here." + name;
    }
}
