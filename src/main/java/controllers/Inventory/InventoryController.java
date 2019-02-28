package controllers.Inventory;


import models.ItemIt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repository.InventoryItRepo;
import services.ItemsService;

@Controller
public class InventoryController {

    @Autowired
    private InventoryItRepo inventoryIt;

    @Autowired
    private ItemsService itemsService;



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
    public String add(Model model, @RequestParam("name")String name){

        itemsService.addItem(name);
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
