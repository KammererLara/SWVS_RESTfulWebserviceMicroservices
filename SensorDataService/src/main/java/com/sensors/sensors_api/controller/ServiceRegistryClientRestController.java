package com.sensors.sensors_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceRegistryClientRestController {

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello world from Service A!";
    }

    //TODO: mit helloworld aufrufen! & testen
}

//TODO: zweites Service, das erstes aufruft...brauchbar?
//package com.example.serviceb.controller;
//
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestClient;
//
//@RestController
//public class ServiceBRestController {
//
//    private final DiscoveryClient discoveryClient;
//    private final RestClient restClient;
//
//    public ServiceBRestController(DiscoveryClient discoveryClient, RestClient.Builder restClientBuilder) {
//        this.discoveryClient = discoveryClient;
//        restClient = restClientBuilder.build();
//    }
//
//    @GetMapping("helloEureka")
//    public String helloWorld() {
//        ServiceInstance serviceInstance = discoveryClient.getInstances("servicea").get(0);
        // -> geht auf das service, das in application.properties oder aus configServer den namen servicea hat
//        String serviceAResponse = restClient.get()
//                .uri(serviceInstance.getUri() + "/helloWorld")
//                .retrieve()
//                .body(String.class);
//        return serviceAResponse;
//    }
//}

//TODO: testen: alles der reihe nach starten
//TODO: curl http://localhost:8082/helloEureka
//TODO: ODER http://localhost:8082/helloEureka aufrufen
// mit 8082 natürlich nur möglich, wenn erstes Service Port 8081 bekommt und zweites Service existiert und läuft & 8082 hat
// bei http://localhost:8761/ kann ich mir als zwischenschritt anschauen, ob meine services registriert sind

//lt. ChatGPT ist das zweite Service hier ein Service, das das erste über das Registry aufruft
// dh das erste ist bei uns wohl das sensorservice und das zweite das service, das es aufruft, also das api gateway/application