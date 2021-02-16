package pl.coderslab.SalonManager.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.SalonManager.model.User;
import pl.coderslab.SalonManager.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepository;

    @ModelAttribute("roles")
    public Collection<String> roles() {
        List<String> roles = new ArrayList<>();
        roles.add("ADMIN");
        roles.add("EMPLOYEE");
        roles.add("USER");
        return roles;
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

    @GetMapping("/showFilteredUsers")
    public String showUsers(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] options = request.getParameterValues("options");
        List<User> filteredUsers = new ArrayList<>();
        List<User> users;
        if (options != null) {//sprobowac zrobis z options tablice bo metoda asList domyslnie nie moze byc nullem
            switch (options.length) {
                case 1:
                    users = userRepository.findAll().stream().filter(el -> el.getRolesList().contains(options[0])).collect(Collectors.toList());
                    filteredUsers.addAll(users);
                    break;
                case 2:
                    users = userRepository.findAll().stream().filter(el -> el.getRolesList().contains(options[0]) || el.getRolesList().contains(options[1])).collect(Collectors.toList());
                    filteredUsers.addAll(users);
                    break;
                case 3:
                    users = userRepository.findAll().stream().filter(el -> el.getRolesList().contains(options[0]) || el.getRolesList().contains(options[1]) || el.getRolesList().contains(options[2])).collect(Collectors.toList());
                    filteredUsers.addAll(users);
                    break;
            }
        }else {
            response.sendRedirect("/admin/showUsers");
        }

        model.addAttribute("users", filteredUsers);
        return "showUsers";
    }
}
