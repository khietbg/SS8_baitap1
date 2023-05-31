package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ra.model.entity.User;
import ra.model.service.UserServiceIpm;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserServiceIpm userServiceIpm;
    @GetMapping("/")
    public String showListUser(Pageable pageable, Model model, Sort sort){
        Page<User> users = userServiceIpm.findAll(pageable,sort);
        model.addAttribute("list",users);
        return "/listUser";
    }
    @GetMapping("/formCreate")
    public String formCreate(Model model){
        model.addAttribute("newUser",new User());
        return "/createUser";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("newUser")User user, BindingResult rs){
        if (rs.hasErrors()){
            return "/createUser";
        }else {
            userServiceIpm.save(user);
            return "redirect:/";
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id")Long id){
        userServiceIpm.delete(id);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id")Long id,Model model){
        User user = userServiceIpm.findById(id).get();
        model.addAttribute("user",user);
        return "/updateUser";
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("user")User user,BindingResult rs,Model model){
        if (rs.hasErrors()){
            model.addAttribute("user",user);
            return "/updateUser";
        }else {
            userServiceIpm.save(user);
            return "redirect:/";
        }
    }
}
