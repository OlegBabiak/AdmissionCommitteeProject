package lviv.university.committee.controllers;

import lviv.university.committee.dtos.UserRegistrationRequest;
import lviv.university.committee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@ModelAttribute UserRegistrationRequest userDto) {
        userService.register(userDto);
        return "redirect:/login";
    }

    @GetMapping("/registration")
    public String getRegisterPage(Model model) {
        model.addAttribute("userDto", new UserRegistrationRequest());
        return "registration";
    }
}
