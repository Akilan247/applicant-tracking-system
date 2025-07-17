package com.akilan.application_tracking_system.Controller;

import com.akilan.application_tracking_system.DTO.Role;
import com.akilan.application_tracking_system.DTO.RequestDto.UserRequestDto;
import com.akilan.application_tracking_system.DTO.Response.UserResponseDto;
import com.akilan.application_tracking_system.Service.UserRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class UserController {

    @Autowired
    private UserRequestService userRequestService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@RequestBody UserRequestDto userRequestDto){
        userRequestDto.setRole(Role.USER);
        System.out.println(userRequestDto.getUsername()); ///userName changes//
        return ResponseEntity.ok(userRequestService.registerUser(userRequestDto));
    }
}