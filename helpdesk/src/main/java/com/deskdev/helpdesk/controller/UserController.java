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

    @RequestMapping(value = "/user/selectall", method = RequestMethod.GET)
    public @ResponseBody List<User> selectAll() {
        return usrService.getAll();
    }

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    @PreAuthorize("hasRole('admin')")
    public @ResponseBody User getUserByID(@RequestParam Long id) {
        return usrService.getUserByID(id);
    }

    @GetMapping(value = "/userLogin/")
    public @ResponseBody User getUserByLogin(@RequestParam String login) {
        return usrService.getUserByLogin(login);
    }

    @PostMapping(value = "/user/add")
    public void addUser(@RequestBody User usr) {
        usrService.addUser(usr);
    }

    @DeleteMapping(value = "/user/remove")
    public void removeUser(@RequestParam Long id) {
        usrService.removeUser(id);
    }

    @DeleteMapping(value = "/user/removebylogin")
    public void removeUserByLogin(@RequestParam String login) {
        usrService.removeUserByLogin(login);
    }

    @PutMapping(value = "/user/modifyrole")
    public void modifyUserRole(@RequestParam String login, @RequestParam String role) {
        usrService.modifyUserRole(login, role);
    }

}