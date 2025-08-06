package stajokulu.mlipmp.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stajokulu.mlipmp.business.abstracts.UserService;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class LoginSignupController {

    private final UserService userService;



}
