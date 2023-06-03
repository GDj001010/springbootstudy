package com.gdu.home.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gdu.home.intercept.LoginCheckInterceptor;
import com.gdu.home.util.MyFileUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
  
  // field
  private final LoginCheckInterceptor loginCheckInterceptor;
  private final MyFileUtil myfileUtil;
  
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    
    registry.addInterceptor(loginCheckInterceptor)                        // loginCheckInterceptor 를 등록
      .addPathPatterns("/bbs/write.html", "/upload/write.html")           // /bbs/write.html, /upload/write.html 를 이동할 때 동작해라.
      .addPathPatterns("/user/logout.do");                                // /user/logout.do 를 이동할 때 동작해라.
    // registry.addInterceptor(loginCheckInterceptor)
    //   .addPathPatterns("/**")                   // 모든 요청
    //   .excludePathPatterns("/user/leave.do");   // 이 요청만 뺴고 전부 다 LoginCheck를 하겠다, excludePathPatterns < 제외할 패턴
  }
  
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {

    registry.addResourceHandler("/imageLoad/**")                                    // Resource 인터셉트
      .addResourceLocations("/file:" + myfileUtil.getSummernoteImagePath() + "/");  // 
    
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
