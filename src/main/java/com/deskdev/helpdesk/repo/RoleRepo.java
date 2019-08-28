package com.deskdev.helpdesk.repo;

import com.deskdev.helpdesk.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findOneByRoleDescription(String roleDescr);
}
