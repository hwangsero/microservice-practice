package com.thoughtmechanix.licenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
// 리본이 지원하는 RestTemplate을 사용할 때 @EnableDiscoveryClient, @EnableFeignClients는 선언해주지 않아도 된다.
@EnableDiscoveryClient // DiscoveryClient와 리본 라이브러리를 사용할 수 있게 한다.
@EnableFeignClients
public class Application {

  @LoadBalanced // 스프링 클라우드가 리본이 지원하는 RestTemplate 클래스를 생성하도록 지정한다.
  @Bean
  public RestTemplate getRestTemplate(){
      return new RestTemplate();
  }

  public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
  }
}
