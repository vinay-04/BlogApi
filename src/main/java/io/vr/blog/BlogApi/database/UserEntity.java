package io.vr.blog.BlogApi.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "users")
public class UserEntity {
    public UserEntity() {
    }

    public UserEntity(String username, String password_hash, String email, String full_name) {
        this.username = username;
        this.password_hash = password_hash;
        this.email = email;
        this.full_name = full_name;
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    public UUID id;

    @Column(name = "username")
    public String username;

    @Column(name = "password_hash")
    public String password_hash;

    @Column(name = "email")
    public String email;

    @Column(name = "full_name")
    public String full_name;

    public String getUsername() {
        return username;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public String getEmail() {
        return email;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getId() {
        return id.toString();
    }
}
