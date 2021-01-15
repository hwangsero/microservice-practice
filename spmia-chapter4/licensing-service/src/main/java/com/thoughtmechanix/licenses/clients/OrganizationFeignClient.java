package com.thoughtmechanix.licenses.clients;


import com.thoughtmechanix.licenses.model.Organization;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("organizationservice") // @FeignClient로 조직 서비스를 Feign에 확인한다.
public interface OrganizationFeignClient {
    @RequestMapping(
            method= RequestMethod.GET,
            value="/v1/organizations/{organizationId}",
            consumes="application/json") // @RequestMapping으로 엔트포인트 경로와 액션을 정의한다.
    Organization getOrganization(@PathVariable("organizationId") String organizationId); // 엔드포인트에 전달하는 매개변수를 정의한다.
}
