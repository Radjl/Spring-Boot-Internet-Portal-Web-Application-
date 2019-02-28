package controllers.Users;


import models.Role;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.UserRepo;
import services.UserService;

import java.util.Map;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;


    @GetMapping("{user}")
    // PathVariable - по переданному айдишнику пользователя находит пользователя в базе данных
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user",user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }



    @PostMapping("{user}")
    // PathVariable - по переданному айдишнику пользователя находит пользователя в базе данных
    public String userUpdate(@PathVariable User user, Model model, @RequestParam String username, @RequestParam Map<String,String> form){

        User usreFromDb = userRepo.findUserById(user.getId());
        if (usreFromDb != null){
            userService.updateUserName(usreFromDb,username,form);

            model.addAttribute("user",usreFromDb);
            model.addAttribute("roles", Role.values());
            return "userEdit";
        }


        model.addAttribute("user",usreFromDb);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }


}
