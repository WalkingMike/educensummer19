package com.deskdev.helpdesk.services;

import com.deskdev.helpdesk.model.Role;
import com.deskdev.helpdesk.repo.RoleRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Service
@AllArgsConstructor
public class RoleService {
    @Autowired
    private final RoleRepo roleRepo;

    @Transactional
    public List<Role> getAll(){
        return roleRepo.findAll();
    }

    @Transactional
    public void addRole(Role role){
        roleRepo.save(role);
    }

    @Transactional
    public void removeRole(Long id){
        roleRepo.deleteById(id);
    }

    @Transactional
    public Role getRoleByName(String name){
        return roleRepo.findOneByRoleDescription(name);
    }
}
