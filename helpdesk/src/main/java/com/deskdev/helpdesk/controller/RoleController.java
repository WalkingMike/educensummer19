package com.deskdev.helpdesk.controller;

import com.deskdev.helpdesk.model.Role;
import com.deskdev.helpdesk.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class RoleController {
    @Autowired
    private final RoleService roleService;

    @RequestMapping(value = "/role/selectall", method = RequestMethod.GET)
    public @ResponseBody List<Role> selectAll() {
        return roleService.getAll();
    }

    @RequestMapping(value = "/role/add", method = RequestMethod.POST)
    public void addRole(@RequestBody Role role) {
        roleService.addRole(role);
    }

    @RequestMapping(value = "/role/remove", method = RequestMethod.DELETE)
    public void removeRole(@RequestParam Long id) {
        roleService.removeRole(id);
    }
}