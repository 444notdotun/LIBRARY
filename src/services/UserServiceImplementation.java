package services;

import data.respositories.UserRepository;
import data.respositories.userRepositoryImplementation;
import dtos.requests.UserRequest;
import dtos.responses.UserResponse;
import utils.Mapper;

public class UserServiceImplementation implements UserService {
UserRepository userRepository=new userRepositoryImplementation();

    @Override
    public UserResponse RegisterUser(UserRequest request) {
      return Mapper.mapUserToResponse(userRepository.save(Mapper.mapRequestToUser(request)));
    }
}
