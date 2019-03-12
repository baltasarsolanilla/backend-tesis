package tesis.bsc.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {

	@GetMapping(value="/bsc")
    public String homepage(){
        return "index";
    }
}