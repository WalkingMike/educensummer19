package com.deskdev.helpdesk.controller;

import com.deskdev.helpdesk.model.User;
import com.deskdev.helpdesk.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class UserController {
    @Autowired
    private final UserService usrService;

    @GetMapping(value = "/user/selectall")
    @PreAuthorize("hasRole('admin')")
    public @ResponseBody List<User> selectAll() {
        return usrService.getAll();
    }

    @GetMapping(value = "/user/")
    public @ResponseBody User getUserByID(@RequestParam Long id) {
        return usrService.getUserByID(id);
    }

    @GetMapping(value = "/userNameLogin/")
    public @ResponseBody List<String> getUserNameLoginByID(@RequestParam Long id) {
        return usrService.getUserNameLoginByID(id);
    }

    @GetMapping(value = "/userLogin/")
    public @ResponseBody User getUserByLogin(@RequestParam String login) {
        return usrService.getUserByLogin(login);
    }

    @PostMapping(value = "/user/add")
    @PreAuthorize("hasRole('admin') or hasRole('user')")
    public void addUser(@RequestBody User usr) {
        usrService.addUser(usr);
    }

    @DeleteMapping(value = "/user/remove")
    @PreAuthorize("hasRole('admin')")
    public void removeUser(@RequestParam Long id) {
        usrService.removeUser(id);
    }

    @DeleteMapping(value = "/user/removebylogin")
    @PreAuthorize("hasRole('admin')")
    public void removeUserByLogin(@RequestParam String login) {
        usrService.removeUserByLogin(login);
    }
}