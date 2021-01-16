package tech.czatmat.app.CzatMatApp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.czatmat.app.CzatMatApp.dataClasses.users.UserRepository;
import tech.czatmat.app.CzatMatApp.payload.request.SearchNameSurnameRequest;
import tech.czatmat.app.CzatMatApp.payload.response.SearchMultipleUsersResponse;

@PreAuthorize("hasAnyRole('USER', 'SUPER_USER', 'ADMIN')")
@RestController
@RequestMapping("/search")
public class SearchUsersController {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    AuthenticationManager authenticationManager;


    public SearchUsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getUsersByNameAndSurname(@RequestParam(value = "name", required = false, defaultValue = "") String name, @RequestParam(value = "surname", required = false, defaultValue = "") String surname) {
        return ResponseEntity.ok(new SearchMultipleUsersResponse(userRepository.getUsersByNameContainsAndSurnameContains(name, surname)));
    }

    @Transactional
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> getUsersByNameAndSurname(@RequestBody SearchNameSurnameRequest searchNameSurnameRequest) {
        return ResponseEntity.ok(new SearchMultipleUsersResponse(userRepository.getUsersByNameContainsAndSurnameContains(searchNameSurnameRequest.getName(), searchNameSurnameRequest.getSurname())));
    }

    @Transactional
    @RequestMapping(value = "/id", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getUsersById(@RequestParam(value = "id", required = true) int id) {
        return ResponseEntity.ok(new SearchMultipleUsersResponse(userRepository.getUsersByID(id)));
    }



}
