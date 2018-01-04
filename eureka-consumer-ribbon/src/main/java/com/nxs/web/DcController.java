package com.nxs.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 57014
 */
@RestController
public class DcController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/consumer")
    public String dc(){
        return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }
}
