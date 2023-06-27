package DanielaPetrova.UserCarProject.service.impl;

import DanielaPetrova.UserCarProject.converter.UserConverter;
import DanielaPetrova.UserCarProject.dto.UpdateUserRequest;
import DanielaPetrova.UserCarProject.dto.UserRegisterRequest;
import DanielaPetrova.UserCarProject.dto.UserResponse;
import DanielaPetrova.UserCarProject.entity.User;
import DanielaPetrova.UserCarProject.repository.UserRepository;
import DanielaPetrova.UserCarProject.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserConverter userConverter;
    private final UserRepository userRepository;

    public UserServiceImpl(UserConverter userConverter, UserRepository userRepository) {
        this.userConverter = userConverter;
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(UserRegisterRequest request) {
        User user = userConverter.toUser(request);
        return userRepository.save(user);
    }

    @Override
    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id).get();
        return userConverter.toResponse(user);
    }

    @Override
    public UserResponse updateUser(Long id, UpdateUserRequest updateRequest) {
        User user = userRepository.findById(id).get();

        if(updateRequest.getFirstName() != null && !updateRequest.getFirstName().isBlank()){
            user.setFirstName(updateRequest.getFirstName());
        }
        if(updateRequest.getLastName() != null && !updateRequest.getLastName().isBlank()){
            user.setLastName(updateRequest.getLastName());
        }
        if(updateRequest.getEmail() != null && !updateRequest.getEmail().isBlank()){
            user.setEmail(updateRequest.getEmail());
        }
        if(updateRequest.getPassword() != null && !updateRequest.getPassword().isBlank()){
                user.setPassword(updateRequest.getPassword());
        }
        return userConverter.toResponse(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
