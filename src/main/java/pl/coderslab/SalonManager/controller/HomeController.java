package pl.coderslab.SalonManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public String home() { return "home";
    }

    @GetMapping("/about")
    public String about() { return "about";
    }

    @GetMapping("/price")
    public String price() { return "price";
    }

    @GetMapping("/contact")
    public String contact() { return "contact";
    }

    @GetMapping("/dashboard")
    public String dashboard() { return "redirect:/dashboardDispatcher";
    }

    @GetMapping("/register")
    public String register() { return "redirect:/authentication/registration";
    }

    @GetMapping("/login")
    public String login() { return "redirect:/authentication/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logoutForm";
    }
}
