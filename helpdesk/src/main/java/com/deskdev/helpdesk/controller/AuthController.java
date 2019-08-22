package com.deskdev.helpdesk.controller;

import com.deskdev.helpdesk.config.security.JwtProvider;
import com.deskdev.helpdesk.message.JwtResponse;
import com.deskdev.helpdesk.message.ResponseMessage;
import com.deskdev.helpdesk.model.User;
import com.deskdev.helpdesk.repo.RoleRepo;
import com.deskdev.helpdesk.repo.UserRepo;
import com.deskdev.helpdesk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepo userRepository;

    @Autowired
    UserService userService;

    @Autowired
    RoleRepo roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestParam String login, @RequestParam String pass) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login, pass);

        Authentication authentication = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody User usr) {
        if (userRepository.existsByLogin(usr.getLogin())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Login is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByEmail(usr.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
                    HttpStatus.BAD_REQUEST);
        }
        // Creating user's account
        User user = new User();
        user.setName(usr.getName());
        user.setLogin(usr.getLogin());
        user.setPassword(usr.getPassword());
        user.setEmail(usr.getEmail());
        user.setRegionID(usr.getRegionID());
        user.setRoleID(roleRepository.findOneByRoleDescription("user").getId());

        userService.addUser(user);

        return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
    }
}
