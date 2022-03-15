package de.neuefische.backend.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyUserDto {
    private String username;
    private String role;
}
