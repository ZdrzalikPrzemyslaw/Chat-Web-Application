package tech.czatmat.app;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tech.czatmat.app.messages.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExampleChatController {

    @RequestMapping(value = "/przyklad", method = RequestMethod.GET, produces = "application/json")
    public List<Message> index() {
        var list = new ArrayList<Message>();
        list.add(Message.of("Julia", "Boje sie wywiadów", new Date(), 1, 1));
        list.add(Message.of("Przemek", "Nie Boje sie wywiadów", new Date(), 1, 2));
        list.add(Message.of("Oskar", "Boje się sławka", new Date(), 1, 3));
        list.add(Message.of("Lolus", "Nie zjem za Kaczyńskiego", new Date(), 1, 4));
        return list;
    }

}
