package pl.coderslab.SalonManager.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.SalonManager.model.User;
import pl.coderslab.SalonManager.model.UserUpdater;
import pl.coderslab.SalonManager.repository.MyServiceRepository;
import pl.coderslab.SalonManager.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final MyServiceRepository myServiceRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserUpdater userUpdater;

    // display user panel

    @GetMapping
    public String showUserAccount() {
        return "userAccount";
    }

    // User CRUD

    @GetMapping("/myProfile")
    public String showUserProfile(Model model) {
        return getUserWithEmail(model, "showUserProfile");
    }

    @GetMapping("/editProfile")
    public String showEditUserProfileForm(Model model) {
        return getUserWithEmail(model, "updateUserProfile");
    }

    @PostMapping("/editProfile")
    public String getEditUserProfileFromForm(@RequestParam String firstName,
                                             @RequestParam String lastName,
                                             @RequestParam String email,
                                             @RequestParam String password) {
        User user = getUserWithEmail();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(passwordEncoder.encode(password));

        userUpdater.update(user,email);
        return "userAccount";
    }

    @GetMapping("/confirmRemoveUserAccount")
    public String confirmRemoveUserAccount() {
        return "confirmRemoveUserAccount";
    }

    @GetMapping("/removeProfile")
    public String removeAccount(HttpServletRequest request) {
        User user = getUserWithEmail();
        if (user != null) {
            userRepository.deleteById(user.getId());
            request.getSession().invalidate();
        }
        return "redirect:/?success=true";
    }


    // Services

    @GetMapping("/servicesList")
    public String showServicesList(Model model) {
        model.addAttribute("services", myServiceRepository.findAll());
        return "showServices";
    }

    // Orders

    @GetMapping("/orderService")
    public String orderServiceForm() {
        return "orderServiceForm";
    }




    // helping methods

    private String getUserWithEmail(Model model, String view) {
        String email = "";
        Object userPrincipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userPrincipal instanceof UserDetails) {
            email = ((UserDetails)userPrincipal).getUsername();
        }
        User user = userRepository.findByEmail(email);
        model.addAttribute("user", user);
        return view;
    }

    private User getUserWithEmail() {
        String email = "";
        Object userPrincipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userPrincipal instanceof UserDetails) {
            email = ((UserDetails)userPrincipal).getUsername();
        }
        User user = userRepository.findByEmail(email);
        return user;
    }
}
