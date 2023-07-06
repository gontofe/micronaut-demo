package hello.world.server.controller;

import hello.world.server.service.GreetingService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller("/greet")
public class GreetingController {
    @Inject
    private GreetingService greetingService;

    @Get("/{name}")
    public String greet(String name) {
        return greetingService.getGreeting() + name;
    }

    @Post(value="/{name}", consumes = MediaType.TEXT_PLAIN)
    public String setGreeting(Body name)  {
        return greetingService.getGreeting() + name;
    }
}
