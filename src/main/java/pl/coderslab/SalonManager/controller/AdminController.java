package pl.coderslab.SalonManager.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.SalonManager.model.User;
import pl.coderslab.SalonManager.repository.UserRepository;
import java.util.Arrays;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepository;

    @ModelAttribute("roles")
    public List<String> roles() {
        return Arrays.asList("ADMIN", "EMPLOYEE", "USER");
    }


    @GetMapping
    public String dashboardAdmin() {
        return "administration";
    }

    @GetMapping("/showUsers")
    public String showUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "showUsers";
    }

    @GetMapping("/showEmployees")
    public String showEmployees(Model model) {
        List<User> users = userRepository.findByRoles("ADMIN, EMPLOYEE");
        model.addAttribute("users", users);
        return "showUsers";
    }
}
