package io.vr.blog.BlogApi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.vr.blog.BlogApi.database.UserEntity;
import io.vr.blog.BlogApi.model.UserModel;
import io.vr.blog.BlogApi.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public List<UserModel> getUser() {
        List<UserEntity> users = userRepository.findAll();
        return UserModel.fromEntities(users);
    }

    public UserModel createUser(UserModel user) {
        UserEntity entity = new UserEntity(user.username, user.password_hash, user.email, user.full_name);
        userRepository.save(entity);
        return UserModel.fromEntity(entity);
    }

}
