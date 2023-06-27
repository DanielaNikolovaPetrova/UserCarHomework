package DanielaPetrova.UserCarProject.service;

import DanielaPetrova.UserCarProject.dto.UpdateUserRequest;
import DanielaPetrova.UserCarProject.dto.UserRegisterRequest;
import DanielaPetrova.UserCarProject.dto.UserResponse;
import DanielaPetrova.UserCarProject.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
   User addUser(UserRegisterRequest request);
   UserResponse getUser(Long id);
   UserResponse updateUser(Long id, UpdateUserRequest response);
   void deleteUser(Long id);
}
