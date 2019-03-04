package controllers.Chronology;


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

import java.io.IOException;

@Controller
public class ImagesController {

    @Autowired
    private shipRepo shipRepo;

    @Autowired ImageRepo imageRepo;

    @Value("${upload.pathship}")
    private String uploadPath;

    @Autowired
    private ImageService imageService;



    @PostMapping("/chronology/addPhoto/{ship}")
    public String edit(@PathVariable Ship ship, @RequestParam("image") MultipartFile image,@RequestParam("name") String name, Model model) throws IOException {

        Ship shipfromDb = shipRepo.findShipsById(ship.getId());

        imageService.addPhotoToShip(shipfromDb,image,name,uploadPath);
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



