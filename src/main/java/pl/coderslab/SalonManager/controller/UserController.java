package pl.coderslab.SalonManager.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.SalonManager.controller.dto.UserToRegisterDto;
import pl.coderslab.SalonManager.service.UserService;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserToRegisterDto());
        return "registrationForm";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("user")UserToRegisterDto userToRegisterDto) {
        userService.save(userToRegisterDto);
        return "redirect:/users/registration?success";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "loginForm";
    }

    @PostMapping("/login")
    public String login() {
        return "dashboard";
    }
}
