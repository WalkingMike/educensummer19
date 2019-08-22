package com.deskdev.helpdesk.controller;

import com.deskdev.helpdesk.config.security.JwtProvider;
import com.deskdev.helpdesk.message.JwtResponse;
import com.deskdev.helpdesk.repo.RoleRepo;
import com.deskdev.helpdesk.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepo userRepository;

    @Autowired
    RoleRepo roleRepository;
//
//    @Autowired
//    BCryptPasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestParam String login, @RequestParam String pass) {
        System.out.println("Started");

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login, pass);
        System.out.println(token.getCredentials());

        Authentication authentication = authenticationManager.authenticate(token);
        System.out.println(authentication); // не выводит

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println(jwt);
        System.out.println(userDetails);
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }

//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@RequestBody User usr) {
//        if (userRepository.existsByLogin(usr.getLogin())) {
//            return new ResponseEntity<>(new ResponseMessage("Fail -> Login is already taken!"),
//                    HttpStatus.BAD_REQUEST);
//        }
//
//        if (userRepository.existsByEmail(usr.getEmail())) {
//            return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
//                    HttpStatus.BAD_REQUEST);
//        }
//
//        // Creating user's account
//        User user = new User(usr.getName(), usr.getLogin(), usr.getEmail(),
//                encoder.encode(usr.getPassword()));
//
//        Role role = usr.getRole();
//        Set<Role> roles = new HashSet<>();
//
//        strRoles.forEach(role -> {
//            switch (role) {
//                case "admin":
//                    Role adminRole = roleRepository.findOneByRoleDescription(RoleName.ROLE_ADMIN)
//                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
//                    roles.add(adminRole);
//
//                    break;
//                case "pm":
//                    Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
//                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
//                    roles.add(pmRole);
//
//                    break;
//                default:
//                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
//                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
//                    roles.add(userRole);
//            }
//        });
//
//        user.setRole();
//        userRepository.save(user).save(user);
//
//        return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
//    }
}
