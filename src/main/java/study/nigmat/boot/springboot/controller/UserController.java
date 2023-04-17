package study.nigmat.boot.springboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import study.nigmat.boot.springboot.model.User;
import study.nigmat.boot.springboot.service.UserService;

import java.util.List;

@Controller
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getUsers(Model model) {
        List<User> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "pages/users";
    }

    @GetMapping("/new")
    public String addNewUser(@ModelAttribute("user") User user) {
        return "pages/new";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "pages/edit";
    }



    @PostMapping("/")
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "pages/new";
        userService.add(user);
        return "redirect:/";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute ("user") @Valid User user,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) return "pages/edit";
        userService.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/";
    }

}
