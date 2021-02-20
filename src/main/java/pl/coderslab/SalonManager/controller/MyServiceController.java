package pl.coderslab.SalonManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.SalonManager.model.MyService;
import pl.coderslab.SalonManager.service.MyServiceService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/myService")
public class MyServiceController {

    private final MyServiceService myServiceService;

    public MyServiceController(MyServiceService myServiceService) {
        this.myServiceService = myServiceService;
    }

    @GetMapping("/showServices")
    public String showServicesList(Model model) {
        model.addAttribute("services", myServiceService.findAllServices());
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
            myServiceService.saveMyService(myServiceToSave);
            return "redirect:/myService/showServices";
        }
    }

    @GetMapping("/updateService/{id}")
    public String showUpdateServiceForm(@PathVariable Long id, Model model) {
        Optional<MyService> myService = myServiceService.findMyServiceById(id);
        model.addAttribute("myService", myService);
        return "updateServiceForm";
    }

    @PostMapping("/updateService/{id}")
    public String updateService(@PathVariable Long id,
                                @RequestParam String name,
                                @RequestParam int price,
                                @RequestParam String currency,
                                @ModelAttribute() @Valid MyService myService,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "updateServiceForm";
        } else {
            myService.setName(name);
            myService.setPrice(price);
            myService.setCurrency(currency);

            myServiceService.saveMyService(myService);
            return "redirect:/myService/showServices";
        }
    }

    @GetMapping("/confirmRemoveService/{id}")
    public String confirmRemoveService(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "confirmRemoveService";
    }

    @GetMapping("/removeService/{id}")
    public String removeService(@PathVariable Long id) {
        Optional<MyService> myService = myServiceService.findMyServiceById(id);
        myService.ifPresent(myServiceService::deleteMyService);
        return "redirect:/myService/showServices";
    }
}
