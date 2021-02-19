package pl.coderslab.SalonManager.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.SalonManager.model.User;
import pl.coderslab.SalonManager.model.UserPrincipal;

@AllArgsConstructor
@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = this.userService.findUserByEmail(email);
        if (user.getEmail() == null) {
            throw new UsernameNotFoundException("No user found");
        }
        if (user.getPassword() == null) {
            throw new UsernameNotFoundException("No user found");
        }


        UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;
    }
}
