package tech.czatmat.app.CzatMatApp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleError {

    @RequestMapping("/example_error")
    public void handleRequest() {
        throw new RuntimeException("test exception");
    }
}