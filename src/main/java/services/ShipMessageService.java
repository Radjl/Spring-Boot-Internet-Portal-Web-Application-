package services;

import models.Ship;
import models.shipMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipMessageService {


    @Autowired
    private repository.shipRepo shipRepo;


    public void deleteMessageFromShip(Long imageId , Long shipId){
        Ship ship = shipRepo.findShipsById(shipId);
        List<shipMessage> messages = ship.getShipmessage();

        for (int i = 0; i <messages.size() ; i++) {
            if (imageId.equals(messages.get(i).getId())){
                messages.remove(i);
                shipRepo.save(ship);
            }
        }

    }




    public void updatemessage(Long messageId, Long shipId, String text) {

        Ship ship = shipRepo.findShipsById(shipId);


        shipMessage shipMessage = new shipMessage();
        shipMessage.setText(text);


        List<shipMessage> messages = ship.getShipmessage();

        for (int i = 0; i <messages.size() ; i++) {
            if (messageId.equals(messages.get(i).getId())){
                messages.remove(i);
                messages.add(shipMessage);
                shipMessage.setShip(ship);
                shipRepo.save(ship);
            }
        }



    }
}
