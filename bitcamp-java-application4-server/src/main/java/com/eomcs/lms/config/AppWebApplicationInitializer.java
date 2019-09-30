package com.eomcs.lms.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppWebApplicationInitializer 
extends AbstractAnnotationConfigDispatcherServletInitializer {
  
  String uploadTmpDir;
  
  @Override
  protected Class<?>[] getRootConfigClasses() { // ContextLoaderListener 를 의미
    return new Class<?>[] {AppConfig.class, DatabaseConfig.class, MybatisConfig.class};
  }
  
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] {WebConfig.class};
  }
  
  @Override
  protected String[] getServletMappings() {
    return new String[] {"/app/*"};
  }
  
  @Override
  protected String getServletName() {
    return "app";
  }

}






