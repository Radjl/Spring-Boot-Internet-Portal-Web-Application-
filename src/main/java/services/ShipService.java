package services;


import models.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class ShipService {

    @Autowired
    private repository.shipRepo shipRepo;


    public void addShip(String shipname, String description, String uploadPath, MultipartFile file) throws IOException {


        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Ship ship = new Ship();

        ship.setShipname(shipname);
        ship.setDescription(description);
        ship.setTimeStamp(timeStamp);




        if (file !=null){
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()){
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String result = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + result));
            ship.setImg(result);

        }



        shipRepo.save(ship);


    }

    public Iterable<Ship> FindByFilter(String filter) {

        if (filter !=null && !filter.isEmpty()) {
            return shipRepo.findByShipnameContainsOrDescriptionIsContaining(filter,filter);
        }else
           return  shipRepo.findAll();



    }
}
