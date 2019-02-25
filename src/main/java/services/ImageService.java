package services;


import models.Images;
import models.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    private repository.shipRepo shipRepo;


    public void deleteImageFromShip(Long imageId , Long shipId){
        Ship ship = shipRepo.findShipsById(shipId);
        List<Images> images = ship.getImages();

        for (int i = 0; i <images.size() ; i++) {
            if (imageId.equals(images.get(i).getId())){
                images.remove(i);
                shipRepo.save(ship);
            }
        }

    }






}
