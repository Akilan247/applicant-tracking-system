package com.akilan.application_tracking_system.Service;

import com.akilan.application_tracking_system.DTO.RequestDto.UserRequestDto;
import com.akilan.application_tracking_system.DTO.Response.UserResponseDto;
import com.akilan.application_tracking_system.Entity.Users;
import com.akilan.application_tracking_system.Exception.UserAlreadyExistException;
import com.akilan.application_tracking_system.Repo.UserDetailsJpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRequestService {

    private final UserDetailsJpaRepository userDetailsJpaRepository;
    private final PasswordEncoder passwordEncoder;
    public UserRequestService(UserDetailsJpaRepository userDetailsJpaRepository, PasswordEncoder passwordEncoder) {
        this.userDetailsJpaRepository = userDetailsJpaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDto registerUser(UserRequestDto userRequestDto){
        if(userDetailsJpaRepository.findByUserName(userRequestDto.getUsername()).isPresent()){
            throw new UserAlreadyExistException("User Already exist...");
        }

        Users users = new Users();
        users.setUsername(userRequestDto.getUsername());
        users.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        users.setRole(userRequestDto.getRole());

        Users saveduUsers = userDetailsJpaRepository.save(users);

        return new UserResponseDto(saveduUsers.getId(),
                saveduUsers.getUsername(),
                saveduUsers.getRole());
    }
}
