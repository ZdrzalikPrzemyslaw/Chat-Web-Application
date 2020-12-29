package tech.czatmat.app.CzatMatApp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tech.czatmat.app.CzatMatApp.dataClasses.users.UserRepository;
import tech.czatmat.app.CzatMatApp.payload.request.SearchNameSurnameRequest;
import tech.czatmat.app.CzatMatApp.payload.response.SearchMultipleUsersResponse;
import tech.czatmat.app.CzatMatApp.security.JwtUtils;

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

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllUsers() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(new SearchMultipleUsersResponse(userRepository.findAll()));
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> getUsersByNameAndSurname(@RequestBody SearchNameSurnameRequest searchNameSurnameRequest) {
        return ResponseEntity.ok(new SearchMultipleUsersResponse(userRepository.getUsersByNameContainsAndSurnameContains(searchNameSurnameRequest.getName(), searchNameSurnameRequest.getSurname())));
    }


}
