package DanielaPetrova.UserCarProject.converter;

import DanielaPetrova.UserCarProject.dto.UserRegisterRequest;
import DanielaPetrova.UserCarProject.dto.UserResponse;
import DanielaPetrova.UserCarProject.entity.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserConverter {
    public User toUser(UserRegisterRequest request){
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

    public UserResponse toResponse(User savedUser){
        return new UserResponse(
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail());
    }
}
