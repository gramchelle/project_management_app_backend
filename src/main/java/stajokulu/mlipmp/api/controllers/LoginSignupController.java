package stajokulu.mlipmp.api.controllers;

import java.util.List;
import stajokulu.mlipmp.entities.dto.user.LoginDto;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stajokulu.mlipmp.business.abstracts.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class LoginSignupController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto) {
        try{
            userService.getUserByEmail(loginDto);
            return new ResponseEntity<String>("Login Successful", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Login Failed", HttpStatus.UNAUTHORIZED);
        }

    }

}
