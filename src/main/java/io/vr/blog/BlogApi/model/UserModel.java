package io.vr.blog.BlogApi.model;

import java.util.List;
import java.util.stream.Collectors;
import io.vr.blog.BlogApi.database.UserEntity;

public class UserModel {
    public String user_id;
    public String username;
    public String password_hash;
    public String email;
    public String full_name;

    public UserModel(
            String user_id,
            String username,
            String password_hash,
            String email,
            String full_name) {

        this.user_id = user_id;
        this.username = username;
        this.password_hash = password_hash;
        this.email = email;
        this.full_name = full_name;
    }

    public static UserModel fromEntity(UserEntity entity) {
        UserModel usermodel = new UserModel(
                entity.getId(),
                entity.getUsername(),
                entity.getPassword_hash(),
                entity.getEmail(),
                entity.getFull_name());
        return usermodel;
    }

    public static List<UserModel> fromEntities(List<UserEntity> entities) {
        return entities.stream().map(UserModel::fromEntity).collect(Collectors.toList());
    }

}
