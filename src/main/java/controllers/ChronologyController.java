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
import services.ShipService;

import java.io.IOException;

@Controller
public class ChronologyController {

    @Autowired
    private shipRepo shipRepo;

    @Autowired
    private ShipService ShipService;

    @Value("${upload.path}")
    private String uploadPath;





        /*  Находим все суда , порядок первый с конца.   */
        @GetMapping("/chronology")
        public String main(Model model){

        Iterable<Ship> ships = shipRepo.findAllByOrderByIdDesc();
        model.addAttribute("ships",ships);
        return "shipshome";
    }





        /*  Добавляем новое судно и загружаем фото   */
        @PostMapping("/chronology")
        public String addShip(@RequestParam String shipname, @RequestParam String description, @RequestParam("file") MultipartFile file, Model model) throws IOException {

        ShipService.addShip(shipname,description,uploadPath,file);

        Iterable<Ship> ships = shipRepo.findAllByOrderByIdDesc();
        model.addAttribute("ships", ships);

        return "shipshome";
    }





    /*  Ищем судно по частичному совпадению имени  или описанию   */
    @PostMapping("/filter")
    public String find(@RequestParam String filter, Model model){

        Iterable<Ship> ships = ShipService.FindByFilter(filter);
        model.addAttribute("ships", ships);

        return "shipshome";
    }




    /*  Переходим в детальное отображение судна переданного по ID   */
    @GetMapping("/chronology/{ship}")
    public String shipDetail(@PathVariable Ship ship, Model model){

        model.addAttribute("ship",ship);
        return "shipsdetail";
    }


    /*  Удаляем судно по переданному ID   */
    @PostMapping("/chronology/delete/{ship}")
    public String deleteShip(@PathVariable Ship ship, Model model){
        shipRepo.delete(ship);
        return "redirect:/chronology";
    }


}

