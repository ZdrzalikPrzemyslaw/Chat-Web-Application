package tech.czatmat.app.CzatMatApp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tech.czatmat.app.CzatMatApp.messages.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ExampleChatController {

    @RequestMapping(value = "/przyklad", method = RequestMethod.GET, produces = "application/json")
    public List<Message> index() {
        var list = new ArrayList<Message>();
        list.add(Message.of("Julia", "Trzeba sprawdzić dane na stronie", new Date(), 1, 1));
        list.add(Message.of("Hubert", "Wczoraj były poprawne", new Date(), 1, 2));
        list.add(Message.of("Hubert", "Sprawdzę je za godzinę", new Date(), 1, 3));
        list.add(Message.of("Julia", "Nie ma problemu", new Date(), 1, 4));
        return list;
    }

}
