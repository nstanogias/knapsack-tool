package com.nstanogias.knapsack.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by nickstanogias on 17/11/18.
 */
@Data
public class SignUpRequest {
    @NotBlank(message = "name is required")
    @Size(min = 4, max = 40)
    private String name;

    @NotBlank(message = "username is required")
    @Size(min = 3, max = 15)
    private String username;

    @NotBlank(message = "email is required")
    @Size(max = 40)
    @Email(message = "not a valid email")
    private String email;

    @NotBlank(message = "Password field is required")
    @Size(min = 6, max = 20)
    private String password;
}
