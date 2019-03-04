package controllers.Inventory;


import models.ItemIt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import repository.InventoryItRepo;
import services.ItemsService;

import java.io.IOException;

@Controller
public class InventoryController {

    @Autowired
    private InventoryItRepo inventoryIt;

    @Autowired
    private ItemsService itemsService;

    @Value("${upload.pathinventory}")
    private String uploadPath;




    @GetMapping("/inventory")
    public String main(Model model){
        return "inventoryMenu";
    }



    @GetMapping("/inventory/it")
    public String it(Model model){
        Iterable<ItemIt> inventory = itemsService.findall();


        model.addAttribute("inventory",inventory);
        return "inventoryIt";
    }




    @PostMapping("/inventory/it")
    public String add(Model model, @RequestParam("name")String name, MultipartFile file) throws IOException {

        itemsService.addItem(name,file,uploadPath);

        Iterable<ItemIt> inventory = itemsService.findall();


        model.addAttribute("inventory",inventory);
        return "inventoryIt";
    }







    @PostMapping("/inventory/it/delete")
    public String delete(@RequestParam("hiddenValue") String id){

        itemsService.deleteItemById(id);
        return "redirect:/inventory/it";
    }









    @GetMapping("/inventory/kipia")
    public String kipia(Model model){



        return "inventoryKipia";
    }


}
