package com.deskdev.helpdesk.repo;

import com.deskdev.helpdesk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query(value = "SELECT u.user_id FROM \"user\" u WHERE u.login = :login", nativeQuery = true)
    Long findUserIDByLogin(@Param("login") String login);

    User findUserByLogin(String login);

    Boolean existsByLogin(String login);

    Boolean existsByEmail(String email);
}
