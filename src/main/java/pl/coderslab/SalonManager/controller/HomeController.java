package pl.coderslab.SalonManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.SalonManager.service.MyServiceService;

@Controller
@RequestMapping("/")
public class HomeController {

    private final MyServiceService myServiceService;

    public HomeController(MyServiceService myServiceService) {
        this.myServiceService = myServiceService;
    }

    @GetMapping("")
    public String home() { return "home";
    }

    @GetMapping("/about")
    public String about() { return "about";
    }

    @GetMapping("/price")
    public String price(Model model) {
        model.addAttribute("services", myServiceService.findAllServices());
        return "price";
    }

    @GetMapping("/contact")
    public String contact() { return "contact";
    }

    @GetMapping("/userAccount")
    public String userAccount() { return "redirect:/user";
    }

    @GetMapping("/administration")
    public String administration() { return "redirect:/admin";
    }

    @GetMapping("/management")
    public String management() { return "redirect:/employee";
    }

    @GetMapping("/register")
    public String register() {
        return "redirect:/authentication/registration";
    }

    @GetMapping("/login")
    public String login() {
        return "redirect:/authentication/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logoutForm";
    }
}
