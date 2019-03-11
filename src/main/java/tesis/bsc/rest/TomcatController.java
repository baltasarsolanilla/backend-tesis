package tesis.bsc.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TomcatController {
 
    @GetMapping("/hello")
    public String sayHello(){
        return "index_hello";
    }
}
