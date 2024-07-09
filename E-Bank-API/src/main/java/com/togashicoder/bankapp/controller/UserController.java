package com.togashicoder.bankapp.controller;

import com.togashicoder.bankapp.dto.UserDTO;
import com.togashicoder.bankapp.exception.UserNotFoundException;
import com.togashicoder.bankapp.model.User;
import com.togashicoder.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDTO userDto) {
        User registeredUser = userService.registerUser(userDto);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int userId) {
        try {
            User user = userService.getUserById(userId);
            UserDTO userDto = new UserDTO();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setAddress(user.getAddress());
            userDto.setPhone(user.getPhone());
            userDto.setCity(user.getCity());
            return ResponseEntity.ok(userDto);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable int userId, @RequestBody UserDTO userDto) {
        try {
            User updatedUser = userService.updateUser(userId, userDto);
            UserDTO responseDto = new UserDTO();
            responseDto.setName(updatedUser.getName());
            responseDto.setAddress(updatedUser.getAddress());
            responseDto.setPhone(updatedUser.getPhone());
            responseDto.setCity(updatedUser.getCity());

            return ResponseEntity.ok(responseDto);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable int userId) {
        try {
            userService.deleteUser(userId);
            UserDTO userDTO = new UserDTO();
                userDTO.setName("Delete userid "+ userId +" Done");
            return ResponseEntity.ok(userDTO);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDtos = userService.getAllUsers();
        return ResponseEntity.ok(userDtos);
    }


}
