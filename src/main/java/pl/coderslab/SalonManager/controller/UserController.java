package pl.coderslab.SalonManager.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.SalonManager.model.User;
import pl.coderslab.SalonManager.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping
    public String showUserAccount() {
        return "userAccount";
    }

    @GetMapping("/myProfile")
    public String showUserProfile(Model model) {
        return userService.getUserWithEmail(model, "showUserProfile");
    }

    @GetMapping("/editProfile")
    public String showEditUserProfileForm(Model model) {
        return userService.getUserWithEmail(model, "updateUserProfile");
    }

    @PostMapping("/editProfile")
    public String getEditUserProfileFromForm(@RequestParam String firstName,
                                             @RequestParam String lastName,
                                             @RequestParam String email,
                                             @RequestParam String password,
                                             @ModelAttribute() @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateUserProfile";
        } else {
            user = userService.getUserWithEmail();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(passwordEncoder.encode(password));
            user.setActive(true);

            userService.update(user, email);
            return "userAccount";
        }
    }

    @GetMapping("/confirmRemoveUserAccount")
    public String confirmRemoveUserAccount() {
        return "confirmRemoveUserAccount";
    }

    @GetMapping("/removeProfile")
    public String removeAccount(HttpServletRequest request) {
        User user = userService.getUserWithEmail();
        if (user != null) {
            userService.deleteUserById(user.getId());
            request.getSession().invalidate();
        }
        return "redirect:/?success=true";
    }
}
