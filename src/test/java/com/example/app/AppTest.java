package com.example.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {

    // Test greet method
    @Test
    public void testGreet() {

        String result =
                App.greet("Jenkins Maven Build");

        assertEquals(
                "Hello, Jenkins Maven Build! CI/CD Pipeline Build Successful.",
                result
        );
    }

    // Test validation method
    @Test(expected = App.InvalidProjectException.class)
    public void testInvalidProjectException()
            throws App.InvalidProjectException {

        App.validateProject("");
    }

    // Test valid project
    @Test
    public void testValidProject()
            throws App.InvalidProjectException {

        App.validateProject("Demo Project");
    }
}
