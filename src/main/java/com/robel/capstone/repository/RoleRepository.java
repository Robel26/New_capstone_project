package com.robel.capstone.repository;

import com.robel.capstone.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * This section is for the role repository for the role table extends the JPA repository
 * that can find the role by name
 * and finds a role associated with a user.
 * It uses a native SQL query to select all columns from the "role" table where the role's ID matches the role ID obtained from the "users_roles" table for a specific user ID.
 * The method returns a list of Role objects.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findRoleByName(String name); //new change for role to name

    @Query(value = "select * from role where role.id= (select role_id from users_roles where user_id = :id)", nativeQuery = true)
    public List<Role> findRoleByUser(@Param("id") long id);
}
