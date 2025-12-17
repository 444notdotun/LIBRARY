package services;

import dtos.requests.UserRequest;
import dtos.responses.UserResponse;

public interface UserService {
    UserResponse RegisterUser(UserRequest request);

}
