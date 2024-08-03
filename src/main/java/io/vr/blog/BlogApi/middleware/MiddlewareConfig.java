package io.vr.blog.BlogApi.middleware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MiddlewareConfig implements WebMvcConfigurer {
    @Autowired
    private AuthMiddleware authmiddleware;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(authmiddleware).addPathPatterns("/api/v1/blog/**");
    }
}