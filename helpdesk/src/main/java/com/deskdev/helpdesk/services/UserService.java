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

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service("userDetailsService")
@AllArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private final UserRepo userRepo;

    @Autowired
    private final PasswordEncoder bCrypt;

    @Transactional
    public List<User> getAll(){
        return userRepo.findAll();
    }

    @Transactional
    public User getUserByID(Long id){
        User usr = userRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        return usr;
    }

    @Transactional
    public List<String> getUserNameLoginByID(Long id){
        User usr = userRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        System.out.println(usr);
        return Stream.of(usr.getName(), usr.getLogin()).collect(Collectors.toList());
    }

    @Transactional
    public User getUserByLogin(String username){
        User user = userRepo.findUserByLogin(username);
        return user;
    }

    //for authorization only
    @Transactional
    public UserDetails loadUserByUsername(String username){
        User user = userRepo.findUserByLogin(username);
        return UserPrinciple.build(user);
    }

    @Transactional
    public void addUser(User usr){
        if (!usr.getPassword().equals(" ")) usr.setPassword(bCrypt.encode(usr.getPassword()));
        else usr.setPassword(this.getUserByID(usr.getId()).getPassword());
        if (usr.getRegisterDate() == null) usr.setRegisterDate(new Date());
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
}
