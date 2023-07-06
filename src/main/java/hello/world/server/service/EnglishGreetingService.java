package hello.world.server.service;

import io.micronaut.context.annotation.Primary;
import jakarta.inject.Singleton;

@Primary
@Singleton
public class EnglishGreetingService implements GreetingService {
    @Override
    public String getGreeting() {
        return "Hello ";
    }
}
