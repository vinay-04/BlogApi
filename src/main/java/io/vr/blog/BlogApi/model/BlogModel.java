package io.vr.blog.BlogApi.model;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import io.vr.blog.BlogApi.database.BlogEntity;

public class BlogModel {
    public String blog_id;
    public String blog_name;
    public String blog_description;
    public UUID blog_organizer;
    public Date blog_time;

    public BlogModel(
            String blog_id,
            String blog_name,
            String blog_description,
            UUID blog_organizer,
            Date blog_time) {

        this.blog_id = blog_id;
        this.blog_name = blog_name;
        this.blog_description = blog_description;
        this.blog_organizer = blog_organizer;
        this.blog_time = blog_time;
    }

    public static BlogModel fromEntity(BlogEntity entity) {
        BlogModel blogmodel = new BlogModel(
                entity.getId(),
                entity.getName(),
                entity.getDescription(), entity.getAuthor(),
                entity.getTime());
        return blogmodel;
    }

    public static List<BlogModel> fromEntities(List<BlogEntity> entities) {
        return entities.stream().map(BlogModel::fromEntity).collect(Collectors.toList());
    }
}
