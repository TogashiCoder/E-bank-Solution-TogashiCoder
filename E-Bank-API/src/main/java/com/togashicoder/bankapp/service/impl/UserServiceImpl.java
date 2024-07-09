package com.togashicoder.bankapp.service.impl;

import com.togashicoder.bankapp.utils.UserDTOConverter;
import com.togashicoder.bankapp.dto.UserDTO;
import com.togashicoder.bankapp.exception.UserNotFoundException;
import com.togashicoder.bankapp.model.User;
import com.togashicoder.bankapp.repository.UserRepository;
import com.togashicoder.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



    @Service
    @Transactional
    public class UserServiceImpl implements UserService {
        @Autowired
        private UserRepository userRepository;
        @Autowired
        UserDTOConverter userDTOConverter;

        @Override
        public User registerUser(UserDTO userDto) {
            User newUser = userDTOConverter.convertUserDToToUser(userDto);  // Corrected the method name here
            newUser.setAccounts(new ArrayList<>());
            return userRepository.save(newUser);
        }

        @Override
        public User getUserById(int userId) throws UserNotFoundException {
            return userRepository.findById(userId)
                    .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));
        }

        @Override
        public User updateUser(int userId, UserDTO userDto) {
            User existingUser = userRepository.findById(userId)
                    .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));

            User updatedUser = userDTOConverter.convertUserDToToUser(userDto); // Corrected the method name here
            updatedUser.setId(userId); // Ensure the ID is set to the existing user's ID

            return userRepository.save(updatedUser);
        }

        @Override
        public void deleteUser(int userId) throws UserNotFoundException {
            if (!userRepository.existsById(userId)) {
                throw new UserNotFoundException("User not found with ID: " + userId);
            }
            userRepository.deleteById(userId);
        }

        @Override
        public List<UserDTO> getAllUsers() {
            List<User> users = userRepository.findAll();
            return users.stream()
                    .map(userDTOConverter::convertUserToUserDTO) // Using the existing method for converting User to UserDTO
                    .collect(Collectors.toList());
        }
    }


