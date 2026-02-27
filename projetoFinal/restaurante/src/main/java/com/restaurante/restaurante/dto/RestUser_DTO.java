package com.restaurante.restaurante.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestUser_DTO {
    private Long id;
    private String username;
    private String cargo; // admin, p. ex.
}
