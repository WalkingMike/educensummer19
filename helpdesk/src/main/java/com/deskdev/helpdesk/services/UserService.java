package com.deskdev.helpdesk.services;

import com.deskdev.helpdesk.config.security.UserPrinciple;
import com.deskdev.helpdesk.model.User;
import com.deskdev.helpdesk.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service("userDetailsService")
@AllArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private final UserRepo userRepo;
    @Autowired
    private final RoleService roleService;

    @Autowired
    private final PasswordEncoder bCrypt;

    @Transactional
    public List<User> getAll(){
        return userRepo.findAll();
    }

    @Transactional
    public User getUserByID(long id){
        User usr = userRepo.findById(id).orElseThrow(() -> new RuntimeException());
        return usr;
    }

    @Transactional
    public UserDetails loadUserByUsername(String username){
        User user = userRepo.findUserByLogin(username);
//        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
//        if (user != null) {
//            builder = org.springframework.security.core.userdetails.User.withUsername(username);
//            builder.password(user.getPassword());
//            builder.roles(user.getRole().getAuthority());
//        } else {
//            throw new UsernameNotFoundException("User not found.");
//        }
//        System.out.println(user.getPassword());
//        return builder.build();

        System.out.println(UserPrinciple.build(user));
        if (user != null)
        {
            return UserPrinciple.build(user);
        }
        return null;
    }

    @PostConstruct
    public void init() {
        User newUser = userRepo.findUserByLogin("test");
        newUser.setPassword(bCrypt.encode("test"));
        newUser.setRoleID((long) 3);
        userRepo.save(newUser);
    }

    @Transactional
    public void addUser(User usr){
        usr.setPassword(bCrypt.encode(usr.getPassword()));
        userRepo.save(usr);
    }

    @Transactional
    public void removeUser(Long id){
        userRepo.deleteById(id);
    }

    @Transactional
    public void removeUserByLogin(String login){
        userRepo.deleteById(userRepo.findUserIDByLogin(login));
    }

    @Transactional
    public void modifyUserRole(String login, String role){
        User usr = userRepo.findUserByLogin(login);
        usr.setRole(roleService.getRoleByName(role));
        userRepo.save(usr);
    }
}
