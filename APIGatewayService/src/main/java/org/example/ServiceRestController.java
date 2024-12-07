package org.example;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class ServiceRestController {

    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;

    public ServiceRestController(DiscoveryClient discoveryClient, RestClient.Builder restClientBuilder) {
        this.discoveryClient = discoveryClient;
        restClient = restClientBuilder.build();
    }

    @GetMapping("helloEureka")
    public String helloWorld() {
        ServiceInstance serviceInstance = discoveryClient.getInstances("servicea").get(0);
        return restClient.get()
                .uri(serviceInstance.getUri() + "/message")
                .retrieve()
                .body(String.class);
    }
}

//TODO: ODER http://localhost:8080/helloEureka aufrufen
// bei http://localhost:8761/ kann ich mir als zwischenschritt anschauen, ob meine services registriert sind