package com.togashicoder.bankapp.service;

import com.togashicoder.bankapp.dto.UserDTO;
import com.togashicoder.bankapp.exception.UserNotFoundException;
import com.togashicoder.bankapp.model.User;

import java.util.List;

public interface UserService {
    /**
     * Registers a new user with the details provided in the UserDTO.
     *
     * @param userDto the data transfer object containing user details
     * @return the registered User object
     */
    User registerUser(UserDTO userDto);

    /**
     * Retrieves a user by their ID.
     *
     * @param userId the ID of the user to retrieve
     * @return the found User object
     * @throws UserNotFoundException if no user is found with the provided ID
     */
    User getUserById(int userId) throws UserNotFoundException;

    /**
     * Updates the information of an existing user identified by userId.
     *
     * @param userId the ID of the user to update
     * @param userDto the data transfer object containing updated user details
     * @return the updated User object
     * @throws UserNotFoundException if no user is found with the provided ID
     */
    User updateUser(int userId, UserDTO userDto) throws UserNotFoundException;

    /**
     * Deletes a user identified by userId.
     *
     * @param userId the ID of the user to delete
     * @throws UserNotFoundException if no user is found with the provided ID
     */
    void deleteUser(int userId) throws UserNotFoundException;

    /**
     * Retrieves a list of all registered users .
     *
     * @return a list of UserDTO objects
     */
    List<UserDTO> getAllUsers();
}
