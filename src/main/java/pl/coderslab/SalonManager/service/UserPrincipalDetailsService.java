package pl.coderslab.SalonManager.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.SalonManager.model.User;
import pl.coderslab.SalonManager.model.UserPrincipal;
import pl.coderslab.SalonManager.repository.UserRepository;

@AllArgsConstructor
@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = this.userRepository.findByEmail(email);

        UserPrincipal userPrincipal = new UserPrincipal(user);
        if (userPrincipal.getUser().getEmail() == null) {
            throw new UsernameNotFoundException("No user found");
        }
        if (userPrincipal.getUser().getPassword() == null) {
            throw new UsernameNotFoundException("No user found");
        }

        return userPrincipal;
    }
}
