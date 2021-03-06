package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcConfig implements WebMvcConfigurer {
        @Value("${upload.pathship}")
        private String uploadPathSHip;

        @Value("${upload.pathinventory}")
        private String uploadPathInventory;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/img/ship/**")
                .addResourceLocations("file:///" + uploadPathSHip + "/");
        registry.addResourceHandler("/img/it/**")
                .addResourceLocations("file:///" + uploadPathInventory + "/");



    }
}
