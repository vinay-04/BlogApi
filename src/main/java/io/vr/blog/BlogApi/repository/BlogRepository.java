package io.vr.blog.BlogApi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.vr.blog.BlogApi.database.BlogEntity;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, UUID> {

}
