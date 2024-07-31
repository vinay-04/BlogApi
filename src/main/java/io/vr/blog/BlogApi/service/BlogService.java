package io.vr.blog.BlogApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.vr.blog.BlogApi.database.BlogEntity;
import io.vr.blog.BlogApi.model.BlogModel;
import io.vr.blog.BlogApi.repository.BlogRepository;

@Service
public class BlogService {
    @Autowired
    public BlogRepository blogRepository;

    public List<BlogModel> getBlogs() {
        List<BlogEntity> blogs = blogRepository.findAll();
        return BlogModel.fromEntities(blogs);
    }

    public BlogModel createBlog(BlogModel blog) {
        BlogEntity entity = new BlogEntity(blog.blog_name, blog.blog_description,
                blog.blog_organizer);
        blogRepository.save(entity);
        return BlogModel.fromEntity(entity);
    }
}
