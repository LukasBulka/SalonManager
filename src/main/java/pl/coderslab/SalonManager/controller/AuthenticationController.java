package pl.coderslab.SalonManager.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.SalonManager.model.User;
import pl.coderslab.SalonManager.repository.UserRepository;

@Controller
@AllArgsConstructor
@RequestMapping("/authentication")
public class AuthenticationController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registrationForm";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("user") User user) {
        User userToSave = new User(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                passwordEncoder.encode(user.getPassword()),
                "USER",
                "");
        userRepository.save(userToSave);
        return "redirect:/authentication/registration?success=true";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "loginForm";
    }

    @PostMapping("/login")
    public String login() {
        return "redirect:/authentication/login?success=true";
    }
}
