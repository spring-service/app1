package com.example.App1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/greet")
    public String greet() {
        // Call App2
        String app2Response = restTemplate.getForObject("http://app2-service:8082/hello", String.class);
        return "App1 received: " + app2Response;
    }
    
    @GetMapping("/esakki")
    public String greetings() {
        // Call App2
        String app2Response = restTemplate.getForObject("http://app2-service:8082/docker", String.class);
        return "App1 received: " + app2Response;
    }
    
    @GetMapping("/test")
    public String test() {
    	return "hi this is from test call again updated";
    }
}
