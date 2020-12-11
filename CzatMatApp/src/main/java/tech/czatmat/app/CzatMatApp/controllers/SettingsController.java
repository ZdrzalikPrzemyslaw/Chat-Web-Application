package tech.czatmat.app.CzatMatApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.czatmat.app.CzatMatApp.dataClasses.users.User;
import tech.czatmat.app.CzatMatApp.dataClasses.users.UserRepository;
import tech.czatmat.app.CzatMatApp.payload.request.EmailRequest;
import tech.czatmat.app.CzatMatApp.payload.request.NamesRequest;
import tech.czatmat.app.CzatMatApp.payload.request.UsernameRequest;
import tech.czatmat.app.CzatMatApp.payload.response.MessageResponse;


@RestController
@RequestMapping("/update")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SettingsController {
    @Autowired
    private final UserRepository userRepository;

    public SettingsController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/names", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> updateNames(@RequestBody NamesRequest updateRequest) {
        if (userRepository.getUsersByUsername(updateRequest.getUsername()).isPresent()) {
            User user = userRepository.getUsersByUsername(updateRequest.getUsername()).get();
            user.setName(updateRequest.getNewName());
            user.setSurname(updateRequest.getNewSurname());
            return ResponseEntity.ok(new MessageResponse("User's data updated successfully!"));
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("User does not exist"));
        }
    }

    @RequestMapping(value = "/email", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> updateEmail(@RequestBody EmailRequest updateRequest) {
        if (userRepository.getUsersByUsername(updateRequest.getUsername()).isPresent()) {
            if (userRepository.existsByEmail(updateRequest.getNewEmail())) {
                return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
            } else {
                User user = userRepository.getUsersByUsername(updateRequest.getUsername()).get();
                user.setEmail(updateRequest.getNewEmail());
                return ResponseEntity.ok(new MessageResponse("User's data updated successfully!"));
            }
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("User does not exist"));
        }
    }

    @RequestMapping(value = "/username", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> updateUsername(@RequestBody UsernameRequest updateRequest) {
        if (userRepository.getUsersByUsername(updateRequest.getUsername()).isPresent()) {
            if (userRepository.existsByUsername(updateRequest.getNewUsername())) {
                return ResponseEntity.badRequest().body(new MessageResponse("User By That Login Already Exists"));
            } else {
                User user = userRepository.getUsersByUsername(updateRequest.getUsername()).get();
                user.setUsername(updateRequest.getNewUsername());
                return ResponseEntity.ok(new MessageResponse("Username updated successfully!"));
            }
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("User does not exist"));
        }
    }





}
