package pl.coderslab.SalonManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.SalonManager.model.Order;
import pl.coderslab.SalonManager.model.User;
import pl.coderslab.SalonManager.service.OrderService;
import pl.coderslab.SalonManager.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("timetable")
public class TimetableController {

    private final UserService userService;
    private final OrderService orderService;

    public TimetableController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
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
