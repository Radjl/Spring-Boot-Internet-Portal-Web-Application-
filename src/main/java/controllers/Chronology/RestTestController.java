package controllers.Chronology;


import models.ItemIt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.InventoryItRepo;

import java.util.List;

@RestController
public class RestTestController {


    @Autowired
    private InventoryItRepo inventoryIt;

    @Autowired
    private repository.shipRepo shipRepo;

    @Autowired
    private services.ShipService ShipService;



    @GetMapping("/chro")
    public List<ItemIt> main(Model model) {




        return inventoryIt.findAll();
    }





}
