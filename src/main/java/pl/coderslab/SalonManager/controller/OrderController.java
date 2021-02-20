package pl.coderslab.SalonManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.SalonManager.model.MyService;
import pl.coderslab.SalonManager.model.Order;
import pl.coderslab.SalonManager.model.User;
import pl.coderslab.SalonManager.service.MyServiceService;
import pl.coderslab.SalonManager.service.OrderService;
import pl.coderslab.SalonManager.service.UserService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final UserService userService;
    private final OrderService orderService;
    private final MyServiceService myServiceService;

    @Autowired
    public OrderController(UserService userService,
                           OrderService orderService,
                           MyServiceService myServiceService) {
        this.userService = userService;
        this.orderService = orderService;
        this.myServiceService = myServiceService;
    }

    @ModelAttribute("performedBy")
    public List<User> performedBy() {
        List<User> users = userService.findAllUsers();
        List<User> employees = new ArrayList<>();
        users.stream().filter(el -> el.getRolesList().contains("EMPLOYEE")).forEach(employees::add);
        return employees;

    }

    @ModelAttribute("services")
    public List<MyService> services() {
        return myServiceService.findAllServices();
    }

    @GetMapping("/showOrders")
    public String showOrders(Model model) {
        model.addAttribute("orders", orderService.findAllOrders());
        return "showOrders";
    }

    @GetMapping("/showUsersOrders")
    public String showOrdersByUser(Model model) {
        User user = userService.getUserWithEmail();
        List<Order> userOrders = new ArrayList<>();
        List<Order> allOrders = orderService.findAllOrders();
        allOrders.stream().filter(el -> el.getOrderedBy().getId().equals(user.getId())).forEach(userOrders::add);

        model.addAttribute("usersOrders", userOrders);
        return "showUsersOrders";
    }

    @GetMapping("/orderService")
    public String showOrderServiceForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderServiceForm";
    }

    @PostMapping("/orderService")
    public String addOrder(@RequestParam()
//                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                   String orderCompletionDate, @ModelAttribute() @Valid Order order, BindingResult bindingResult) {

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        LocalDateTime dateTime = LocalDateTime.parse(orderCompletionDate, formatter);
        if (bindingResult.hasErrors()) {
            return "updateOrderForm";
        } else {
            Order orderToSave = new Order(
                    order.getName(),
                    userService.getUserWithEmail(),
                    order.getPerformedBy(),
                    order.getServices(),
                    orderCompletionDate,
                    LocalDateTime.now(),
                    LocalDateTime.now());
            orderService.saveOrder(orderToSave);
        }

        if (userService.getUserWithEmail().getRolesList().contains("USER")) {
            return "redirect:/order/showUsersOrders";
        }
        return "redirect:/order/showOrders";
    }

    @GetMapping("/updateOrder/{id}")
    public String showUpdateOrderForm(@PathVariable Long id, Model model) {
        Optional<Order> order = orderService.findOrderById(id);
        model.addAttribute("order", order);
        return "updateOrderForm";
    }

    @PostMapping("/updateOrder/{id}")
    public String updateOrder(@PathVariable Long id,
                              @RequestParam String name,
                              @RequestParam User performedBy,
                              @RequestParam List<MyService> services,
                              @RequestParam String orderCompletionDate,
                              @ModelAttribute() @Valid Order order, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "updateOrderForm";
        } else {
            order.setName(name);
            order.setOrderedBy(userService.getUserWithEmail());
            order.setPerformedBy(performedBy);
            order.setServices(services);
            order.setOrderCompletionDate(orderCompletionDate);
            order.setUpdatedAt(LocalDateTime.now());


            orderService.saveOrder(order);
            }
        if (userService.getUserWithEmail().getRolesList().contains("USER")) {
            return "redirect:/order/showUsersOrders";
        }
        return "redirect:/order/showOrders";
    }

    @GetMapping("/confirmRemoveOrderByUser/{id}")
    public String confirmRemoveOrderByUser(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "confirmRemoveOrderByUser";
    }

    @GetMapping("/confirmRemoveOrderByOthers/{id}")
    public String confirmRemoveOrderByOthers(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "confirmRemoveOrderByOthers";
    }

    @GetMapping("/removeOrder/{id}")
    public String removeOrder(@PathVariable Long id) {
        Optional<Order> order = orderService.findOrderById(id);
        order.ifPresent(orderService::deleteOrder);
        if (userService.getUserWithEmail().getRolesList().contains("USER")) {
            return "redirect:/order/showUsersOrders";
        }
        return "redirect:/order/showOrders";
    }

}
