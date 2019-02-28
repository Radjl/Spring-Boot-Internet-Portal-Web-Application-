package controllers.Users;

import models.Role;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.UserRepo;
import services.UserService;

import java.util.Collections;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @RequestMapping("/admin")
    public String main(Model model){

        Iterable<User> userRepoAll = userRepo.findAll();
        model.addAttribute("users",userRepoAll);

        return "admin";
    }


    @PostMapping("/register")
    public String addUser(User user, Model model){

        User userFromDb = userService.addUser(user);

            if (userFromDb != null){
                model.addAttribute("message","Такой пользователь уже существует , введите другое имя!");
                return "redirect:/admin";
            }
                user.setActive(true);
                user.setRoles(Collections.singleton(Role.USER));
                userRepo.save(user);





        return "redirect:/admin";
    }

    @GetMapping("/user/delete/{user}")
    // PathVariable - по переданному айдишнику пользователя находит пользователя в базе данных
    public String DeleteUser(@PathVariable User user, Model model){

        userRepo.delete(user);

        Iterable<User> userRepoAll = userRepo.findAll();
        model.addAttribute("users",userRepoAll);
        return "admin";
    }



}
