package tech.czatmat.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ExampleChatController {

    @RequestMapping("/przyklad")
    public List<Map<String, String>> index() {
        List<Map<String, String>> lista = null;
        lista = null;
        lista = null;
        Map<String, String> map = null;
        return lista;
    }

}
