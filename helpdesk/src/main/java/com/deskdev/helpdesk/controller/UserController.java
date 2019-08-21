package com.deskdev.helpdesk.controller;

import com.deskdev.helpdesk.model.User;
import com.deskdev.helpdesk.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public @ResponseBody User getUserByID(@RequestParam Long id) {
        return usrService.getUserByID(id);
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public void addUser(@RequestBody User usr) {
        usrService.addUser(usr);
    }

    @RequestMapping(value = "/user/remove", method = RequestMethod.DELETE)
    public void removeUser(@RequestParam Long id) {
        usrService.removeUser(id);
    }

    @RequestMapping(value = "/user/removebylogin", method = RequestMethod.DELETE)
    public void removeUserByLogin(@RequestParam String login) {
        usrService.removeUserByLogin(login);
    }

    @RequestMapping(value = "/user/modifyrole", method = RequestMethod.PUT)
    public void modifyUserRole(@RequestParam String login, @RequestParam String role) {
        usrService.modifyUserRole(login, role);
    }

}