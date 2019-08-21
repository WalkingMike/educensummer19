package com.deskdev.helpdesk.services;

import com.deskdev.helpdesk.model.User;
import com.deskdev.helpdesk.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    @Autowired
    private final UserRepo userRepo;
    @Autowired
    private final RoleService roleService;

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
    public UserDetails loadUserByUsername(String login){
        User usr = userRepo.findUserByLogin(login);
        if (usr != null)
        {
            return usr;
        }
        return null;
    }

    @PostConstruct
    public void init() {
        User usr = userRepo.findUserByLogin("user");
        usr.setPassword(new BCryptPasswordEncoder().encode("user"));
        userRepo.save(usr);
    }

    @Transactional
    public void addUser(User usr){
        usr.setPassword(new BCryptPasswordEncoder().encode(usr.getPassword()));
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
