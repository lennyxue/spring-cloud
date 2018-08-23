package lenny.sc.scribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScRibbonController {
    @Autowired
    RibbonTestService ribbonTestService;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        System.out.println("Ribbon is invoked " + name);
        return ribbonTestService.hiService(name);
    }
}
