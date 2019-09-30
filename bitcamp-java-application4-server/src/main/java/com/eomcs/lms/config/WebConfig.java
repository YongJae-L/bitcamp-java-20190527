package com.eomcs.lms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.UrlPathHelper;

@ComponentScan("com.eomcs.lms.web")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver vr = new InternalResourceViewResolver(
        "/WEB-INF/jsp/",".jsp");
    return vr;
  }

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    UrlPathHelper helper = new UrlPathHelper();
    helper.setRemoveSemicolonContent(false);
    // DispathcherServlet의 MVC path관련 설정을 변경한다.
    configurer.setUrlPathHelper(helper);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    /*
    registry.addInterceptor(new Controller04_1_Interceptor2())
            .addPathPatterns("/c04_1/*");
    registry.addInterceptor(new Controller04_1_Interceptor3())
    .addPathPatterns("/c04_1/**")
    .excludePathPatterns("/c04_1/a/**");
    */
  }
  
  @Bean
  public MultipartResolver multipartResolver() {
    // 이 클래스는 외부라이브러리 이용 등록 필수
    CommonsMultipartResolver mr = new CommonsMultipartResolver();
    mr.setMaxUploadSize(10000000);
    mr.setMaxInMemorySize(2000000);
    mr.setMaxUploadSizePerFile(5000000);
    return mr;
  }

}