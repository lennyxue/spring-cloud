package lenny.sc.scfeign;

import org.springframework.stereotype.Component;

@Component
public class HiFeignClientHystrix implements HiFeignClient{
    @Override
    public String sayHiFromClientOne(String name) {
        return "I'm sorry, hystix here";
    }
}
