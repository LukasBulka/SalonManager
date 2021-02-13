package pl.coderslab.SalonManager.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.SalonManager.controller.dto.UserToRegisterDto;
import pl.coderslab.SalonManager.model.Role;
import pl.coderslab.SalonManager.model.User;
import pl.coderslab.SalonManager.repository.UserRepository;

import java.util.*;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private Set<GrantedAuthority> grantedAuthorities;

    @Override
    public User save(UserToRegisterDto userToRegisterDto) {
        User user = new User(
                userToRegisterDto.getFirstName(),
                userToRegisterDto.getLastName(),
                userToRegisterDto.getEmail(),
                passwordEncoder.encode(userToRegisterDto.getPassword()),
                new HashSet<Role>(Arrays.asList(new Role("ROLE_USER"))));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User with email not found");
        }
        grantedAuthorities = new HashSet<>();
        user.getRoles().forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }

    public Set<GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }
}
