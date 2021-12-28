package com.project.market_app.controller;

import com.project.market_app.dto.AddUserDto;
import com.project.market_app.dto.UpdateUserDto;
import com.project.market_app.dto.UserInfoDto;
import com.project.market_app.service.inter.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // list of user
    @GetMapping("")
    public List<UserInfoDto> userList() {
        List<UserInfoDto> users = userService.userList();
        return users;
    }

    // user info
    @GetMapping("/{id}")
    public UserInfoDto userInfo(@PathVariable("id") Long id) {
        return userService.userInfo(id);
    }

    // add user
    @PostMapping("add")
    public void addUser(@Valid @RequestBody AddUserDto userDto) {
        userService.addUser(userDto);
    }

    // update user
    @PutMapping("/update")
    public void updateUser(@Valid @RequestBody UpdateUserDto userDto) {
        userService.updateUser(userDto);
    }

    // delete user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

}
