package com.ims;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.ims.client.gen.*;

public class UserClient extends WebServiceGatewaySupport {

    public LoginUserResponse loginUser(String username, String password) {

        LoginUserRequest request = new LoginUserRequest();
        request.setUsername(username);
        request.setPassword(password);

        LoginUserResponse response = (LoginUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);

        return response;
    }

    public SignupUserResponse signupUser(User user) {

        SignupUserRequest request = new SignupUserRequest();
        request.setUser(user);

        SignupUserResponse response = (SignupUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);

        return response;
    }
}
