package controllers;


import models.Agents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import services.RestService;

import java.util.List;

@Controller
public class Rest1c {


    @Autowired
    private RestService restService;


    @RequestMapping("/rest/")
    public String test(Model model){

      //  Quote quote = restService.getJson();

        ResponseEntity<List<Agents>> responseEntity = restService.getJson();


        List<Agents> coins = responseEntity.getBody();

        model.addAttribute("tests",coins);



        /*
        restTemplate.exchange("
         http://localhost:8080/products", HttpMethod.GET, entity, String.class).getBody();
         */


        return "test";
    }


}
