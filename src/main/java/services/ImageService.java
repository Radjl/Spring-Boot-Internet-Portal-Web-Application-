package services;


import models.Images;
import models.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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


    public void addPhotoToShip(Ship shipfromDb, MultipartFile image, String name, String uploadPath) throws IOException {

        if (image !=null){
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()){
                uploadDir.mkdir();
            }





            String uuidFile = UUID.randomUUID().toString();
            String result = uuidFile + "." + image.getOriginalFilename();
            image.transferTo(new File(uploadPath + "/" +  result));

            Images images = new Images();
            images.setImage(result);

            images.setName(name);

            images.setShip(shipfromDb);
            shipfromDb.getImages().add(images);

        }


    }
}
