package com.deskdev.helpdesk.controller;


import com.deskdev.helpdesk.model.User;
import com.deskdev.helpdesk.repo.RoleRepo;
import com.deskdev.helpdesk.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(String name, String login, String password) {
        User user = new User();
        user.setName(name);
        user.setLogin(login);
        user.setPassword(passwordEncoder.encode(password));
        user.setActive(true);
        user.setRoleID(roleRepo.findOneByRoleDescription("user").getId());

        userRepo.save(user);

        return "redirect:/login";
    }
}
