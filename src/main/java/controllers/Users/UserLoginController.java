package controllers.Users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserLoginController {


    @RequestMapping("/logout")
    public String logout(){
        return "main";
    }






}
