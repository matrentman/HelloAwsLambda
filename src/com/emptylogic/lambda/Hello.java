package com.emptylogic.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.emptylogic.dto.HelloRequest;
import com.emptylogic.dto.HelloResponse;

public class Hello implements RequestHandler<HelloRequest, HelloResponse> {

    @Override
    public HelloResponse handleRequest(HelloRequest input, Context context) {
        return new HelloResponse("Hello, " + input.getName());
    }

}