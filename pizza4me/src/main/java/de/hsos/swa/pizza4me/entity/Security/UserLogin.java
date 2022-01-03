package de.hsos.swa.pizza4me.entity.Security;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

@Entity
@Table(name = "user_login", schema = "SEC")
@UserDefinition

public class UserLogin extends PanacheEntity {

    @Username
    public String username;
    @Password
    public String password;
    @Roles
    public String role;

    /**
     * Adds a new user in the database
     * 
     * @param username the user name
     * @param password the unencrypted password (it will be encrypted with bcrypt)
     * @param role     the comma-separated roles
     */

    public static void add(String username, String password, String role) {
        UserLogin user = new UserLogin();
        user.username = username;
        user.password = password;
        user.role = role;
        user.persist();
    }

}
