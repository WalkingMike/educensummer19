package com.deskdev.helpdesk.services;

import com.deskdev.helpdesk.model.User;
import com.deskdev.helpdesk.repo.UserRepo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
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
    public void addUser(User usr){
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
