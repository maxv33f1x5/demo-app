package com.example.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void testGreet() {

        String result = App.greet("Jenkins Maven Build");

        assertEquals(
            "Hello, Jenkins Maven Build! CI/CD Pipeline Build Successful.",
            result
        );
    }
}
