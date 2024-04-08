package org.example.networking;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    @Test
    public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() throws IOException {
        ClientGreetings clientGreetings = new ClientGreetings();
        ServerGreeting serverGreeting = new ServerGreeting();
        serverGreeting.startConnection("127.0.0.0.1", 8080);
        clientGreetings.start( 6666);
        String response = ServerGreeting.sendMessage("hello server");
        assertEquals("hello client", response);
    }
}
