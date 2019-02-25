package controllers;


import models.Role;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.UserRepo;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    @Autowired
    UserRepo userRepo;


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
            usreFromDb.setUsername(username);

            Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());

            usreFromDb.getRoles().clear();
            for (String key: form.keySet()
                 ) {
                if (roles.contains(key)){
                    usreFromDb.getRoles().add(Role.valueOf(key));
                }

            }

            userRepo.save(usreFromDb);
            model.addAttribute("user",usreFromDb);
            model.addAttribute("roles", Role.values());
            return "userEdit";
        }
        model.addAttribute("user",usreFromDb);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }


}
