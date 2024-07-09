package com.togashicoder.bankapp.utils;

import com.togashicoder.bankapp.dto.UserDTO;
import com.togashicoder.bankapp.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO convertUserToUserDTO(User user)
    {
            UserDTO userDto = modelMapper.map(user,UserDTO.class);
        return userDto;
    }

    public User convertUserDToToUser(UserDTO userDTO)
    {
            User user = modelMapper.map(userDTO,User.class);
        return user;
    }

}
