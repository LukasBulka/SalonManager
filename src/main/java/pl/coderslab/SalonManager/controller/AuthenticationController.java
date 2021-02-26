package pl.coderslab.SalonManager.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.SalonManager.model.User;
import pl.coderslab.SalonManager.repository.UserRepository;
import pl.coderslab.SalonManager.service.UserService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/authentication")
public class AuthenticationController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registrationForm";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {

        User userAlreadyExists = userService.findUserByEmail(user.getEmail());
        if (userAlreadyExists != null) {
            bindingResult.rejectValue("email", "error.user", "*There is already a user registered with the given email, please provide another email");
        }
        if (bindingResult.hasErrors()) {
            return "registrationForm";
        } else {
            User userToSave = new User(
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    passwordEncoder.encode(user.getPassword()),
                    "USER",
                    "", true);
            userService.saveUser(userToSave);
            return "redirect:/?registrationSuccess=true";
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "loginForm";
    }
}

