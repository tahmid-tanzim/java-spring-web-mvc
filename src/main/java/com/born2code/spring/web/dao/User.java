package com.born2code.spring.web.dao;

import com.born2code.spring.web.validation.ValidEmail;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @NotBlank(message = "Username cannot be blank.", groups = {PersistenceValidationGroup.class, FormValidationGroup.class})
    @Size(min = 4, max = 15, groups = {PersistenceValidationGroup.class, FormValidationGroup.class})
    @Pattern(regexp = "^\\w{4,}$", message = "Username can only consist of numbers, letters and underscore.", groups = {PersistenceValidationGroup.class, FormValidationGroup.class})
    @Id
    @Column(name = "username")
    private String username;

    @NotBlank(message = "Password cannot be blank.", groups = {FormValidationGroup.class})
    @Pattern(regexp = "^\\S+$", message = "Password cannot contain spaces.")
    @Size(min = 5, max = 15, message = "Password must be between 5 to 15 characters.")
    private String password;

    @NotNull
    @ValidEmail(groups = {PersistenceValidationGroup.class, FormValidationGroup.class})
    private String email;

    @NotBlank(groups = {PersistenceValidationGroup.class, FormValidationGroup.class})
    @Size(min = 4, max = 60, message = "Name must be between 5 and 60 characters.")
    private String name;
    private boolean enabled = false;
    private String authority;

    public User() {
    }

    public User(String username, String password, String email, boolean enabled, String authority, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.authority = authority;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (enabled != user.enabled) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return !(authority != null ? !authority.equals(user.authority) : user.authority != null);
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (enabled ? 1 : 0);
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", enabled=" + enabled +
                ", authority='" + authority + '\'' +
                '}';
    }
}
