package com.deskdev.helpdesk.repo;

import com.deskdev.helpdesk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query(value = "SELECT u.id FROM \"user\" u WHERE u.login = '?1'", nativeQuery = true)
    User findUserByLogin(String login);

    @Query(value = "UPDATE \"user\" SET role_id = (SELECT r.id FROM role r WHERE r.role_description = ?2) WHERE login = ?1", nativeQuery = true)
    void modifyUserRole(String login, String role);
}
