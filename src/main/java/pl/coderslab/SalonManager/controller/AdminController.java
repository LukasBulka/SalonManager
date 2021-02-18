package pl.coderslab.SalonManager.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.SalonManager.model.MyService;
import pl.coderslab.SalonManager.model.User;
import pl.coderslab.SalonManager.model.UserUpdater;
import pl.coderslab.SalonManager.repository.MyServiceRepository;
import pl.coderslab.SalonManager.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserUpdater userUpdater;
    private final MyServiceRepository myServiceRepository;

    // ModelAttributes

    @ModelAttribute("roles")
    public List<String> roles() {
        return Arrays.asList("ADMIN", "EMPLOYEE", "USER");
    }

    @ModelAttribute("active")
    public List<Boolean> active() {
        return Arrays.asList(false, true);
    }

    @ModelAttribute("currency")
    public List<String> currency() {
        return Arrays.asList("PLN", "USD", "EUR");
    }

    // display admin section

    @GetMapping
    public String dashboardAdmin() {
        return "administration";
    }

    @GetMapping("/showUsers")
    public String showUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "showUsers";
    }

    // Filtering users

    @GetMapping("/showFilteredUsers")
    public String showUsers(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] options = request.getParameterValues("options");
        List<User> filteredUsers = new ArrayList<>();
        List<User> users;
        if (options != null) {
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
        } else {
            response.sendRedirect("/admin/showUsers");
        }

        model.addAttribute("users", filteredUsers);
        return "showUsers";
    }

    // Users

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
                    user.getRoles(), "");
            userRepository.save(userToSave);
            return "redirect:/admin/showUsers";
        }
    }


    @GetMapping("/updateUser/{id}")
    public String showUpdateUserForm(@PathVariable Long id, Model model) {
        Optional<User> user = userRepository.findById(id);
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

        userUpdater.update(user, email);
        return "redirect:/admin/showUsers";
    }


    @GetMapping("/confirmRemoveUser/{id}")
    public String confirmRemoveUser(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "confirmRemoveUser";
    }

    @GetMapping("/removeUser/{id}")
    public String removeUser(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(userRepository::delete);
        return "redirect:/admin/showUsers";
    }

    // Services

    @GetMapping("/showServices")
    public String showServices(Model model) {
        model.addAttribute("services", myServiceRepository.findAll());
        return "showServices";
    }

    @GetMapping("/addService")
    public String showAddServiceForm(Model model) {
        model.addAttribute("myService", new MyService());
        return "serviceForm";
    }

    @PostMapping("/addService")
    public String addServiceByAdmin(@ModelAttribute() @Valid MyService myService, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "serviceForm";
        } else {
            MyService myServiceToSave = new MyService(
                    myService.getName(),
                    myService.getPrice(),
                    myService.getCurrency());
            myServiceRepository.save(myServiceToSave);
            return "redirect:/admin/showServices";
        }
    }

    @GetMapping("/updateService/{id}")
    public String showUpdateServiceForm(@PathVariable Long id, Model model) {
        Optional<MyService> myService = myServiceRepository.findById(id);
        model.addAttribute("myService", myService);
        return "updateServiceForm";
    }

    @PostMapping("/updateService/{id}")
    public String updateService(@PathVariable Long id,
                                @RequestParam String name,
                                @RequestParam int price,
                                @RequestParam String currency, @ModelAttribute() @Valid MyService myService, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "updateServiceForm";
        } else {
            myService.setName(name);
            myService.setPrice(price);
            myService.setCurrency(currency);

            myServiceRepository.save(myService);
            return "redirect:/admin/showServices";
        }
    }

    @GetMapping("/confirmRemoveService/{id}")
    public String confirmRemoveService(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "confirmRemoveService";
    }

    @GetMapping("/removeService/{id}")
    public String removeService(@PathVariable Long id) {
        Optional<MyService> myService = myServiceRepository.findById(id);
        myService.ifPresent(myServiceRepository::delete);
        return "redirect:/admin/showServices";
    }
}
