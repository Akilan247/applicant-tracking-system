package com.akilan.application_tracking_system.DTO.Response;

import com.akilan.application_tracking_system.DTO.Role;

public class UserResponseDto {

    private Long id;
    private String username;
    public Role role;

    public UserResponseDto(Long id, String username, Role role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

