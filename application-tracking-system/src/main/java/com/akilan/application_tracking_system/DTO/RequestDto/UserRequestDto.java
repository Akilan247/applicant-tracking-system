package com.akilan.application_tracking_system.DTO.RequestDto;

import com.akilan.application_tracking_system.DTO.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    private String username;
    private String password;
    private Role role;

}
