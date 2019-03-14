package controllers.Inventory;


import models.ItemIt;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import repository.InventoryItRepo;
import services.ExcelHelper;
import services.ItemsService;

import java.io.IOException;
import java.text.ParseException;

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
    public String add(Model model, @RequestParam("name")String name,
                                   @RequestParam("usefull")int usefulllife,
                                   @RequestParam("date")String date,
                                   @RequestParam("invent")String invent,
                                   @RequestParam("serial")String serial,
                                   @RequestParam("dislocation")String dislocation,
                                   MultipartFile file) throws IOException, ParseException {


        System.out.println(date);
        itemsService.addItem(name,file,uploadPath,usefulllife,date,invent,serial,dislocation);

        Iterable<ItemIt> inventory = itemsService.findall();


        model.addAttribute("inventory",inventory);
        return "inventoryIt";
    }





    @PostMapping("/inventory/it/delete")
    public String delete(@RequestParam("hiddenValue") int id){



        itemsService.deleteItemById(id);
        return "redirect:/inventory/it";
    }



    @RequestMapping("/inventory/it/delete/{itemIt}")
    public String deletefromOptions(@PathVariable ItemIt itemIt){
        inventoryIt.delete(itemIt);

        return "redirect:/inventory/it";
    }




    @PostMapping("/inventory/properties/{ItemIt}")
    // PathVariable - по переданному айдишнику пользователя находит пользователя в базе данных
    public String updateItem(@PathVariable ItemIt ItemIt, Model model,
                             @RequestParam(value = "checkbox",required = false) Boolean checkbox,
                             @RequestParam(value = "text", required = false) String text,
                             @RequestParam(value = "firstbroke",required = false) String firstbroke,
                             @RequestParam(value = "secondbroke",required = false) String secondbroke,
                             @RequestParam(value = "thirdbroke",required = false) String thirdbroke,
                             @RequestParam(value = "photo",required = false) MultipartFile file) throws IOException {
        Boolean notChecked = false;




        if (checkbox !=null)
        itemsService.updateDeatil(checkbox,ItemIt,firstbroke,secondbroke,thirdbroke,file);
        else
            itemsService.updateDeatil(notChecked,ItemIt,firstbroke,secondbroke,thirdbroke,file);







        Iterable<ItemIt> inventory = itemsService.findall();
        model.addAttribute("inventory",inventory);

        return "redirect:/inventory/it";
    }













    @PostMapping("/inventory/it/excel")
    public String excelTest(@RequestParam("excel") MultipartFile reapExcelDataFile,Model model) throws IOException, InvalidFormatException {


        ExcelHelper excelHelper = new ExcelHelper(reapExcelDataFile);
        Iterable<ItemIt>  readylist = excelHelper.processExcel();
        inventoryIt.saveAll(readylist);

        Iterable<ItemIt> inventory = itemsService.findall();
        model.addAttribute("inventory",inventory);
        return "redirect:/inventory/it";
    }




    @PostMapping("/inventory/it/deleteall")
    public String deleteAll(Model model){

        inventoryIt.deleteAll();

        Iterable<ItemIt> inventory = itemsService.findall();
        model.addAttribute("inventory",inventory);
        return "redirect:/inventory/it";
    }


    @GetMapping("/inventory/kipia")
    public String kipia(Model model){



        return "inventoryKipia";
    }


}
