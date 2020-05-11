package lviv.university.committee.controllers;

import lviv.university.committee.dtos.UserRegistrationRequest;
import lviv.university.committee.service.UserService;
import lviv.university.committee.validators.UserRegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {

    private final UserService userService;
    private final Validator validator;

    @Autowired
    public RegistrationController(UserService userService, @Qualifier("userRegistrationValidator") Validator validator) {
        this.userService = userService;
        this.validator = validator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @PostMapping("/register")
    public String register(Model model,
                           @ModelAttribute("userDto") @Validated UserRegistrationRequest userDto,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "registration";
        }
        userService.register(userDto);
        return "redirect:/login";
    }

    @GetMapping("/registration")
    public String getRegisterPage(Model model) {
        model.addAttribute("userDto", new UserRegistrationRequest());
        return "registration";
    }
}
