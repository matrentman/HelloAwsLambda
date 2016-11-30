package com.emptylogic.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.emptylogic.dto.HelloRequest;
import com.emptylogic.dto.HelloResponse;
import com.emptylogic.lambda.Hello;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class HelloTest {

    private static HelloRequest input;

    @BeforeClass
    public static void createInput() throws IOException {
        input = new HelloRequest("World");
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        ctx.setFunctionName("HelloFunction");

        return ctx;
    }

    @Test
    public void testHello() {
        Hello handler = new Hello();
        Context ctx = createContext();

        HelloResponse output = handler.handleRequest(input, ctx);

        if (output != null) {
            System.out.println(output.toString());
            assertEquals(output.getGreeting(), "Hello, World");
        }
    }
}
