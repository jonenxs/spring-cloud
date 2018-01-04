package com.nxs.web;


import com.nxs.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 57014
 */
@RestController
public class DcController {

    @Autowired
    ConsumerService consumerService;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/consumer")
    public String consumer(){
        return consumerService.consumer();
    }

    @GetMapping("/dc")
    public String dc() throws InterruptedException {
        Thread.sleep(5000L);
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
}
