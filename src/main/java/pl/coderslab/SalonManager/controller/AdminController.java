package pl.coderslab.SalonManager.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.SalonManager.model.Order;
import pl.coderslab.SalonManager.model.User;
import pl.coderslab.SalonManager.service.OrderService;
import pl.coderslab.SalonManager.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserService userService;
    private final OrderService orderService;

    @ModelAttribute("roles")
    public List<String> roles() {
        return Arrays.asList("ADMIN", "EMPLOYEE", "USER");
    }

    @ModelAttribute("active")
    public List<Boolean> active() {
        return Arrays.asList(false, true);
    }

    @GetMapping
    public String dashboardAdmin() {
        return "administration";
    }

    @GetMapping("/showUsers")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "showUsers";
    }

    @GetMapping("/showFilteredUsers")
    public String showUsers(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] options = request.getParameterValues("options");
        List<User> filteredUsers = new ArrayList<>();
        List<User> users;
        if (options != null) {
            switch (options.length) {
                case 1:
                    users = userService.findAllUsers().stream().filter(el -> el.getRolesList().contains(options[0])).collect(Collectors.toList());
                    filteredUsers.addAll(users);
                    break;
                case 2:
                    users = userService.findAllUsers().stream().filter(el -> el.getRolesList().contains(options[0]) || el.getRolesList().contains(options[1])).collect(Collectors.toList());
                    filteredUsers.addAll(users);
                    break;
                case 3:
                    users = userService.findAllUsers().stream().filter(el -> el.getRolesList().contains(options[0]) || el.getRolesList().contains(options[1]) || el.getRolesList().contains(options[2])).collect(Collectors.toList());
                    filteredUsers.addAll(users);
                    break;
            }
        } else {
            response.sendRedirect("/admin/showUsers");
        }

        model.addAttribute("users", filteredUsers);
        return "showUsers";
    }

    @GetMapping("/addUser")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/addUser")
    public String addUserByAdmin(@ModelAttribute() @Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "userForm";
        } else {
            User userToSave = new User(
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    passwordEncoder.encode(user.getPassword()),
                    user.getRoles(), "", user.getActive());
            userService.saveUser(userToSave);
            return "redirect:/admin/showUsers";
        }
    }

    @GetMapping("/updateUser/{id}")
    public String showUpdateUserForm(@PathVariable Long id, Model model) {
        Optional<User> user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "updateUserByAdmin";
    }

    @PostMapping("/updateUser/{id}")
    public String updateUser(@PathVariable Long id,
                             @RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String email,
                             @RequestParam String password,
                             @RequestParam String roles,
                             @RequestParam Boolean active,
                             @ModelAttribute() @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateUserByAdmin";
        }
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(roles);
        user.setActive(active);

        userService.update(user, email);
        return "redirect:/admin/showUsers";
    }

    @GetMapping("/confirmRemoveUser/{id}")
    public String confirmRemoveUser(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "confirmRemoveUser";
    }

    @GetMapping("/removeUser/{id}")
    public String removeUser(@PathVariable Long id) {
        Optional<User> user = userService.findUserById(id);
        user.ifPresent(userService::deleteUser);
        return "redirect:/admin/showUsers";
    }

    @GetMapping("/showTimetable")
    public String showTimetable(Model model) {

        List<User> employees = userService.findAllUsers().stream().filter(el -> el.getRolesList().contains("EMPLOYEE")).collect(Collectors.toList());
        List<Order> orders = orderService.findAllOrders();
        Map<String, List<String>> timetables = new HashMap<>();

        for (User user : employees) {
            List<String> strings = orders.stream().filter(el -> el.getPerformedBy().equals(user)).map(Order::getOrderCompletionDate).sorted().collect(Collectors.toList());
            timetables.put(user.getFirstName(), strings);
        }

        model.addAttribute("timetables", timetables);
        return "timetable";
    }
}
