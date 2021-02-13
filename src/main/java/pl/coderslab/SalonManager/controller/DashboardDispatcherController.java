package pl.coderslab.SalonManager.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.SalonManager.service.UserServiceImpl;

@Controller
@AllArgsConstructor
@RequestMapping("/dashboardDispatcher")
public class DashboardDispatcherController {

    private final UserServiceImpl userService;

    @GetMapping
    public String dispatch() {
        String view = "";
        for (GrantedAuthority grantedAuthority : userService.getGrantedAuthorities()) {
            switch (grantedAuthority.getAuthority()) {
                case "ROLE_ADMIN":
                    view = "redirect:/admin";
                    break;
                case "ROLE_EMPLOYEE":
                    view = "redirect:/employee";
                    break;
                case "ROLE_USER":
                    view = "redirect:/user";
                    break;
            }
        }
        return view;
    }

//    @GetMapping("/admin")
//    public String dashboardDispatcherAdmin() {
//        return "redirect:/admin";
//    }
//
//    @GetMapping("/employee")
//    public String dashboardDispatcherEmployee() {
//        return "employeeDashboard";
//    }
//
//    @GetMapping("/user")
//    public String dashboardDispatcherUser() {
//        return "userDashboard";
//    }
}
