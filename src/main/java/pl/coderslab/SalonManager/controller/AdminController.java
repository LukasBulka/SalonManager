package pl.coderslab.SalonManager.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.SalonManager.model.User;
import pl.coderslab.SalonManager.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepository;

    @GetMapping
    public String dashboardAdmin() {
        return "adminDashboard";
    }

    @GetMapping("/showUsers")
    public String showUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "showUsers";
    }
}
