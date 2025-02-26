package Cogip.project_cogip.controller;

import Cogip.project_cogip.dto.UserDto;
import Cogip.project_cogip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String getUsers(@RequestBody UserDto user) {
        userService.createUsers(user);
        return "User added successfully";
    }
}
