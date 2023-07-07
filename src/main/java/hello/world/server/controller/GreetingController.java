package hello.world.server.controller;

import hello.world.server.service.GreetingService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

@Controller("/greet")
public class GreetingController {
    private GreetingService greetingService;

    GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Get("/{name}")
    public String greet(String name) {
        return greetingService.getGreeting() + name;
    }

    @Post(consumes = MediaType.TEXT_PLAIN)
    public String setGreeting(@Body String name)  {
        return greetingService.getGreeting() + name;
    }
}
