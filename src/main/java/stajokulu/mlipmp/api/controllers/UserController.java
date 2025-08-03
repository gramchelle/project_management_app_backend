package stajokulu.mlipmp.api.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.catalina.User;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import stajokulu.mlipmp.business.abstracts.UserService;
import stajokulu.mlipmp.entities.dto.user.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<List<GetUserDto>> getAll(){
        List<GetUserDto> users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<List<GetUserDto>> getById(@PathVariable UUID id) {
        List<GetUserDto> user = userService.getById(id);
        if (user.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
        return new ResponseEntity<>("User is saved successfully: " + userDto.getName(), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return new ResponseEntity<>("User deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
        }
    }
}
