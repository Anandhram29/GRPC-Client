package com.gprcpractice;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import static com.gprcpractice.userGrpc.newBlockingStub;

public class gRPCClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();
        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        User.LoginRequest loginRequest = User.LoginRequest.newBuilder().setUsername("user").setPassword("user").build();
        User.APIResponse response = userStub.login(loginRequest);

        System.out.println(response.getResponseMessage());

    }
}