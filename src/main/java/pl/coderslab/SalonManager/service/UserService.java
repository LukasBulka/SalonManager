package pl.coderslab.SalonManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.coderslab.SalonManager.model.User;
import pl.coderslab.SalonManager.model.UserPrincipal;
import pl.coderslab.SalonManager.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
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

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public String getUserWithEmail(Model model, String view) {
        String email = "";
        Object userPrincipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userPrincipal instanceof UserDetails) {
            email = ((UserDetails)userPrincipal).getUsername();
        }
        User user = userRepository.findByEmail(email);
        model.addAttribute("user", user);
        return view;
    }

    public User getUserWithEmail() {
        String email = "";
        Object userPrincipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userPrincipal instanceof UserDetails) {
            email = ((UserDetails)userPrincipal).getUsername();
        }
        User user = userRepository.findByEmail(email);
        return user;
    }
}
