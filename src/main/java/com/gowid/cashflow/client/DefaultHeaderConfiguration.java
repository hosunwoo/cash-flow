package com.gowid.cashflow.client;

import org.springframework.context.annotation.Bean;

public class DefaultHeaderConfiguration {

  @Bean
  public DefaultRequestInterceptor defaultRequestInterceptor() {
    return new DefaultRequestInterceptor();
  }
}
