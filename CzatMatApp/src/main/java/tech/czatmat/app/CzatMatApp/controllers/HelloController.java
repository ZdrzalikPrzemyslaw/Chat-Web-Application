package tech.czatmat.app.CzatMatApp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Siema Dzulka";
	}

}
