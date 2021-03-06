package com.springuni.forgetme.core.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RestConfig extends RepositoryRestConfigurerAdapter {

  private static final String BASE_PATH = "/admin";

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.setBasePath(BASE_PATH);
    config.disableDefaultExposure();
  }

}
