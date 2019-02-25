package controllers;


import models.Images;
import models.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import repository.ImageRepo;
import repository.shipRepo;
import services.ImageService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class ImagesController {

    @Autowired
    private shipRepo shipRepo;

    @Autowired ImageRepo imageRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private ImageService imageService;



    @PostMapping("/chronology/addPhoto/{ship}")
    public String edit(@PathVariable Ship ship, @RequestParam("image") MultipartFile image,@RequestParam("name") String name, Model model) throws IOException {

        Ship shipfromDb = shipRepo.findShipsById(ship.getId());

        if (image !=null){
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()){
                uploadDir.mkdir();
            }


         //   String result = image.getOriginalFilename();


            String uuidFile = UUID.randomUUID().toString();
            String result = uuidFile + "." + image.getOriginalFilename();
          //  image.transferTo(new File(uploadPath + "/" + shipfromDb.getShipname() + shipfromDb.getId() + "/" + result));
            image.transferTo(new File(uploadPath + "/" + result));

            Images images = new Images();
            images.setImage(result);

            images.setName(name);

            images.setShip(shipfromDb);
            shipfromDb.getImages().add(images);

        }



        shipRepo.save(shipfromDb);



        Ship ships = shipRepo.findShipsById(shipfromDb.getId());
        model.addAttribute("ships", ships);

        return "shipsdetail";
    }



    @PostMapping("/chronology/deleteimage/{image}")
        public String deleteImage(@PathVariable Images image, Model model,@RequestParam("shipId") Long shipId){


            imageService.deleteImageFromShip(image.getId(),shipId);
            model.addAttribute("ship",shipRepo.findShipsById(shipId));



            return "shipsdetail";
        }

        }



