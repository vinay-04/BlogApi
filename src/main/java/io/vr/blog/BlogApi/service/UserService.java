package io.vr.blog.BlogApi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.vr.blog.BlogApi.database.UserEntity;
import io.vr.blog.BlogApi.model.UserModel;
import io.vr.blog.BlogApi.repository.UserRepository;

import io.vr.blog.BlogApi.utils.JwtUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

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

    public UserModel loginUser(UserModel user, HttpServletResponse response) {
        UserEntity entity = userRepository.findByUsername(user.username);
        if (entity == null) {
            return null;
        }
        if (!entity.getPassword_hash().equals(user.password_hash)) {
            return null;
        }
        String token = JwtUtils.generateToken(entity.getId().toString());
        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(86400);
        response.addCookie(cookie);
        return UserModel.fromEntity(entity);
    }

    public UserModel logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("token", "");
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return null;
    }
}