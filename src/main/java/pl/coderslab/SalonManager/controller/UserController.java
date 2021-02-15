package pl.coderslab.SalonManager.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.SalonManager.model.User;
import pl.coderslab.SalonManager.model.UserUpdater;
import pl.coderslab.SalonManager.repository.UserRepository;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserUpdater userUpdater;

    @GetMapping
    public String showUserAccount() {
        return "userAccount";
    }

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

    @GetMapping("/orderService")
    public String orderServiceForm() {
        return "orderService";
    }



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
