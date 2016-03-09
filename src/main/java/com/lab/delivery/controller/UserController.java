package com.lab.delivery.controller;

import com.lab.delivery.domain.user.User;
import com.lab.delivery.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by Mantixop on 2/16/16.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/registration";
    }

    @RequestMapping(value = "/users")
    public String showUsers(Map<String, Object> model){
        model.put("users", userService.findAll());
        return "user/list";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount
            (@ModelAttribute("user") @Valid User user,
             BindingResult result) {
        if (!result.hasErrors()) {
            user = createUserAccount(user);
        }
        if (user == null) {
            result.rejectValue("email", "message.regError", "Default error message");
        }
        if (result.hasErrors()) {
            return new ModelAndView("user/registration", "user", user);
        }
        else {
            return new ModelAndView("/login", "user", user);
        }
    }
    private User createUserAccount(User user) {
        User registered = userService.registerNewUserAccount(user);
        return registered;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editUser(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        model.addAttribute("user",userService.findByEmail(email));
        return "user/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@Valid User user, BindingResult result) {
        if (!result.hasErrors()) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User savedUser = userService.findByEmail(auth.getName());
            savedUser.setAddress(user.getAddress());
            savedUser.setPhone(user.getPhone());
            savedUser.setName(user.getName());
            userService.updateUser(savedUser);
            return "index";
        }
        return "redirect:/edit";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLogin() {
        return "user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET, params = "error")
    public String viewLoginWithError(Model model) {
        model.addAttribute("error", true);
        return "user/login";
    }
}
