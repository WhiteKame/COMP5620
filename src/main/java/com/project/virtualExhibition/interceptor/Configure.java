package com.project.virtualExhibition.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Configure implements WebMvcConfigurer {



    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        HandlerInterceptor interceptor = new LoginInterceptor();
        List<String> patterns = new ArrayList<>();
        patterns.add("/css/**");
        patterns.add("/image/**");
        patterns.add("/javascript/**");


        patterns.add("/web/register");

        patterns.add("/web/welcome.html");

        patterns.add("/web/login.html");
        patterns.add("/web/register.html");
        patterns.add("/web/resetPassword.html");

        patterns.add("/web/loginArtist.html");
        patterns.add("/web/registerArtist.html");
        patterns.add("/web/resetPasswordArtist.html");

        patterns.add("/web/loginAdmin.html");

        patterns.add("/web/index.html");
        patterns.add("/web/indexAdmin.html");
        patterns.add("/web/indexArtist.html");

        patterns.add("/user/signUp");
        patterns.add("/user/login");
        patterns.add("/user/reset");

        patterns.add("/artist/signUp");
        patterns.add("/artist/login");
        patterns.add("/artist/reset");

        patterns.add("/admin/login");

        patterns.add("/web/add_new_exhibit");

        registry.addInterceptor(interceptor)
                .addPathPatterns("/**").excludePathPatterns(patterns);
    }
}
