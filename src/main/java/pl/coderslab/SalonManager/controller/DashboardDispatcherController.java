package pl.coderslab.SalonManager.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.SalonManager.model.UserPrincipal;

@Controller
@AllArgsConstructor
@RequestMapping("/dashboardDispatcher")
public class DashboardDispatcherController {


//    @GetMapping
//    public String dispatch() {
//        String view = "";
//            switch (grantedAuthority.getAuthority()) {
//                case "ROLE_ADMIN":
//                    view = "redirect:/admin";
//                    break;
//                case "ROLE_EMPLOYEE":
//                    view = "redirect:/employee";
//                    break;
//                case "ROLE_USER":
//                    view = "redirect:/user";
//                    break;
//            }
//        return view;
//    }

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
