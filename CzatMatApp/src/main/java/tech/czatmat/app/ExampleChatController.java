package tech.czatmat.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExampleChatController {

    @RequestMapping(value = "/przyklad", method = RequestMethod.GET, produces = "application/json")
    public List<Pair<String, String>> index() {
        List<Pair<String, String>> list = new ArrayList<>();
        Pair<String, String> pair = Pair.of("Julia", "Masakra");
        list.add(pair);
        return list;
    }

}
