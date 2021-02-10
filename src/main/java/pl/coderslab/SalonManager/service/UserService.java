package pl.coderslab.SalonManager.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.coderslab.SalonManager.controller.dto.UserToRegisterDto;
import pl.coderslab.SalonManager.model.User;

public interface UserService extends UserDetailsService {

    User save(UserToRegisterDto userToRegisterDto);
}
