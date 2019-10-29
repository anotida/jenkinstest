package zw.co.dash.jenkinstest.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String index() {
        log.info("Inside the index method.");
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/test")
    public String test() {
        log.info("Inside the test method");
        return "Test happy";
    }

}
