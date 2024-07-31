package io.vr.blog.BlogApi.database;

import java.sql.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "blogs")
public class BlogEntity {

    public BlogEntity() {
    }

    public BlogEntity(String blog_name, String blog_description, UUID author) {
        this.name = blog_name;
        this.description = blog_description;
        this.author = author;
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    public UUID id;

    @Column(name = "name")
    public String name;

    @Column(name = "description")
    public String description;

    @Column(name = "author")
    public UUID author;

    @CreationTimestamp
    @Column(name = "time", updatable = false)
    private Date time;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UUID getAuthor() {
        return author;
    }

    public String getId() {
        return id.toString();
    }
}
