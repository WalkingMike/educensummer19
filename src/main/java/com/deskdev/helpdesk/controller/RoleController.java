package com.deskdev.helpdesk.controller;

import com.deskdev.helpdesk.model.Role;
import com.deskdev.helpdesk.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class RoleController {
    @Autowired
    private final RoleService roleService;

    @GetMapping(value = "/role/selectall")
    public @ResponseBody List<Role> selectAll() {
        return roleService.getAll();
    }

    @PostMapping(value = "/role/add")
    public void addRole(@RequestBody Role role) {
        roleService.addRole(role);
    }

    @DeleteMapping(value = "/role/remove")
    public void removeRole(@RequestParam Long id) {
        roleService.removeRole(id);
    }
}