package controllers;


import models.Ship;
import models.shipMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repository.MessageRepo;
import services.ShipMessageService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ShipMessageController {


    @Autowired
    private repository.shipRepo shipRepo;

    @Autowired
    MessageRepo messageRepo;


    @Autowired
    private ShipMessageService shipMessageService;




    @PostMapping("/chronology/addMessage/{ship}")
    public String addMessage(@PathVariable Ship ship,@RequestParam("message") String message, Model model) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Ship shipfromDb = shipRepo.findShipsById(ship.getId());


            shipMessage message1 = new shipMessage(message,timeStamp);
            message1.setShip(shipfromDb);
            shipfromDb.getShipmessage().add(message1);
            shipRepo.save(shipfromDb);

        Ship ships = shipRepo.findShipsById(shipfromDb.getId());
        model.addAttribute("ship", ships);
        return "shipsdetail";
        }


    @PostMapping("/chronology/deletemessage/{message}")
    public String deleteMessage(@PathVariable shipMessage message, Model model, @RequestParam("shipId") Long shipId){


        shipMessageService.deleteMessageFromShip(message.getId(),shipId);
        model.addAttribute("ship",shipRepo.findShipsById(shipId));



        return "shipsdetail";
    }




    @PostMapping("/chronology/editmessage/{ship}")
    // PathVariable - по переданному айдишнику пользователя находит пользователя в базе данных
    public String updateMessage(@PathVariable Ship ship, Model model,  @RequestParam("messageId") Long messageId,@RequestParam("message1") String text){
        Ship shipfromDb = shipRepo.findShipsById(ship.getId());



        System.out.println(text);
        shipMessageService.updatemessage(messageId,ship.getId(),text);


        model.addAttribute("ship", shipfromDb);

        return "shipsdetail";
    }



    }



