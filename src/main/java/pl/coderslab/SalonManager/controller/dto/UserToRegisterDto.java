package pl.coderslab.SalonManager.controller.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserToRegisterDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
