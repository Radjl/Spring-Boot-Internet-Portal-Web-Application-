package controllers;


import models.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import repository.shipRepo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
public class ChronologyController {

    @Autowired
    private shipRepo shipRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/chronology")
    public String main(Model model){

        Iterable<Ship> ships = shipRepo.findAllByOrderByIdDesc();


        model.addAttribute("ships",ships);
        return "shipshome";
    }





        @PostMapping("/chronology")
        public String add(@RequestParam String shipname, @RequestParam String description, @RequestParam("file") MultipartFile file, Model model) throws IOException {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Ship ship = new Ship(shipname,description,timeStamp);



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



        Iterable<Ship> ships = shipRepo.findAllByOrderByIdDesc();
        model.addAttribute("ships", ships);

        return "shipshome";
    }





    @PostMapping("/filter")
    public String find(@RequestParam String filter, Model model){
        Iterable<Ship> ships = null;
        if (filter !=null && !filter.isEmpty()) {
            ships = shipRepo.findByShipnameOrDescription(filter,filter);
        }else
            ships = shipRepo.findAll();
        model.addAttribute("ships", ships);

        return "shipshome";
    }




    @GetMapping("/chronology/{ship}")
    public String shipDetail(@PathVariable Ship ship, Model model){

        model.addAttribute("ship",ship);
        return "shipsdetail";
    }


    @PostMapping("/chronology/delete/{ship}")
    public String deleteShip(@PathVariable Ship ship, Model model){
        shipRepo.delete(ship);
        return "redirect:/chronology";
    }














    /*
    @GetMapping("/chronology")
    public String pager(Model model ,@PageableDefault(sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable){

        Page<Ship> page;


        page = shipRepo.findAll(pageable);


        model.addAttribute("page",page);
        model.addAttribute("url","/chronology");
        model.addAttribute("page",page);
        return "shipshome";
    }


@PostMapping("/chronology/{ship}")
    public String edit(@PathVariable Ship ship, @RequestParam("images") MultipartFile image, Model model) throws IOException {

        Ship shipfromDb = shipRepo.findShipsById(ship.getId());

        if (image !=null){
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()){
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String result = uuidFile + "." + image.getOriginalFilename();

            image.transferTo(new File(uploadPath + "/" + result));
            shipfromDb.getImages().add(result);

        }



        shipRepo.save(shipfromDb);



        Ship ships = shipRepo.findShipsById(shipfromDb.getId());
        model.addAttribute("ships", ships);

        return "shipsdetail";
    }

*/

}
