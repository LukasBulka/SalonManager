package pl.coderslab.SalonManager.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.coderslab.SalonManager.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserUpdater {

    private final UserRepository userRepository;

    public UserUpdater(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void update(User user, String email) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object object = authentication.getPrincipal();
        if (object instanceof UserPrincipal) {
            ((UserPrincipal)object).getUser().setEmail(email);
            user.setEmail(((UserPrincipal) object).getUsername());
        }
        List<GrantedAuthority> updatedAuthorities = new ArrayList<>(authentication.getAuthorities());
        updatedAuthorities.add(new SimpleGrantedAuthority(user.getRoles()));

        Authentication newAuthentication = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), updatedAuthorities);
        SecurityContextHolder.getContext().setAuthentication(newAuthentication);

        userRepository.save(user);
    }
}
