package DanielaPetrova.UserCarProject.controller;

import DanielaPetrova.UserCarProject.dto.UpdateUserRequest;
import DanielaPetrova.UserCarProject.dto.UserRegisterRequest;
import DanielaPetrova.UserCarProject.dto.UserResponse;
import DanielaPetrova.UserCarProject.entity.User;
import DanielaPetrova.UserCarProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<User> saveUser(@RequestBody UserRegisterRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.addUser(request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(userService.getUser(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id,
                                                   @RequestBody UpdateUserRequest userRequest){
        UserResponse userResponse = userService.updateUser(id, userRequest);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @DeleteMapping(path = "/{id}")
    public HttpStatus deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return HttpStatus.ACCEPTED;
    }
}
