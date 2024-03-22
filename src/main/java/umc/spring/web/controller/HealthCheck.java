package umc.spring.web.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/health")
    public String healthCheck(){
        return "OK, GO GO GO GO GO GO gO";
    }

    @GetMapping("/health2")
    public String healthCheck2(){
        return "OK, GO GO GO GO GO GO gO";
    }
    dasdamfka

}
