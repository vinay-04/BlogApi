package io.vr.blog.BlogApi.repository;

import org.springframework.stereotype.Repository;
import io.vr.blog.BlogApi.database.UserEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    UserEntity findByUsername(String username);

}