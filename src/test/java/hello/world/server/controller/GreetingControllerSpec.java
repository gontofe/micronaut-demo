package hello.world.server.controller;

import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class GreetingControllerSpec {

    @Inject
    EmbeddedServer embeddedServer;

    @Inject
    @Client("/greet")
    HttpClient client;
    @Test
    void testGreet() {
        String response = client.toBlocking()
                .retrieve(HttpRequest.GET("/Brayden")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN));
        assertEquals("Hello Brayden", response);
    }

    @Test
    void testSetGreeting() {
        HttpRequest request = HttpRequest.POST("/", "Brayden").contentType(MediaType.TEXT_PLAIN);
        String response = client.toBlocking()
                .exchange(request, String.class)
                .body()
                .toString();
        assertEquals("Hello Brayden", response);
    }
}